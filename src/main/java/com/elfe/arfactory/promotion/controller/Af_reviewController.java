package com.elfe.arfactory.promotion.controller;

import com.elfe.arfactory.promotion.dto.Af_reviewDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

import static java.lang.Integer.parseInt;

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

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/In_Af_review")
    public String In_Af_review(Model m, HttpServletRequest request,
                             @RequestParam(required = false, defaultValue = "", value = "pjnum")Long pjnum,
                             @RequestParam(required = false, defaultValue = "", value = "rename")String rename,
                             @RequestParam(required = false, defaultValue = "", value = "repw")String repw,
                             @RequestParam(required = false, defaultValue = "", value = "retext")String retext,
                             @RequestParam(required = false, defaultValue = "", value = "starval")String starval1){
        System.out.println(pjnum);
        System.out.println(rename);
        System.out.println(repw);
        System.out.println(retext);
        System.out.println(starval1);
        Long starval = Long.valueOf(starval1);


//        Af_reviewDto af_reviewDto = new Af_reviewDto(null, pjnum,rename,repw,to,null,0,null,null);


        return "/promotion/In_Af_review";
    }
}
