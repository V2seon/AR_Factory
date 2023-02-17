package com.elfe.arfactory.admin.controller;

import com.elfe.arfactory.admin.common.SessionCheck;
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
}
