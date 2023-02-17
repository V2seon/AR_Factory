package com.elfe.arfactory.admin.controller;

import com.elfe.arfactory.admin.common.SessionCheck;
import com.elfe.arfactory.admin.entity.UserEntity;
import com.elfe.arfactory.admin.repository.UserRepository;
import com.elfe.arfactory.common.Pagination;
import com.elfe.arfactory.promotion.common.AES_256;
import com.elfe.arfactory.promotion.entity.Af_inqEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_1Entity;
import com.elfe.arfactory.promotion.entity.Af_reviewEntity;
import com.elfe.arfactory.promotion.repository.Af_inqRepository;
import com.elfe.arfactory.promotion.repository.Af_project_info_1Repository;
import com.elfe.arfactory.promotion.service.Af_inqService;
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
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/inq")
public class AInqController {

    private UserRepository userRepository;
    private Af_project_info_1Repository api1Repository;
    private Af_inqRepository aiRepository;
    private Af_inqService aiService;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName()); // log찍기용

    // 문의 목록
    @GetMapping("/list")
    public String InquiryList(Model m, HttpServletRequest request, Pageable pageable,
                              @RequestParam(required = false, defaultValue = "0", value = "page") int page) {
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            HttpSession session = request.getSession();
            Optional<UserEntity> s1 = userRepository.findByAaid((String) session.getAttribute("userid"));
            pageable = PageRequest.of(page, 10, Sort.by("AI_SEQ").descending());

            // 패키지 이름 담기
            List<Af_project_info_1Entity> getdata = api1Repository.getAPI1AllData();
            Map<Long,String> seqname = new HashMap<Long,String>();
            for (int i=0;i<getdata.size();i++){
                seqname.put(getdata.get(i).getAPI1_SEQ(),getdata.get(i).getAPI1_NAME());
            }

            // 전화번호 복호화
            AES_256 aes256 = null;
            Map<Long,String> phon = new HashMap<Long,String>();
            try {
                aes256 = new AES_256();
                String phonNum;
                List<Af_inqEntity> getdata2 = aiRepository.getAIAllData();
                for (int i=0;i<getdata2.size();i++){
                    phonNum = aes256.AesCBCDecode(getdata2.get(i).getAI_PHONE());
                    phon.put(getdata2.get(i).getAI_SEQ(),phonNum);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Page<Af_inqEntity> aiEntities = aiService.getAIList(pageable);
            Pagination pagination = new Pagination(aiEntities.getTotalPages(), page);

            m.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            m.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            m.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            m.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            m.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            m.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            m.addAttribute("s1", s1);
            m.addAttribute("inqlist", aiEntities); //페이지 객체 리스트
            m.addAttribute("seqname", seqname); //페이지 객체 리스트
            m.addAttribute("phon", phon); //페이지 객체 리스트

            returnValue = "/admin/inq/list.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 문의 수정
    @GetMapping("/edit")
    public String InquiryEdit(Model m, HttpServletRequest request,
                              @RequestParam(required = false, defaultValue = "", value = "no") Long no) {
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            Af_inqEntity aiEntity = aiRepository.getAIData(no);
            List <Af_project_info_1Entity> getdata = api1Repository.getAPI1AllData();

            // 복호화
            AES_256 aes256 = null;
            String aes256CbcDeocde = "";
            try {
                aes256 = new AES_256();
                aes256CbcDeocde = aes256.AesCBCDecode(aiEntity.getAI_PHONE());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


            m.addAttribute("seq", aiEntity.getAI_SEQ());
            m.addAttribute("pac", aiEntity.getAPI1_SEQ());
            m.addAttribute("name", aiEntity.getAI_NAME());
            m.addAttribute("phon", aes256CbcDeocde);
            m.addAttribute("opt", aiEntity.getAI_OPT());
            m.addAttribute("state", aiEntity.getAI_STATE());
            m.addAttribute("state2", aiEntity.getAI_STATE2());
            m.addAttribute("data", getdata); //페이지 객체 리스트

            returnValue = "/admin/inq/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 문의 수정 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public HashMap<String, String> InquiryEditData(Model m, HttpServletRequest request,
                                                  @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                  @RequestParam(required = false, defaultValue = "", value = "pac") Long pac,
                                                  @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                  @RequestParam(required = false, defaultValue = "", value = "phon") String phon,
                                                  @RequestParam(required = false, defaultValue = "", value = "state") int state,
                                                  @RequestParam(required = false, defaultValue = "", value = "state2") int state2,
                                                  @RequestParam(required = false, defaultValue = "", value = "opt") int opt)throws Exception {
        log.info(pac+"/"+state+"/"+state2+"/"+opt);
        Af_inqEntity aiEtt1 = aiRepository.getAIData(no);
        String timecheck = String.valueOf(aiEtt1.getAI_UDATETIME());
        LocalDateTime sdf = LocalDateTime.now();

        // 암호화
        AES_256 aes256 = new AES_256();
        String aes256CbcEncode = aes256.AesCBCEncode(phon);
        aiRepository.updateAIData(no, pac, name, aes256CbcEncode, opt, state, state2, sdf);

        Af_inqEntity aiEtt2 = aiRepository.getAIData(no);
        HashMap<String, String> msg = new HashMap<String, String>();
        if(String.valueOf(aiEtt2.getAI_UDATETIME()).equals(timecheck)){
            msg.put("save", "0");
        }else {
            msg.put("save", "1");
        }
        return msg;
    }
}
