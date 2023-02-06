package com.elfe.arfactory.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping
public class ConviewController {

    @GetMapping("/Con_view")
    public String Con_view(Model m, HttpServletRequest request){
        return "/promotion/Con_view";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/InCon")
    public String InCon_view(Model m, HttpServletRequest request,
                             @RequestParam(required = false, defaultValue = "", value = "conchoice")String Conchoice,
                             @RequestParam(required = false, defaultValue = "", value = "userchice")String Userchoice,
                             @RequestParam(required = false, defaultValue = "", value = "username")String Username,
                             @RequestParam(required = false, defaultValue = "", value = "userphone")String Userphone,
                             @RequestParam(required = false, defaultValue = "", value = "useremail")String Useremail,
                             @RequestParam(required = false, defaultValue = "", value = "company")String Company,
                             @RequestParam(required = false, defaultValue = "", value = "conname")String Conname,
                             @RequestParam(required = false, defaultValue = "", value = "context")String Context){
        System.out.println(Conchoice);
        System.out.println(Userchoice);
        System.out.println(Username);
        System.out.println(Userphone);
        System.out.println(Useremail);
        System.out.println(Company);
        System.out.println(Conname);
        System.out.println(Context);
        return "/promotion/Con_view";
    }
}
