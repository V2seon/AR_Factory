package com.elfe.arfactory.promotion.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping
public class Af_inqController {

    @GetMapping("/Af_inq")
    public String Con_view(Model m, HttpServletRequest request){
        return "/promotion/Af_inq";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/In_Af_inq")
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

//        Af_inqDto af_inqDto = new Af_inqDto(null, null,null,null,null,null,null,null,null);

        return "/promotion/In_Af_inq";
    }
}
