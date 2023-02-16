package com.elfe.arfactory.promotion.controller;

import com.elfe.arfactory.promotion.common.AES_256;
import com.elfe.arfactory.promotion.dto.Af_reviewDto;
import com.elfe.arfactory.promotion.service.Af_reviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


@Controller
@AllArgsConstructor
@RequestMapping
public class Af_reviewController {

    private Af_reviewService af_reviewService;

//    @GetMapping("/Af_review_go")
//    public String Af_review_go(Model m, HttpServletRequest request,
//                            @RequestParam(required = false, defaultValue = "", value = "pjnum")String pjnum){
//        HttpSession session = request.getSession();
//        session.setAttribute("pjnum",pjnum);
//        System.out.println(pjnum);
//        return "redirect:";
//    }
//
//    @GetMapping("/Af_review")
//    public String Af_review(Model m, HttpServletRequest request){
//        HttpSession session = request.getSession();
//        m.addAttribute("pjnum",session.getAttribute("pjnum"));
//        return "/promotion/Af_review";
//    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/In_Af_review")
    public String In_Af_review(Model m, HttpServletRequest request,
                             @RequestParam(required = false, defaultValue = "", value = "pjnum")Long pjnum,
                             @RequestParam(required = false, defaultValue = "", value = "rename")String rename,
                             @RequestParam(required = false, defaultValue = "", value = "repw")String repw,
                             @RequestParam(required = false, defaultValue = "", value = "retext")String retext,
                             @RequestParam(required = false, defaultValue = "", value = "starval")String starval1)throws Exception {
        System.out.println(pjnum);
        System.out.println(rename);
        System.out.println(repw);
        System.out.println(retext);
        System.out.println(Double.parseDouble(starval1));

        AES_256 aes256 = new AES_256();

        // 암호화
        String aes256CbcEncode = aes256.AesCBCEncode(repw);
        System.out.println(aes256CbcEncode);

        // 복호화
//        String aes256CbcDeocde = aes256.AesCBCDecode(aes256CbcEncode);

        float starval = (float) Double.parseDouble(starval1);

        // 2023-02-08 00:00:00
        LocalDateTime sdf1 = LocalDateTime.now();

        Af_reviewDto af_reviewDto = new Af_reviewDto(null, pjnum,rename,aes256CbcEncode,starval,retext,1,sdf1,sdf1);

        af_reviewService.save(af_reviewDto);

        return "/promotion/In_Af_review";
    }

}
