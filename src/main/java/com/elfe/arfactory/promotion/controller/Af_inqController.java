package com.elfe.arfactory.promotion.controller;

import com.elfe.arfactory.promotion.common.AES_256;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

@Controller
@AllArgsConstructor
@RequestMapping
public class Af_inqController {

    @GetMapping("/Af_inq_go")
    public String Af_inq_go(Model m, HttpServletRequest request,
                           @RequestParam(required = false, defaultValue = "", value = "pjnum")String pjnum,
                            @RequestParam(required = false, defaultValue = "", value = "lagse")String lagse){
        HttpSession session = request.getSession();
        session.setAttribute("pjnum",pjnum);
        session.setAttribute("lagse",lagse);
        return "redirect:";
    }

    @GetMapping("/Af_inq")
    public String Af_inq(Model m, HttpServletRequest request){
        String returnValue = "";
        HttpSession session = request.getSession();
        m.addAttribute("pjnum",session.getAttribute("pjnum"));
        String lagse = (String) session.getAttribute("lagse");
        if(lagse.equals("KOR")){
            returnValue= "/promotion/Af_inq";
            m.addAttribute("lagse","KOR");
        }else if(lagse.equals("ENG")){
            returnValue= "/promotion/eng/Af_inq";
            m.addAttribute("lagse","ENG");
        }
        return returnValue;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/In_Af_inq")
    public String In_Af_inq(Model m, HttpServletRequest request,
                             @RequestParam(required = false, defaultValue = "", value = "conchoice")String Conchoice,
                             @RequestParam(required = false, defaultValue = "", value = "userchice")String Userchoice,
                             @RequestParam(required = false, defaultValue = "", value = "username")String Username,
                             @RequestParam(required = false, defaultValue = "", value = "userphone")String Userphone,
                             @RequestParam(required = false, defaultValue = "", value = "useremail")String Useremail,
                             @RequestParam(required = false, defaultValue = "", value = "company")String Company,
                             @RequestParam(required = false, defaultValue = "", value = "conname")String Conname,
                             @RequestParam(required = false, defaultValue = "", value = "context")String Context,
                             @RequestParam(required = false, defaultValue = "", value = "pjnum")Long pjnum)throws Exception{
        System.out.println(Conchoice);
        System.out.println(Userchoice);
        System.out.println(Username);
        System.out.println(Userphone);
        System.out.println(Useremail);
        System.out.println(Company);
        System.out.println(Conname);
        System.out.println(Context);
        System.out.println(pjnum);

        AES_256 aes256 = new AES_256();
        // 암호화
        String aes256CbcEncode = aes256.AesCBCEncode(Userphone);
        System.out.println(aes256CbcEncode);

        // 복호화
//        String aes256CbcDeocde = aes256.AesCBCDecode(aes256CbcEncode);


//        Af_inqDto af_inqDto = new Af_inqDto(null, null,null,null,null,null,null,null,null);

        return "/promotion/In_Af_inq";
    }

}
