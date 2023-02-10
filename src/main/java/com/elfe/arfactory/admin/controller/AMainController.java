package com.elfe.arfactory.admin.controller;

import com.elfe.arfactory.admin.common.SessionCheck;
import com.elfe.arfactory.admin.repository.UserRepository;
import com.elfe.arfactory.admin.service.LoginService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AMainController {

    private LoginService loginService;
    private UserRepository userRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName()); // log찍기용

    @GetMapping("")
    public String adminPage(Model m, HttpServletRequest request) {
        return "/admin/login.html";
    }

    @GetMapping("/main")
    public String adminMain(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/main.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 로그인
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/userlogin")
    public HashMap<String, String> userlogin(@RequestParam(required = false, defaultValue = "", value = "id") String userid,
                                             @RequestParam(required = false, defaultValue = "", value = "pw") String userpw,
                                             HttpServletRequest request){
        HttpSession session = request.getSession();
        HashMap<String, String> msg = new HashMap<String, String>();
        int loginResult = loginService.loginAdmin(userid, userpw);
        if(loginResult == 1){
            //로그인성공
            session.setAttribute("userid", userid);
            msg.put("loginResult", "1");
        }else{
            //로그인실패
            msg.put("loginResult", "0");
        }
        log.info(msg.get("loginResult"));
        return msg;
    }

    // 로그아웃
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public HashMap<String, String> Logout(Model m, HttpServletRequest request){
        HttpSession session = request.getSession();
        HashMap<String, String> msg = new HashMap<String, String>();
        session.setAttribute("userid", null);
        if(new SessionCheck().loginSessionCheck(request)){
            //로그아웃 실패
            msg.put("logoutResult", "0");
        }else{
            //로그아웃 성공
            msg.put("logoutResult", "1");
        }
        return msg;
    }


    // 페이지 이동
    // 솔루션 목록
    @GetMapping("/solution/list")
    public String solutionList(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/solution/list.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 솔루션 등록
    @GetMapping("/solution/add")
    public String solutionAdd(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/solution/add.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 솔루션 수정
    @GetMapping("/solution/edit")
    public String solutionEdit(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/solution/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 상세정보
    @GetMapping("/detail/list")
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
    @GetMapping("/detail/contents/kor/add")
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
    @GetMapping("/detail/contents/kor/edit")
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
    @GetMapping("/detail/detail/kor/add")
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
    @GetMapping("/detail/detail/kor/edit")
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
    @GetMapping("/detail/case/kor/add")
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
    @GetMapping("/detail/case/kor/edit")
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
    @GetMapping("/detail/purchase/kor/add")
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
    @GetMapping("/detail/purchase/kor/edit")
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
    @GetMapping("/detail/option/kor/add")
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
    @GetMapping("/detail/option/kor/edit")
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

    // 문의 정보 목록
    @GetMapping("/inq/list")
    public String InquiryList(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/inq/list.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 문의 정보 수정
    @GetMapping("/inq/edit")
    public String InquiryEdit(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/inq/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 후기 정보 목록
    @GetMapping("/review/list")
    public String ReviewList(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/review/list.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 후기 등록
    @GetMapping("/review/add")
    public String ReviewAdd(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/review/add.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }

    // 후기 수정
    @GetMapping("/review/edit")
    public String ReviewEdit(Model m, HttpServletRequest request) {
        String returnValue = "";
        HttpSession session = request.getSession();
        if(new SessionCheck().loginSessionCheck(request)){
            m.addAttribute("Lang", "kor");
//            m.addAttribute("Lang", "eng");
            returnValue = "/admin/review/edit.html";
        }else {
            returnValue = "redirect:/admin";
        }
        return returnValue;
    }




















    @GetMapping("/test")
    public String aTest(Model m, HttpServletRequest request) {
        m.addAttribute("pageName", "Test Page");
        return "/admin/temp.html";
    }
}
