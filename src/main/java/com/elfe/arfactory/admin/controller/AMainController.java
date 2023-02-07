package com.elfe.arfactory.admin.controller;

import com.elfe.arfactory.admin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AMainController {

    private UserRepository userRepository;

    @GetMapping("/")
    public String adminPage(Model m, HttpServletRequest request) {
        return "/admin/login.html";
    }

    @GetMapping("/main")
    public String adminMain(Model m, HttpServletRequest request) {
        m.addAttribute("pageName", "Admin Page");
        return "/admin/AdminMain.html";
    }

    @GetMapping("/login")
    public String login(Model m, HttpServletRequest request) {
        m.addAttribute("pageName", "Login Page");
        return "/admin/login.html";
    }






//    @Controller
//    @AllArgsConstructor
//    @RequestMapping("/solution")
//    public class SolutionController {
//
//
//    }




    @GetMapping("/af_project")
    public String AFPROJECT(Model m, HttpServletRequest request) {
        m.addAttribute("pageName", "AF_project Page");
        return "/admin/AFproject.html";
    }

    @GetMapping("/test")
    public String aTest(Model m, HttpServletRequest request) {
        m.addAttribute("pageName", "Test Page");
        return "/admin/adminTest.html";
    }
}
