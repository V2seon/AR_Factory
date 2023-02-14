package com.elfe.arfactory.admin.controller;

import com.elfe.arfactory.admin.common.SessionCheck;
import com.elfe.arfactory.admin.entity.UserEntity;
import com.elfe.arfactory.admin.repository.UserRepository;
import com.elfe.arfactory.admin.service.API1Service;
import com.elfe.arfactory.promotion.entity.Af_project_info_1Entity;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/detail")
public class ADetailController {

    private API1Service api1Service;
    private UserRepository userRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName()); // log찍기용

//    // 솔루션 목록
//    @GetMapping("/list")
//    public String solutionList(Model m, HttpServletRequest request, Pageable pageable,
//                               @RequestParam(required = false, defaultValue = "0", value = "page") int page) {
//        String returnValue = "";
//        if(new SessionCheck().loginSessionCheck(request)){
//            HttpSession session = request.getSession();
//            Optional<UserEntity> s1 = userRepository.findByAaid((String) session.getAttribute("userid"));
//            pageable = PageRequest.of(page, 10, Sort.by("API1_SEQ").descending());
//            Page<Af_project_info_1Entity> api1Entities = api1Service.getAPI1List(pageable);
//            com.elfe.arfactory.common.Pagination pagination = new com.elfe.arfactory.common.Pagination(api1Entities.getTotalPages(), page);
//
//            m.addAttribute("thisPage", pagination.getPage()); //현재 몇 페이지에 있는지 확인하기 위함
//            m.addAttribute("isNextSection", pagination.isNextSection()); //다음버튼 유무 확인하기 위함
//            m.addAttribute("isPrevSection", pagination.isPrevSection()); //이전버튼 유무 확인하기 위함
//            m.addAttribute("firstBtnIndex", pagination.getFirstBtnIndex()); //버튼 페이징 - 첫시작 인덱스
//            m.addAttribute("lastBtnIndex", pagination.getLastBtnIndex()); //섹션 변경 위함
//            m.addAttribute("totalPage", pagination.getTotalPages()); //끝 버튼 위함
//            m.addAttribute("s1", s1);
//            m.addAttribute("solutionlist", api1Entities); //페이지 객체 리스트
//
//            m.addAttribute("Lang", "kor");
////            m.addAttribute("Lang", "eng");
//            returnValue = "/admin/solution/list.html";
//        }else {
//            returnValue = "redirect:/admin";
//        }
//        return returnValue;
//    }

    @GetMapping("/list")
    public String DetailList(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/list.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 콘텐츠 등록-한글/영어
    @GetMapping("/contents/kor/add")
//    @GetMapping("/detail/contents/eng/add")
    public String ContentsKorAdd(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/conttents/add.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 콘텐츠 수정-한글/영어
    @GetMapping("/contents/kor/edit")
//    @GetMapping("/detail/contents/eng/edit")
    public String ContentsKorEdit(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/conttents/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 상세정보 등록-한글/영어
    @GetMapping("/detail/kor/add")
//    @GetMapping("/detail/detail/eng/add")
    public String DetailKoradd(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/detail/add.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 상세정보 수정-한글/영어
    @GetMapping("/detail/kor/edit")
//    @GetMapping("/detail/detail/eng/edit")
    public String DetailKorEdit(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/detail/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 활용사례 등록-한글/영어
    @GetMapping("/case/kor/add")
//    @GetMapping("/detail/case/eng/add")
    public String CaseAdd(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/case/add.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 활용사례 수정-한글/영어
    @GetMapping("/case/kor/edit")
//    @GetMapping("/detail/case/eng/edit")
    public String CaseEdit(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/case/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 구입방식 등록-한글/영어
    @GetMapping("/purchase/kor/add")
//    @GetMapping("/detail/purchase/eng/add")
    public String PurchaseAdd(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/purchase/add.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 구입방식 수정-한글/영어
    @GetMapping("/purchase/kor/edit")
//    @GetMapping("/detail/purchase/eng/edit")
    public String PurchaseEdit(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/purchase/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 옵션 등록-한글/영어
    @GetMapping("/option/kor/add")
//    @GetMapping("/detail/option/eng/add")
    public String OptionAdd(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/option/add.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 옵션 수정-한글/영어
    @GetMapping("/option/kor/edit")
//    @GetMapping("/detail/option/eng/edit")
    public String OptionEdit(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/detail/option/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }
}
