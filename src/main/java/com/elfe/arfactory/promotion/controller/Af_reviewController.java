package com.elfe.arfactory.promotion.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@RequestMapping
public class Af_reviewController {

    @GetMapping("/Af_review_go")
    public String Af_review_go(Model m, HttpServletRequest request,
                            @RequestParam(required = false, defaultValue = "", value = "pjnum")String pjnum){
        HttpSession session = request.getSession();
        session.setAttribute("pjnum",pjnum);
        System.out.println(pjnum);
        return "redirect:";
    }

    @GetMapping("/Af_review")
    public String Af_review(Model m, HttpServletRequest request){
        HttpSession session = request.getSession();
        m.addAttribute("pjnum",session.getAttribute("pjnum"));
        return "/promotion/Af_review";
    }
}
