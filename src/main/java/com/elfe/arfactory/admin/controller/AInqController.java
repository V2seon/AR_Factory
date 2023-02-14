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
@RequestMapping("/admin/inq")
public class AInqController {

    // 문의 정보 목록
    @GetMapping("/list")
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
    @GetMapping("/edit")
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
}
