package com.elfe.arfactory.admin.controller;

import com.elfe.arfactory.admin.common.SessionCheck;
import com.elfe.arfactory.admin.entity.UserEntity;
import com.elfe.arfactory.admin.repository.UserRepository;
import com.elfe.arfactory.admin.service.AFDetailService;
import com.elfe.arfactory.admin.service.API1Service;
import com.elfe.arfactory.common.Pagination;
import com.elfe.arfactory.promotion.dto.*;
import com.elfe.arfactory.promotion.entity.*;
import com.elfe.arfactory.promotion.repository.*;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/detail")
public class ADetailController {

    private API1Service api1Service;
    private AFDetailService afDetailService;
    private UserRepository userRepository;
    private Af_project_info_2Repository api2Repository;
    private Af_project_info_2_eRepository api2eRepository;
    private Af_project_info_3Repository api3Repository;
    private Af_project_info_3_eRepository api3eRepository;
    private Af_project_info_4Repository api4Repository;
    private Af_project_info_4_eRepository api4eRepository;
    private Af_project_info_5Repository api5Repository;
    private Af_project_info_5_eRepository api5eRepository;
    private Af_project_info_6Repository api6Repository;
    private Af_project_info_6_eRepository api6eRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName()); // log찍기용

    @GetMapping("/list")
    public String DetailList(Model m, HttpServletRequest request, Pageable pageable,
                             @RequestParam(required = false, defaultValue = "0", value = "page") int page) {
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            HttpSession session = request.getSession();
            Optional<UserEntity> s1 = userRepository.findByAaid((String) session.getAttribute("userid"));
            pageable = PageRequest.of(page, 10, Sort.by("API1_SEQ").descending());
            Page<Af_project_info_1Entity> api1Entities = api1Service.getAPI1List(pageable);
            Pagination pagination = new Pagination(api1Entities.getTotalPages(), page);

            List<Af_project_info_2Entity> api2data = api2Repository.getAPI2AllData();
            List<Af_project_info_2_eEntity> api2edata = api2eRepository.getAPI2EAllData();
            List<Af_project_info_3Entity> api3data = api3Repository.getAPI3AllData();
            List<Af_project_info_3_eEntity> api3edata = api3eRepository.getAPI3EAllData();
            List<Af_project_info_4Entity> api4data = api4Repository.getAPI4AllData();
            List<Af_project_info_4_eEntity> api4edata = api4eRepository.getAPI4EAllData();
            List<Af_project_info_5Entity> api5data = api5Repository.getAPI5AllData();
            List<Af_project_info_5_eEntity> api5edata = api5eRepository.getAPI5EAllData();
            List<Af_project_info_6Entity> api6data = api6Repository.getAPI6AllData();
            List<Af_project_info_6_eEntity> api6edata = api6eRepository.getAPI6EAllData();

            Map<Long,Long> api2 = new HashMap<Long,Long>();
            Map<Long,Long> api2e = new HashMap<Long,Long>();
            Map<Long,Long> api3 = new HashMap<Long,Long>();
            Map<Long,Long> api3e = new HashMap<Long,Long>();
            Map<Long,Long> api4 = new HashMap<Long,Long>();
            Map<Long,Long> api4e = new HashMap<Long,Long>();
            Map<Long,Long> api5 = new HashMap<Long,Long>();
            Map<Long,Long> api5e = new HashMap<Long,Long>();
            Map<Long,Long> api6 = new HashMap<Long,Long>();
            Map<Long,Long> api6e = new HashMap<Long,Long>();

            for(int i=0;i<api2data.size();i++){api2.put(api2data.get(i).getAPI1_SEQ(),api2data.get(i).getAPI2_SEQ());}
            for(int i=0;i<api2edata.size();i++){api2e.put(api2edata.get(i).getAPI1_SEQ(),api2edata.get(i).getAPI2E_SEQ());}
            for(int i=0;i<api3data.size();i++){api3.put(api3data.get(i).getAPI1_SEQ(),api3data.get(i).getAPI3_SEQ());}
            for(int i=0;i<api3edata.size();i++){api3e.put(api3edata.get(i).getAPI1_SEQ(),api3edata.get(i).getAPI3E_SEQ());}
            for(int i=0;i<api4data.size();i++){api4.put(api4data.get(i).getAPI1_SEQ(),api4data.get(i).getAPI4_SEQ());}
            for(int i=0;i<api4edata.size();i++){api4e.put(api4edata.get(i).getAPI1_SEQ(),api4edata.get(i).getAPI4E_SEQ());}
            for(int i=0;i<api5data.size();i++){api5.put(api5data.get(i).getAPI1_SEQ(),api5data.get(i).getAPI5_SEQ());}
            for(int i=0;i<api5edata.size();i++){api5e.put(api5edata.get(i).getAPI1_SEQ(),api5edata.get(i).getAPI5E_SEQ());}
            for(int i=0;i<api6data.size();i++){api6.put(api6data.get(i).getAPI1_SEQ(),api6data.get(i).getAPI6_SEQ());}
            for(int i=0;i<api6edata.size();i++){api6e.put(api6edata.get(i).getAPI1_SEQ(),api6edata.get(i).getAPI6E_SEQ());}

            m.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            m.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            m.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            m.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            m.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            m.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            m.addAttribute("s1", s1);
            m.addAttribute("solutionlist", api1Entities); //페이지 객체 리스트
            m.addAttribute("api2", api2);
            m.addAttribute("api2e", api2e);
            m.addAttribute("api3", api3);
            m.addAttribute("api3e", api3e);
            m.addAttribute("api4", api4);
            m.addAttribute("api4e", api4e);
            m.addAttribute("api5", api5);
            m.addAttribute("api5e", api5e);
            m.addAttribute("api6", api6);
            m.addAttribute("api6e", api6e);

            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/list.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }


    // 등록페이지 이동
    @GetMapping("/add")
    public String DetailAdd(Model m, HttpServletRequest request,
                               @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                               @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                               @RequestParam(required = false, defaultValue = "", value = "details") String details) {
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("no", no);
            m.addAttribute("Lang", lang);
            returnValue = "/admin/detail/"+details+"/add.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }


    // 수정페이지 이동
    @GetMapping("/edit")
    public String DetailEdit(Model m, HttpServletRequest request,
                             @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                             @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                             @RequestParam(required = false, defaultValue = "", value = "details") String details) {
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            if(details.equals("contents")){
                if(lang.equals("kor")){
                    Af_project_info_2Entity api2Entity = api2Repository.getAPI2Data(no);

                    m.addAttribute("seq", api2Entity.getAPI2_SEQ());
                    m.addAttribute("no", api2Entity.getAPI1_SEQ());
                    m.addAttribute("contents", api2Entity.getAPI2_CONTENTS());
                    m.addAttribute("img1", api2Entity.getAPI2_IMG1());
                    m.addAttribute("img2", api2Entity.getAPI2_IMG2());
                    m.addAttribute("img3", api2Entity.getAPI2_IMG3());
                    m.addAttribute("img4", api2Entity.getAPI2_IMG4());
                    m.addAttribute("img5", api2Entity.getAPI2_IMG5());
                    m.addAttribute("img6", api2Entity.getAPI2_IMG6());
                }else if(lang.equals("eng")){
                    Af_project_info_2_eEntity api2eEntity = api2eRepository.getAPI2eData(no);

                    m.addAttribute("seq", api2eEntity.getAPI2E_SEQ());
                    m.addAttribute("no", api2eEntity.getAPI1_SEQ());
                    m.addAttribute("contents", api2eEntity.getAPI2E_CONTENTS());
                    m.addAttribute("img1", api2eEntity.getAPI2E_IMG1());
                    m.addAttribute("img2", api2eEntity.getAPI2E_IMG2());
                    m.addAttribute("img3", api2eEntity.getAPI2E_IMG3());
                    m.addAttribute("img4", api2eEntity.getAPI2E_IMG4());
                    m.addAttribute("img5", api2eEntity.getAPI2E_IMG5());
                    m.addAttribute("img6", api2eEntity.getAPI2E_IMG6());
                }
            }else if(details.equals("detail")){
                if(lang.equals("kor")){
                    Af_project_info_3Entity api3Entity = api3Repository.getAPI3Data(no);

                    m.addAttribute("seq", api3Entity.getAPI3_SEQ());
                    m.addAttribute("no", api3Entity.getAPI1_SEQ());
                    m.addAttribute("d1", api3Entity.getAPI3_CONTENT1());
                    m.addAttribute("d2", api3Entity.getAPI3_CONTENT2());
                }else if(lang.equals("eng")){
                    Af_project_info_3_eEntity api3eEntity = api3eRepository.getAPI3eData(no);

                    m.addAttribute("seq", api3eEntity.getAPI3E_SEQ());
                    m.addAttribute("no", api3eEntity.getAPI1_SEQ());
                    m.addAttribute("d1", api3eEntity.getAPI3E_CONTENT1());
                    m.addAttribute("d2", api3eEntity.getAPI3E_CONTENT2());
                }
            }else if(details.equals("case")){
                if(lang.equals("kor")){
                    Af_project_info_4Entity api4Entity = api4Repository.getAPI4Data(no);

                    m.addAttribute("seq", api4Entity.getAPI4_SEQ());
                    m.addAttribute("no", api4Entity.getAPI1_SEQ());
                    m.addAttribute("c1", api4Entity.getAPI4_CONTENT1());
                    m.addAttribute("c2", api4Entity.getAPI4_CONTENT2());
                    m.addAttribute("c3", api4Entity.getAPI4_CONTENT3());
                    m.addAttribute("c4", api4Entity.getAPI4_CONTENT4());
                }else if(lang.equals("eng")){
                    Af_project_info_4_eEntity api4eEntity = api4eRepository.getAPI4eData(no);

                    m.addAttribute("seq", api4eEntity.getAPI4E_SEQ());
                    m.addAttribute("no", api4eEntity.getAPI1_SEQ());
                    m.addAttribute("c1", api4eEntity.getAPI4E_CONTENT1());
                    m.addAttribute("c2", api4eEntity.getAPI4E_CONTENT2());
                    m.addAttribute("c3", api4eEntity.getAPI4E_CONTENT3());
                    m.addAttribute("c4", api4eEntity.getAPI4E_CONTENT4());
                }
            }else if(details.equals("purchase")){
                if(lang.equals("kor")){
                    Af_project_info_5Entity api5Entity = api5Repository.getAPI5Data(no);

                    m.addAttribute("seq", api5Entity.getAPI5_SEQ());
                    m.addAttribute("no", api5Entity.getAPI1_SEQ());
                    m.addAttribute("p1", api5Entity.getAPI5_CONTENT1());
                    m.addAttribute("p2", api5Entity.getAPI5_CONTENT2());
                    m.addAttribute("p3", api5Entity.getAPI5_CONTENT3());
                }else if(lang.equals("eng")){
                    Af_project_info_5_eEntity api5eEntity = api5eRepository.getAPI5eData(no);

                    m.addAttribute("seq", api5eEntity.getAPI5E_SEQ());
                    m.addAttribute("no", api5eEntity.getAPI1_SEQ());
                    m.addAttribute("p1", api5eEntity.getAPI5E_CONTENT1());
                    m.addAttribute("p2", api5eEntity.getAPI5E_CONTENT2());
                    m.addAttribute("p3", api5eEntity.getAPI5E_CONTENT3());
                }
            }else if(details.equals("option")){
                if(lang.equals("kor")){
                    Af_project_info_6Entity api6Entity = api6Repository.getAPI6Data(no);

                    m.addAttribute("seq", api6Entity.getAPI6_SEQ());
                    m.addAttribute("no", api6Entity.getAPI1_SEQ());
                    m.addAttribute("o1", api6Entity.getAPI6_OPT1());
                    m.addAttribute("o2", api6Entity.getAPI6_OPT2());
                    m.addAttribute("o3", api6Entity.getAPI6_OPT3());
                    m.addAttribute("o4", api6Entity.getAPI6_OPT4());
                    m.addAttribute("o5", api6Entity.getAPI6_OPT5());
                    m.addAttribute("o6", api6Entity.getAPI6_OPT6());
                    m.addAttribute("o7", api6Entity.getAPI6_OPT7());
                }else if(lang.equals("eng")){
                    Af_project_info_6_eEntity api6eEntity = api6eRepository.getAPI6eData(no);

                    m.addAttribute("seq", api6eEntity.getAPI6E_SEQ());
                    m.addAttribute("no", api6eEntity.getAPI1_SEQ());
                    m.addAttribute("o1", api6eEntity.getAPI6E_OPT1());
                    m.addAttribute("o2", api6eEntity.getAPI6E_OPT2());
                    m.addAttribute("o3", api6eEntity.getAPI6E_OPT3());
                    m.addAttribute("o4", api6eEntity.getAPI6E_OPT4());
                    m.addAttribute("o5", api6eEntity.getAPI6E_OPT5());
                    m.addAttribute("o6", api6eEntity.getAPI6E_OPT6());
                    m.addAttribute("o7", api6eEntity.getAPI6E_OPT7());
                }
            }
            m.addAttribute("Lang", lang);

            returnValue = "/admin/detail/"+details+"/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }











    // 콘텐츠 등록 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/contents/add")
    public HashMap<String, String> ContentsAddData(Model m, HttpServletRequest request,
                                                 @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                 @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                                                 @RequestParam(required = false, defaultValue = "", value = "text") String text,
                                                 @RequestParam(required = false, defaultValue = "", value = "img1") String img1,
                                                 @RequestParam(required = false, defaultValue = "", value = "img2") String img2,
                                                 @RequestParam(required = false, defaultValue = "", value = "img3") String img3,
                                                 @RequestParam(required = false, defaultValue = "", value = "img4") String img4,
                                                 @RequestParam(required = false, defaultValue = "", value = "img5") String img5,
                                                 @RequestParam(required = false, defaultValue = "", value = "img6") String img6) {
        LocalDateTime sdf = LocalDateTime.now();
        HashMap<String, String> msg = new HashMap<String, String>();

        if(lang.equals("kor")){
            Af_project_info_2Dto api2Dto = new Af_project_info_2Dto(null, no, text, img1, img2, img3, img4, img5, img6, sdf, sdf);
            afDetailService.api2Save(api2Dto);

            if(api2Repository.checkAPI2Data(no)==1){
                msg.put("save", "1");
            }else if(api2Repository.checkAPI2Data(no)==0){
                msg.put("save", "0");
            }
        }else if(lang.equals("eng")){
            Af_project_info_2_eDto api2eDto = new Af_project_info_2_eDto(null, no, text, img1, img2, img3, img4, img5, img6, sdf, sdf);
            afDetailService.api2eSave(api2eDto);

            if(api2eRepository.checkAPI2eData(no)==1){
                msg.put("save", "1");
            }else if(api2eRepository.checkAPI2eData(no)==0){
                msg.put("save", "0");
            }
        }
        return msg;
    }
    // 상세정보 등록 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/detail/add")
    public HashMap<String, String> DetailAddData(Model m, HttpServletRequest request,
                                                 @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                 @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                                                 @RequestParam(required = false, defaultValue = "", value = "d1") String d1,
                                                 @RequestParam(required = false, defaultValue = "", value = "d2") String d2) {
        LocalDateTime sdf = LocalDateTime.now();
        HashMap<String, String> msg = new HashMap<String, String>();

        if(lang.equals("kor")){
            Af_project_info_3Dto api3Dto = new Af_project_info_3Dto(null, no, d1, d2, sdf, sdf);
            afDetailService.api3Save(api3Dto);

            if(api3Repository.checkAPI3Data(no)==1){
                msg.put("save", "1");
            }else if(api3Repository.checkAPI3Data(no)==0){
                msg.put("save", "0");
            }
        }else if(lang.equals("eng")){
            Af_project_info_3_eDto api3eDto = new Af_project_info_3_eDto(null, no, d1, d2, sdf, sdf);
            afDetailService.api3eSave(api3eDto);

            if(api3eRepository.checkAPI3eData(no)==1){
                msg.put("save", "1");
            }else if(api3eRepository.checkAPI3eData(no)==0){
                msg.put("save", "0");
            }
        }
        return msg;
    }
    // 활용사례 등록 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/case/add")
    public HashMap<String, String> CaseAddData(Model m, HttpServletRequest request,
                                                 @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                 @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                                                 @RequestParam(required = false, defaultValue = "", value = "c1") String c1,
                                                 @RequestParam(required = false, defaultValue = "", value = "c2") String c2,
                                                 @RequestParam(required = false, defaultValue = "", value = "c3") String c3,
                                                 @RequestParam(required = false, defaultValue = "", value = "c4") String c4) {
        LocalDateTime sdf = LocalDateTime.now();
        HashMap<String, String> msg = new HashMap<String, String>();

        if(lang.equals("kor")){
            log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+no+"/"+c1+"/"+c2+"/"+c3+"/"+c4);

            Af_project_info_4Dto api4Dto = new Af_project_info_4Dto(null, no, c1, c2, c3, c4, sdf, sdf);
            afDetailService.api4Save(api4Dto);

            if(api4Repository.checkAPI4Data(no)==1){
                msg.put("save", "1");
            }else if(api4Repository.checkAPI4Data(no)==0){
                msg.put("save", "0");
            }
        }else if(lang.equals("eng")){
            Af_project_info_4_eDto api4eDto = new Af_project_info_4_eDto(null, no, c1, c2, c3, c4, sdf, sdf);
            afDetailService.api4eSave(api4eDto);

            if(api4eRepository.checkAPI4eData(no)==1){
                msg.put("save", "1");
            }else if(api4eRepository.checkAPI4eData(no)==0){
                msg.put("save", "0");
            }
        }
        return msg;
    }
    // 구입방식 등록 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/purchase/add")
    public HashMap<String, String> PurchaseAddData(Model m, HttpServletRequest request,
                                                 @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                 @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                                                 @RequestParam(required = false, defaultValue = "", value = "p1") String p1,
                                                 @RequestParam(required = false, defaultValue = "", value = "p2") String p2,
                                                 @RequestParam(required = false, defaultValue = "", value = "p3") String p3) {
        LocalDateTime sdf = LocalDateTime.now();
        HashMap<String, String> msg = new HashMap<String, String>();

        if(lang.equals("kor")){
            Af_project_info_5Dto api5Dto = new Af_project_info_5Dto(null, no, p1, p2, p3, sdf, sdf);
            afDetailService.api5Save(api5Dto);

            if(api5Repository.checkAPI5Data(no)==1){
                msg.put("save", "1");
            }else if(api5Repository.checkAPI5Data(no)==0){
                msg.put("save", "0");
            }
        }else if(lang.equals("eng")){
            Af_project_info_5_eDto api5eDto = new Af_project_info_5_eDto(null, no, p1, p2, p3, sdf, sdf);
            afDetailService.api5eSave(api5eDto);

            if(api5eRepository.checkAPI5eData(no)==1){
                msg.put("save", "1");
            }else if(api5eRepository.checkAPI5eData(no)==0){
                msg.put("save", "0");
            }
        }
        return msg;
    }
    // 옵션 등록 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/option/add")
    public HashMap<String, String> OptionAddData(Model m, HttpServletRequest request,
                                                 @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                 @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                                                 @RequestParam(required = false, defaultValue = "", value = "o1") String o1,
                                                 @RequestParam(required = false, defaultValue = "", value = "o2") String o2,
                                                 @RequestParam(required = false, defaultValue = "", value = "o3") String o3,
                                                 @RequestParam(required = false, defaultValue = "", value = "o4") String o4,
                                                 @RequestParam(required = false, defaultValue = "", value = "o5") String o5,
                                                 @RequestParam(required = false, defaultValue = "", value = "o6") String o6,
                                                 @RequestParam(required = false, defaultValue = "", value = "o7") String o7) {
        LocalDateTime sdf = LocalDateTime.now();
        HashMap<String, String> msg = new HashMap<String, String>();

        if(lang.equals("kor")){
            Af_project_info_6Dto api6Dto = new Af_project_info_6Dto(null, no, o1, o2, o3, o4, o5, o6, o7, sdf, sdf);
            afDetailService.api6Save(api6Dto);

            if(api6Repository.checkAPI6Data(no)==1){
                msg.put("save", "1");
            }else if(api6Repository.checkAPI6Data(no)==0){
                msg.put("save", "0");
            }
        }else if(lang.equals("eng")){
            Af_project_info_6_eDto api6eDto = new Af_project_info_6_eDto(null, no, o1, o2, o3, o4, o5, o6, o7, sdf, sdf);
            afDetailService.api6eSave(api6eDto);

            if(api6eRepository.checkAPI6eData(no)==1){
                msg.put("save", "1");
            }else if(api6eRepository.checkAPI6eData(no)==0){
                msg.put("save", "0");
            }
        }
        return msg;
    }




    // 콘텐츠 수정 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/contents/edit")
    public HashMap<String, String> ContentseditData(Model m, HttpServletRequest request,
                @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                @RequestParam(required = false, defaultValue = "", value = "seq") Long seq,
                @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                @RequestParam(required = false, defaultValue = "", value = "text") String text,
                @RequestParam(required = false, defaultValue = "", value = "img1") String img1,
                @RequestParam(required = false, defaultValue = "", value = "img2") String img2,
                @RequestParam(required = false, defaultValue = "", value = "img3") String img3,
                @RequestParam(required = false, defaultValue = "", value = "img4") String img4,
                @RequestParam(required = false, defaultValue = "", value = "img5") String img5,
                @RequestParam(required = false, defaultValue = "", value = "img6") String img6) {
        HashMap<String, String> msg = new HashMap<String, String>();
        if(lang.equals("kor")){
            Af_project_info_2Entity api2Ett1 = api2Repository.getAPI2Data(seq);
            String timecheck = String.valueOf(api2Ett1.getAPI2_UDATETIME());

            LocalDateTime sdf = LocalDateTime.now();
            api2Repository.updateAPI2Data(seq, text, img1, img2, img3, img4, img5, img6, sdf);

            Af_project_info_2Entity api2Ett2 = api2Repository.getAPI2Data(seq);

            if(String.valueOf(api2Ett2.getAPI2_UDATETIME()).equals(timecheck)){
                msg.put("save", "0");
            }else {
                msg.put("save", "1");
            }
        }else if(lang.equals("eng")){
            Af_project_info_2_eEntity api2eEtt1 = api2eRepository.getAPI2eData(seq);
            String timecheck = String.valueOf(api2eEtt1.getAPI2E_UDATETIME());
            log.info(timecheck);

            LocalDateTime sdf = LocalDateTime.now();
            api2eRepository.updateAPI2eData(seq, text, img1, img2, img3, img4, img5, img6, sdf);
            Af_project_info_2_eEntity api2eEtt2 = api2eRepository.getAPI2eData(seq);

            if(String.valueOf(api2eEtt2.getAPI2E_UDATETIME()).equals(timecheck)){
                msg.put("save", "0");
            }else {
                msg.put("save", "1");
            }
        }
        return msg;
    }
    // 상세정보 수정 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/detail/edit")
    public HashMap<String, String> DetaileditData(Model m, HttpServletRequest request,
                                                  @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                  @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                                                  @RequestParam(required = false, defaultValue = "", value = "d1") String d1,
                                                  @RequestParam(required = false, defaultValue = "", value = "d2") String d2) {
        HashMap<String, String> msg = new HashMap<String, String>();

        if(lang.equals("kor")){
            Af_project_info_3Entity api3Ett1 = api3Repository.getAPI3Data(no);
            String timecheck = String.valueOf(api3Ett1.getAPI3_UDATETIME());

            LocalDateTime sdf = LocalDateTime.now();
            api3Repository.updateAPI3Data(no, d1, d2, sdf);
            Af_project_info_3Entity api3Ett2 = api3Repository.getAPI3Data(no);

            if(String.valueOf(api3Ett2.getAPI3_UDATETIME()).equals(timecheck)){
                msg.put("save", "0");
            }else {
                msg.put("save", "1");
            }
        }else if(lang.equals("eng")){
            Af_project_info_3_eEntity api3eEtt1 = api3eRepository.getAPI3eData(no);
            String timecheck = String.valueOf(api3eEtt1.getAPI3E_UDATETIME());
            log.info(timecheck);

            LocalDateTime sdf = LocalDateTime.now();
            api3eRepository.updateAPI3eData(no, d1, d2, sdf);
            Af_project_info_3_eEntity api3eEtt2 = api3eRepository.getAPI3eData(no);

            if(String.valueOf(api3eEtt2.getAPI3E_UDATETIME()).equals(timecheck)){
                msg.put("save", "0");
            }else {
                msg.put("save", "1");
            }
        }
        return msg;
    }
    // 활용사례 수정 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/case/edit")
    public HashMap<String, String> CaseeditData(Model m, HttpServletRequest request,
                                                @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                                                @RequestParam(required = false, defaultValue = "", value = "c1") String c1,
                                                @RequestParam(required = false, defaultValue = "", value = "c2") String c2,
                                                @RequestParam(required = false, defaultValue = "", value = "c3") String c3,
                                                @RequestParam(required = false, defaultValue = "", value = "c4") String c4) {
        HashMap<String, String> msg = new HashMap<String, String>();

        if(lang.equals("kor")){
            Af_project_info_4Entity api4Ett1 = api4Repository.getAPI4Data(no);
            String timecheck = String.valueOf(api4Ett1.getAPI4_UDATETIME());

            LocalDateTime sdf = LocalDateTime.now();
            api4Repository.updateAPI4Data(no, c1, c2, c3, c4, sdf);
            Af_project_info_4Entity api4Ett2 = api4Repository.getAPI4Data(no);

            if(String.valueOf(api4Ett2.getAPI4_UDATETIME()).equals(timecheck)){
                msg.put("save", "0");
            }else {
                msg.put("save", "1");
            }
        }else if(lang.equals("eng")){
            Af_project_info_4_eEntity api4eEtt1 = api4eRepository.getAPI4eData(no);
            String timecheck = String.valueOf(api4eEtt1.getAPI4E_UDATETIME());
            log.info(timecheck);

            LocalDateTime sdf = LocalDateTime.now();
            api4eRepository.updateAPI4eData(no, c1, c2, c3, c4, sdf);
            Af_project_info_4_eEntity api4eEtt2 = api4eRepository.getAPI4eData(no);

            if(String.valueOf(api4eEtt2.getAPI4E_UDATETIME()).equals(timecheck)){
                msg.put("save", "0");
            }else {
                msg.put("save", "1");
            }
        }
        return msg;
    }
    // 구입방식 수정 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/purchase/edit")
    public HashMap<String, String> PurchaseeditData(Model m, HttpServletRequest request,
                                                    @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                    @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                                                    @RequestParam(required = false, defaultValue = "", value = "p1") String p1,
                                                    @RequestParam(required = false, defaultValue = "", value = "p2") String p2,
                                                    @RequestParam(required = false, defaultValue = "", value = "p3") String p3) {
        HashMap<String, String> msg = new HashMap<String, String>();
        log.info("!!!!!!!!!!!!!!!!"+no);

        if(lang.equals("kor")){
            Af_project_info_5Entity api5Ett1 = api5Repository.getAPI5Data(no);
            String timecheck = String.valueOf(api5Ett1.getAPI5_UDATETIME());

            LocalDateTime sdf = LocalDateTime.now();
            api5Repository.updateAPI5Data(no, p1, p2, p3, sdf);
            Af_project_info_5Entity api5Ett2 = api5Repository.getAPI5Data(no);

            if(String.valueOf(api5Ett2.getAPI5_UDATETIME()).equals(timecheck)){
                msg.put("save", "0");
            }else {
                msg.put("save", "1");
            }
        }else if(lang.equals("eng")){
            Af_project_info_5_eEntity api5eEtt1 = api5eRepository.getAPI5eData(no);
            String timecheck = String.valueOf(api5eEtt1.getAPI5E_UDATETIME());
            log.info(timecheck);

            LocalDateTime sdf = LocalDateTime.now();
            api5eRepository.updateAPI5eData(no, p1, p2, p3, sdf);
            Af_project_info_5_eEntity api5eEtt2 = api5eRepository.getAPI5eData(no);

            if(String.valueOf(api5eEtt2.getAPI5E_UDATETIME()).equals(timecheck)){
                msg.put("save", "0");
            }else {
                msg.put("save", "1");
            }
        }
        return msg;
    }
    // 옵션 수정 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/option/edit")
    public HashMap<String, String> OptioneditData(Model m, HttpServletRequest request,
                                                  @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                  @RequestParam(required = false, defaultValue = "", value = "lang") String lang,
                                                  @RequestParam(required = false, defaultValue = "", value = "o1") String o1,
                                                  @RequestParam(required = false, defaultValue = "", value = "o2") String o2,
                                                  @RequestParam(required = false, defaultValue = "", value = "o3") String o3,
                                                  @RequestParam(required = false, defaultValue = "", value = "o4") String o4,
                                                  @RequestParam(required = false, defaultValue = "", value = "o5") String o5,
                                                  @RequestParam(required = false, defaultValue = "", value = "o6") String o6,
                                                  @RequestParam(required = false, defaultValue = "", value = "o7") String o7) {
        HashMap<String, String> msg = new HashMap<String, String>();

        if(lang.equals("kor")){
            Af_project_info_6Entity api6Ett1 = api6Repository.getAPI6Data(no);
            String timecheck = String.valueOf(api6Ett1.getAPI6_UDATETIME());

            LocalDateTime sdf = LocalDateTime.now();
            api6Repository.updateAPI6Data(no, o1, o2, o3, o4, o5, o6, o7, sdf);
            Af_project_info_6Entity api6Ett2 = api6Repository.getAPI6Data(no);

            if(String.valueOf(api6Ett2.getAPI6_UDATETIME()).equals(timecheck)){
                msg.put("save", "0");
            }else {
                msg.put("save", "1");
            }
        }else if(lang.equals("eng")){
            Af_project_info_6_eEntity api6eEtt1 = api6eRepository.getAPI6eData(no);
            String timecheck = String.valueOf(api6eEtt1.getAPI6E_UDATETIME());
            log.info(timecheck);

            LocalDateTime sdf = LocalDateTime.now();
            api6eRepository.updateAPI6eData(no, o1, o2, o3, o4, o5, o6, o7, sdf);
            Af_project_info_6_eEntity api6eEtt2 = api6eRepository.getAPI6eData(no);

            if(String.valueOf(api6eEtt2.getAPI6E_UDATETIME()).equals(timecheck)){
                msg.put("save", "0");
            }else {
                msg.put("save", "1");
            }
        }
        return msg;
    }




    // 파일 다운로드
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/cttUpload")
    public String ContentsUpload(MultipartHttpServletRequest request) {
        MultipartFile file1 = request.getFile("file1");
        MultipartFile file2 = request.getFile("file2");
        MultipartFile file3 = request.getFile("file3");
        MultipartFile file4 = request.getFile("file4");
        MultipartFile file5 = request.getFile("file5");
        MultipartFile file6 = request.getFile("file6");
        String filename = "";
        String path = "C:/Users/sec/Desktop/temp/"; // 저장경로 ********************
        try {
            if(file1!=null){
                filename = file1.getOriginalFilename();
                log.info("1!!!!!"+filename);
                if(filename.split(",")[0].equals("check")){
                    File D_file = new File(path + filename.split(",")[1]);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                }else {
                    File D_file = new File(path + filename);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                    file1.transferTo(new File(path + filename));
                }
            }
            if(file2!=null){
                filename = file2.getOriginalFilename();
                log.info("2!!!!!"+filename);
                if(filename.split(",")[0].equals("check")){
                    File D_file = new File(path + filename.split(",")[1]);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                }else {
                    File D_file = new File(path + filename);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                    file2.transferTo(new File(path + filename));
                }
            }
            if(file3!=null){
                filename = file3.getOriginalFilename();
                log.info("3!!!!!"+filename);
                if(filename.split(",")[0].equals("check")){
                    File D_file = new File(path + filename.split(",")[1]);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                }else {
                    File D_file = new File(path + filename);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                    file3.transferTo(new File(path + filename));
                }
            }
            if(file4!=null){
                filename = file4.getOriginalFilename();
                log.info("4!!!!!"+filename);
                if(filename.split(",")[0].equals("check")){
                    File D_file = new File(path + filename.split(",")[1]);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                }else {
                    File D_file = new File(path + filename);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                    file4.transferTo(new File(path + filename));
                }
            }
            if(file5!=null){
                filename = file5.getOriginalFilename();
                log.info("5!!!!!"+filename);
                if(filename.split(",")[0].equals("check")){
                    File D_file = new File(path + filename.split(",")[1]);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                }else {
                    File D_file = new File(path + filename);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                    file5.transferTo(new File(path + filename));
                }
            }
            if(file6!=null){
                filename = file6.getOriginalFilename();
                log.info("6!!!!!"+filename);
                if(filename.split(",")[0].equals("check")){
                    File D_file = new File(path + filename.split(",")[1]);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                }else {
                    File D_file = new File(path + filename);
                    if(D_file.exists()){
                        D_file.delete();
                    }
                    file6.transferTo(new File(path + filename));
                }
            }
            return "1"; // 저장명 반환
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }
    }
}
