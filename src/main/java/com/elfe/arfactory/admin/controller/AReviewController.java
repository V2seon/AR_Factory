package com.elfe.arfactory.admin.controller;

import com.elfe.arfactory.admin.common.SessionCheck;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/review")
public class AReviewController {

    // 후기 정보 목록
    @GetMapping("/list")
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
    @GetMapping("/add")
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
    @GetMapping("/edit")
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
}
