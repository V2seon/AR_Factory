package com.elfe.arfactory.admin.controller;

import com.elfe.arfactory.admin.common.SessionCheck;
import com.elfe.arfactory.admin.entity.UserEntity;
import com.elfe.arfactory.admin.repository.UserRepository;
import com.elfe.arfactory.common.Pagination;
import com.elfe.arfactory.promotion.common.AES_256;
import com.elfe.arfactory.promotion.dto.Af_reviewDto;
import com.elfe.arfactory.promotion.entity.Af_project_info_1Entity;
import com.elfe.arfactory.promotion.entity.Af_reviewEntity;
import com.elfe.arfactory.promotion.repository.Af_project_info_1Repository;
import com.elfe.arfactory.promotion.repository.Af_reviewRepository;
import com.elfe.arfactory.promotion.service.Af_reviewService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/review")
public class AReviewController {

    private UserRepository userRepository;
    private Af_project_info_1Repository api1Repository;
    private Af_reviewRepository afReviewRepository;
    private Af_reviewService afReviewService;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName()); // log찍기용

    // 후기 정보 목록
    @GetMapping("/list")
    public String ReviewList(Model m, HttpServletRequest request, Pageable pageable,
                             @RequestParam(required = false, defaultValue = "0", value = "page") int page) {
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            HttpSession session = request.getSession();
            Optional<UserEntity> s1 = userRepository.findByAaid((String) session.getAttribute("userid"));
            pageable = PageRequest.of(page, 10, Sort.by("AR_SEQ").descending());

            List <Af_project_info_1Entity> getdata = api1Repository.getAPI1AllData();
            Map<Long,String> seqname = new HashMap<Long,String>();
            for (int i=0;i<getdata.size();i++){
                seqname.put(getdata.get(i).getAPI1_SEQ(),getdata.get(i).getAPI1_NAME());
            }

            Page<Af_reviewEntity> afReviewEntities = afReviewService.getARList(pageable);
            Pagination pagination = new Pagination(afReviewEntities.getTotalPages(), page);

            m.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            m.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            m.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            m.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            m.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            m.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            m.addAttribute("s1", s1);
            m.addAttribute("reviewlist", afReviewEntities); //페이지 객체 리스트
            m.addAttribute("seqname", seqname); //페이지 객체 리스트

            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/review/list.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 후기 등록
    @GetMapping("/add")
    public String ReviewAdd(Model m, HttpServletRequest request) {
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            List <Af_project_info_1Entity> getdata = api1Repository.getAPI1AllData();

            m.addAttribute("data", getdata); //페이지 객체 리스트
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/review/add.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 후기 등록 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public HashMap<String, String> ReviewAddData(Model m, HttpServletRequest request,
                                                   @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                   @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                   @RequestParam(required = false, defaultValue = "", value = "pw") String pw,
                                                   @RequestParam(required = false, defaultValue = "", value = "text") String text,
                                                   @RequestParam(required = false, defaultValue = "", value = "show") int show,
                                                   @RequestParam(required = false, defaultValue = "", value = "star") String star)throws Exception {
        int checknum = afReviewRepository.checkARData(name);
        // 암호화
        AES_256 aes256 = new AES_256();
        String aes256CbcEncode = aes256.AesCBCEncode(pw);
        System.out.println(aes256CbcEncode);

        // 복호화
//        String aes256CbcDeocde = aes256.AesCBCDecode(aes256CbcEncode);

        float starval = (float) Double.parseDouble(star);

        LocalDateTime sdf = LocalDateTime.now();

        Af_reviewDto af_reviewDto = new Af_reviewDto(null, no, name, text, starval, aes256CbcEncode, show, sdf, sdf);
        afReviewService.save(af_reviewDto);

        HashMap<String, String> msg = new HashMap<String, String>();
        if(afReviewRepository.checkARData(name)!=checknum){
            msg.put("save", "1");
        }else {
            msg.put("save", "0");
        }
        return msg;
    }

    // 후기 수정
    @GetMapping("/edit")
    public String ReviewEdit(Model m, HttpServletRequest request,
                             @RequestParam(required = false, defaultValue = "", value = "no") Long no) {
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            Af_reviewEntity arEntity = afReviewRepository.getARData(no);
            List <Af_project_info_1Entity> getdata = api1Repository.getAPI1AllData();

            m.addAttribute("seq", arEntity.getAR_SEQ());
            m.addAttribute("pac", arEntity.getAPI1_SEQ());
            m.addAttribute("name", arEntity.getAR_NAME());
            m.addAttribute("text", arEntity.getAR_CONTENT());
            m.addAttribute("star", arEntity.getAR_STAR());
            m.addAttribute("state", arEntity.getAR_STATE());

            m.addAttribute("data", getdata); //페이지 객체 리스트

            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/review/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 후기 수정 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public HashMap<String, String> ReviewEditData(Model m, HttpServletRequest request,
                                                  @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                  @RequestParam(required = false, defaultValue = "", value = "pac") Long pac,
                                                 @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                 @RequestParam(required = false, defaultValue = "", value = "pw") String pw,
                                                 @RequestParam(required = false, defaultValue = "", value = "text") String text,
                                                 @RequestParam(required = false, defaultValue = "", value = "show") int show,
                                                 @RequestParam(required = false, defaultValue = "", value = "star") String star)throws Exception {
        Af_reviewEntity arEtt1 = afReviewRepository.getARData(no);
        String timecheck = String.valueOf(arEtt1.getAR_UDATETIME());

        float starval = (float) Double.parseDouble(star);
        LocalDateTime sdf = LocalDateTime.now();

        if(pw==""&&pw==null){
            afReviewRepository.updateARData(no, pac, name, text, starval, show, sdf);
        }else {
            // 암호화
            AES_256 aes256 = new AES_256();
            String aes256CbcEncode = aes256.AesCBCEncode(pw);
            afReviewRepository.updateARData(no, pac, name, text, starval, aes256CbcEncode, show, sdf);
        }

        Af_reviewEntity arEtt2 = afReviewRepository.getARData(no);
        HashMap<String, String> msg = new HashMap<String, String>();
        if(String.valueOf(arEtt2.getAR_UDATETIME()).equals(timecheck)){
            msg.put("save", "0");
        }else {
            msg.put("save", "1");
        }
        return msg;
    }

    // 후기 삭제
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public HashMap<String, String> solutionDeleteData(Model m, HttpServletRequest request,
                                                      @RequestParam(required = false, defaultValue = "", value = "no") Long no) {
        afReviewRepository.deleteARData(no);

        HashMap<String, String> msg = new HashMap<String, String>();
        if(afReviewRepository.checkARSeq(no)==0){
            msg.put("save", "1");
        }else {
            msg.put("save", "0");
        }
        return msg;
    }
}
