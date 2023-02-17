package com.elfe.arfactory.promotion.controller;

import com.elfe.arfactory.promotion.entity.*;
import com.elfe.arfactory.promotion.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping
public class MainController {

    private Af_project_info_1Repository af_project_info_1Repository;
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
    private Af_reviewRepository af_reviewRepository;

    @GetMapping("/")
    public String main(Model m, HttpServletRequest request){

        List<Af_project_info_1Entity> viewconlist = af_project_info_1Repository.findAll(1L);
        List view = new ArrayList<>();
        for(int i=0; i<viewconlist.size(); i++){
            HashMap<String,Object> ad = new HashMap<String,Object>();
            Long num = viewconlist.get(i).getAPI1_SEQ();

            Optional<Af_project_info_2Entity> af_2Entity = af_project_info_2Repository.findByApi1seq(num);

            // 보여지는 후기 리스트 5개
            List<Af_reviewEntity> viewre = af_reviewRepository.findAll5(num);

            // 후기 갯수 및 평균 평점 리스트
            List<Af_reviewEntity> listcount = af_reviewRepository.findlistcount(num);

            float avg = 0;
            for(int j=0; j<listcount.size(); j++){
                avg+= listcount.get(j).getAR_STAR();
            }
            avg = avg/listcount.size();

            ad.put("seq",viewconlist.get(i).getAPI1_SEQ());
            ad.put("name",viewconlist.get(i).getAPI1_NAME());
            ad.put("type",viewconlist.get(i).getAPI1_TYPE());
            ad.put("img1",af_2Entity.get().getAPI2_IMG1());
            ad.put("img2",af_2Entity.get().getAPI2_IMG2());
            ad.put("img3",af_2Entity.get().getAPI2_IMG3());
            ad.put("img4",af_2Entity.get().getAPI2_IMG4());
            ad.put("img5",af_2Entity.get().getAPI2_IMG5());
            ad.put("img6",af_2Entity.get().getAPI2_IMG6());
            ad.put("data",af_2Entity.get().getAPI2_CONTENTS());
            ad.put("size",listcount.size());
            ad.put("viewre",viewre);
            ad.put("lang","KOR");
            ad.put("avg",String.format("%.1f",avg));
            view.add(ad);
        }

        m.addAttribute("view",view);



//        List<Af_reviewEntity> listcount1 = af_reviewRepository.findlistcount1();

//        System.out.println("메인에 보여지는 리스트 카운트  = " + viewre.size());
//
//        System.out.println("상태 1 인 후기 리스트 카운트 = " +listcount.size());

//        System.out.println("상태 1 인 후기 별점 평균값 = " +listcount1.get().getAR_STAR());

        return "/promotion/Main";
    }

    @GetMapping("/Eng_Af")
    public String engmain(Model m, HttpServletRequest request){
        List<Af_project_info_1Entity> viewconlist = af_project_info_1Repository.findAll(1L);
        List view = new ArrayList<>();
        for(int i=0; i<viewconlist.size(); i++){
            HashMap<String,Object> ad = new HashMap<String,Object>();
            Long num = viewconlist.get(i).getAPI1_SEQ();

            Optional<Af_project_info_2_eEntity> af_2_eEntity = af_project_info_2_eRepository.findByApi1seq(num);

            // 보여지는 후기 리스트 5개
            List<Af_reviewEntity> viewre = af_reviewRepository.findAll5(num);

            // 후기 갯수 및 평균 평점 리스트
            List<Af_reviewEntity> listcount = af_reviewRepository.findlistcount(num);

            float avg = 0;
            for(int j=0; j<listcount.size(); j++){
                avg+= listcount.get(j).getAR_STAR();
            }
            avg = avg/listcount.size();

            ad.put("seq",viewconlist.get(i).getAPI1_SEQ());
            ad.put("name",viewconlist.get(i).getAPI1_NAME());
            ad.put("type",viewconlist.get(i).getAPI1_TYPE());
//            ad.put("img1",af_2_eEntity.get().getAPI2E_IMG1());
//            ad.put("img2",af_2_eEntity.get().getAPI2E_IMG2());
//            ad.put("img3",af_2_eEntity.get().getAPI2E_IMG3());
//            ad.put("img4",af_2_eEntity.get().getAPI2E_IMG4());
//            ad.put("img5",af_2_eEntity.get().getAPI2E_IMG5());
//            ad.put("img6",af_2_eEntity.get().getAPI2E_IMG6());
//            ad.put("data",af_2_eEntity.get().getAPI2E_CONTENTS());
            ad.put("size",listcount.size());
            ad.put("viewre",viewre);
            ad.put("lang","ENG");
            ad.put("avg",String.format("%.1f",avg));
            view.add(ad);
        }

        m.addAttribute("view",view);



//        List<Af_reviewEntity> listcount1 = af_reviewRepository.findlistcount1();

//        System.out.println("메인에 보여지는 리스트 카운트  = " + viewre.size());
//
//        System.out.println("상태 1 인 후기 리스트 카운트 = " +listcount.size());

//        System.out.println("상태 1 인 후기 별점 평균값 = " +listcount1.get().getAR_STAR());

        return "/promotion/eng/Main";
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
