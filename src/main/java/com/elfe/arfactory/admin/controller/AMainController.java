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
        log.info("test1");
        if(new SessionCheck().loginSessionCheck(request)){
            log.info("test2");
            m.addAttribute("pageName", "Admin Page");
            returnValue = "/admin/main.html";
        }else {
            log.info("test3");
            returnValue = "/admin";
        }
        return returnValue;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "userlogin")
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
            log.info("lgoin test");
        }else{
            log.info("login test2");
            //로그인실패
            msg.put("loginResult", "0");
        }
        return msg;
    }







//    @GetMapping("/af_project")
//    public String AFPROJECT(Model m, HttpServletRequest request) {
//        m.addAttribute("pageName", "AF_project Page");
//        return "/admin/AFproject.html";
//    }
//
//    @GetMapping("/test")
//    public String aTest(Model m, HttpServletRequest request) {
//        m.addAttribute("pageName", "Test Page");
//        return "/admin/adminTest.html";
//    }
}
