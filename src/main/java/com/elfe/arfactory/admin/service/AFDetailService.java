package com.elfe.arfactory.admin.service;

import com.elfe.arfactory.promotion.dto.*;
import com.elfe.arfactory.promotion.entity.*;
import com.elfe.arfactory.promotion.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class AFDetailService {
    private Af_project_info_2Repository api2Repository;
    private Af_project_info_3Repository api3Repository;
    private Af_project_info_4Repository api4Repository;
    private Af_project_info_5Repository api5Repository;
    private Af_project_info_6Repository api6Repository;
    private Af_project_info_2_eRepository api2eRepository;
    private Af_project_info_3_eRepository api3eRepository;
    private Af_project_info_4_eRepository api4eRepository;
    private Af_project_info_5_eRepository api5eRepository;
    private Af_project_info_6_eRepository api6eRepository;

    @Transactional
    public Long api2Save(Af_project_info_2Dto api2Dto){
        Af_project_info_2Entity api2Entity = api2Dto.toEntity();
        api2Repository.save(api2Entity);
        return api2Dto.getAPI2_SEQ();
    }

    @Transactional
    public Long api2eSave(Af_project_info_2_eDto api2eDto){
        Af_project_info_2_eEntity api2eEntity = api2eDto.toEntity();
        api2eRepository.save(api2eEntity);
        return api2eDto.getAPI2E_SEQ();
    }
    @Transactional
    public Long api3Save(Af_project_info_3Dto api3Dto){
        Af_project_info_3Entity api3Entity = api3Dto.toEntity();
        api3Repository.save(api3Entity);
        return api3Dto.getAPI3_SEQ();
    }

    @Transactional
    public Long api3eSave(Af_project_info_3_eDto api3eDto){
        Af_project_info_3_eEntity api3eEntity = api3eDto.toEntity();
        api3eRepository.save(api3eEntity);
        return api3eDto.getAPI3E_SEQ();
    }
    @Transactional
    public Long api4Save(Af_project_info_4Dto api4Dto){
        Af_project_info_4Entity api4Entity = api4Dto.toEntity();
        api4Repository.save(api4Entity);
        return api4Dto.getAPI4_SEQ();
    }

    @Transactional
    public Long api4eSave(Af_project_info_4_eDto api4eDto){
        Af_project_info_4_eEntity api4eEntity = api4eDto.toEntity();
        api4eRepository.save(api4eEntity);
        return api4eDto.getAPI4E_SEQ();
    }
    @Transactional
    public Long api5Save(Af_project_info_5Dto api5Dto){
        Af_project_info_5Entity api5Entity = api5Dto.toEntity();
        api5Repository.save(api5Entity);
        return api5Dto.getAPI5_SEQ();
    }

    @Transactional
    public Long api5eSave(Af_project_info_5_eDto api5eDto){
        Af_project_info_5_eEntity api5eEntity = api5eDto.toEntity();
        api5eRepository.save(api5eEntity);
        return api5eDto.getAPI5E_SEQ();
    }

    @Transactional
    public Long api6Save(Af_project_info_6Dto api6Dto){
        Af_project_info_6Entity api6Entity = api6Dto.toEntity();
        api6Repository.save(api6Entity);
        return api6Dto.getAPI6_SEQ();
    }

    @Transactional
    public Long api6eSave(Af_project_info_6_eDto api6eDto){
        Af_project_info_6_eEntity api6eEntity = api6eDto.toEntity();
        api6eRepository.save(api6eEntity);
        return api6eDto.getAPI6E_SEQ();
    }

}
