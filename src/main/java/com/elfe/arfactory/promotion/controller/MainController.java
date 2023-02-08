package com.elfe.arfactory.promotion.controller;

import com.elfe.arfactory.promotion.entity.Af_project_info_2Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_2_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_3Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_3_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_4Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_4_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_5Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_5_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_6Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_6_eEntity;
import com.elfe.arfactory.promotion.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping
public class MainController {

    private Af_project_info_2Repository af_project_info_2Repository;
    private Af_project_info_3Repository af_project_info_3Repository;
    private Af_project_info_4Repository af_project_info_4Repository;
    private Af_project_info_5Repository af_project_info_5Repository;
    private Af_project_info_6Repository af_project_info_6Repository;
    private Af_project_info_2_eRepository af_project_info_2_eRepository;
    private Af_project_info_3_eRepository af_project_info_3_eRepository;
    private Af_project_info_4_eRepository af_project_info_4_eRepository;
    private Af_project_info_5_eRepository af_project_info_5_eRepository;
    private Af_project_info_6_eRepository af_project_info_6_eRepository;

    @GetMapping("/")
    public String main(Model m, HttpServletRequest request){

        Optional<Af_project_info_2Entity> af_2Entity = af_project_info_2Repository.findByApi1seq(0L);
        m.addAttribute("data",af_2Entity);

        return "/promotion/Main";
    }

    @ResponseBody
    @RequestMapping(value = "/view_con", method = RequestMethod.POST)
    public Object view_con(HttpServletRequest request, Model m,
                                           @RequestParam(required = false, defaultValue = "", value = "pjnum") Long pjnum,
                                           @RequestParam(required = false, defaultValue = "", value = "datanum")int datanum,
                                           @RequestParam(required = false, defaultValue = "", value = "lagse")String lagse){

        HashMap<String, Object> msg = new HashMap<String, Object>();
        if(lagse.equals("KOR")){
            msg.put("lagse","KOR");
            if(datanum == 1){
                Optional<Af_project_info_2Entity> af_2Entity = af_project_info_2Repository.findByApi1seq(pjnum);
                msg.put("data1", af_2Entity);
                msg.put("datanum","1");
            }else if(datanum == 2){
                Optional<Af_project_info_3Entity> af_3Entity = af_project_info_3Repository.findByApi1seq(pjnum);
                Optional<Af_project_info_6Entity> af_6Entity = af_project_info_6Repository.findByApi1seq(pjnum);
                msg.put("data1", af_3Entity);
                msg.put("datanum","2");
            }else if(datanum == 3){
                Optional<Af_project_info_4Entity> af_4Entity = af_project_info_4Repository.findByApi1seq(pjnum);
                msg.put("data1", af_4Entity);
                msg.put("datanum","3");
            }else if(datanum == 4){
                Optional<Af_project_info_5Entity> af_5Entity = af_project_info_5Repository.findByApi1seq(pjnum);
                msg.put("data1", af_5Entity);
                msg.put("datanum","4");
            }
        }else if(lagse.equals("ENG")){
            msg.put("lagse","ENG");
            if(datanum == 1){
                Optional<Af_project_info_2_eEntity> af_2_eEntity = af_project_info_2_eRepository.findByApi1seq(pjnum);
                msg.put("data1", af_2_eEntity);
                msg.put("datanum","1");
            }else if(datanum == 2){
                Optional<Af_project_info_3_eEntity> af_3_eEntity = af_project_info_3_eRepository.findByApi1seq(pjnum);
                Optional<Af_project_info_6_eEntity> af_6_eEntity = af_project_info_6_eRepository.findByApi1seq(pjnum);
                msg.put("data1", af_3_eEntity);
                msg.put("datanum","2");
            }else if(datanum == 3){
                Optional<Af_project_info_4_eEntity> af_4_eEntity = af_project_info_4_eRepository.findByApi1seq(pjnum);
                msg.put("data1", af_4_eEntity);
                msg.put("datanum","3");
            }else if(datanum == 4){
                Optional<Af_project_info_5_eEntity> af_5_eEntity = af_project_info_5_eRepository.findByApi1seq(pjnum);
                msg.put("data1", af_5_eEntity);
                msg.put("datanum","4");
            }
        }
        return msg;
    }



}
