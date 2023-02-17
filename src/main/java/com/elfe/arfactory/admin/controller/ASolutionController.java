package com.elfe.arfactory.admin.controller;

import com.elfe.arfactory.admin.common.SessionCheck;
import com.elfe.arfactory.admin.entity.UserEntity;
import com.elfe.arfactory.admin.repository.UserRepository;
import com.elfe.arfactory.admin.service.API1Service;
import com.elfe.arfactory.common.Pagination;
import com.elfe.arfactory.promotion.dto.Af_project_info_1Dto;
import com.elfe.arfactory.promotion.entity.Af_project_info_1Entity;
import com.elfe.arfactory.promotion.repository.Af_project_info_1Repository;
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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/solution")
public class ASolutionController {

    private UserRepository userRepository;
    private Af_project_info_1Repository api1Repository;
    private API1Service api1Service;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName()); // log찍기용

    @GetMapping("/list")
    public String solutionList(Model m, HttpServletRequest request, Pageable pageable,
                               @RequestParam(required = false, defaultValue = "0", value = "page") int page) {
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            HttpSession session = request.getSession();
            Optional<UserEntity> s1 = userRepository.findByAaid((String) session.getAttribute("userid"));
            pageable = PageRequest.of(page, 10, Sort.by("API1_SEQ").descending());
            Page<Af_project_info_1Entity> api1Entities = api1Service.getAPI1List(pageable);
            Pagination pagination = new Pagination(api1Entities.getTotalPages(), page);

            m.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
            m.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
            m.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
            m.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
            m.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
            m.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
            m.addAttribute("s1", s1);
            m.addAttribute("solutionlist", api1Entities); //페이지 객체 리스트

            returnValue = "/admin/solution/list.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 솔루션 등록페이지 이동
    @GetMapping("/add")
    public String solutionAdd(Model m, HttpServletRequest request) {
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/solution/add.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 솔루션 등록 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public HashMap<String, String> solutionAddData(Model m, HttpServletRequest request,
                                                   @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                   @RequestParam(required = false, defaultValue = "", value = "type") String type,
                                                   @RequestParam(required = false, defaultValue = "", value = "name_e") String name_e,
                                                   @RequestParam(required = false, defaultValue = "", value = "type_e") String type_e,
                                                   @RequestParam(required = false, defaultValue = "", value = "googleLink") String googleLink,
                                                   @RequestParam(required = false, defaultValue = "", value = "appleLink") String appleLink,
                                                   @RequestParam(required = false, defaultValue = "", value = "mainNum") int mainNum,
                                                   @RequestParam(required = false, defaultValue = "", value = "show") int show) {
        LocalDateTime sdf = LocalDateTime.now();
        Af_project_info_1Dto api1Dto = new Af_project_info_1Dto(null, name, type, name_e, type_e, googleLink, appleLink, mainNum, show, sdf, sdf);
        api1Service.api1Save(api1Dto);
        log.info(String.valueOf(api1Repository.checkAPI1Data(name)));

        HashMap<String, String> msg = new HashMap<String, String>();
        if(api1Repository.checkAPI1Data(name)==1){
            msg.put("save", "1");
        }else {
            msg.put("save", "0");
        }
        return msg;
    }

    // 솔루션 수정
    @GetMapping("/edit")
    public String solutionEdit(Model m, HttpServletRequest request, @RequestParam(required = false, defaultValue = "", value = "no") Long no) {
        String returnValue = "";
        if(new SessionCheck().loginSessionCheck(request)){
            Af_project_info_1Entity api1Entity = api1Repository.getAPI1Data(no);

            m.addAttribute("seq", api1Entity.getAPI1_SEQ());
            m.addAttribute("name", api1Entity.getAPI1_NAME());
            m.addAttribute("type", api1Entity.getAPI1_TYPE());
            m.addAttribute("name_e", api1Entity.getAPI1_NAME_E());
            m.addAttribute("type_e", api1Entity.getAPI1_TYPE_R());
            m.addAttribute("google", api1Entity.getAPI1_PLAYSTORE());
            m.addAttribute("apple", api1Entity.getAPI1_APPSTORE());
            m.addAttribute("viewSeq", api1Entity.getAPI1_VIEW_SEQ());
            m.addAttribute("state", api1Entity.getAPI1_STATE());

            return "/admin/solution/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 솔루션 수정 저장
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public HashMap<String, String> solutionEditData(Model m, HttpServletRequest request,
                                                    @RequestParam(required = false, defaultValue = "", value = "no") Long no,
                                                    @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                   @RequestParam(required = false, defaultValue = "", value = "type") String type,
                                                   @RequestParam(required = false, defaultValue = "", value = "name_e") String name_e,
                                                   @RequestParam(required = false, defaultValue = "", value = "type_e") String type_e,
                                                   @RequestParam(required = false, defaultValue = "", value = "googleLink") String googleLink,
                                                   @RequestParam(required = false, defaultValue = "", value = "appleLink") String appleLink,
                                                   @RequestParam(required = false, defaultValue = "", value = "mainNum") int mainNum,
                                                   @RequestParam(required = false, defaultValue = "", value = "show") int show) {
        Af_project_info_1Entity api1Ett1 = api1Repository.getAPI1Data(no);
        String timecheck = String.valueOf(api1Ett1.getAPI1_UDATETIME());

        LocalDateTime sdf = LocalDateTime.now();
        api1Repository.updateAPI1Data(no, name, type, name_e, type_e, googleLink, appleLink, mainNum, show, sdf);
        Af_project_info_1Entity api1Ett2 = api1Repository.getAPI1Data(no);

        HashMap<String, String> msg = new HashMap<String, String>();
        log.info(String.valueOf(sdf));

        if(String.valueOf(api1Ett2.getAPI1_UDATETIME()).equals(timecheck)){
            msg.put("save", "0");
        }else {
            msg.put("save", "1");
        }
        return msg;
    }

    // 솔루션 삭제
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public HashMap<String, String> solutionDeleteData(Model m, HttpServletRequest request,
                                                    @RequestParam(required = false, defaultValue = "", value = "no") Long no) {
        api1Repository.deleteAPI1Data(no);

        HashMap<String, String> msg = new HashMap<String, String>();
        if(api1Repository.checkAPI1Seq(no)==0){
            msg.put("save", "1");
        }else {
            msg.put("save", "0");
        }
        return msg;
    }
}
