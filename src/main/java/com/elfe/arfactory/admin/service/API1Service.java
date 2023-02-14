package com.elfe.arfactory.admin.service;

//import com.elfe.arfactory.admin.repository.Af_project_info_1Repository;
import com.elfe.arfactory.promotion.dto.Af_project_info_1Dto;
import com.elfe.arfactory.promotion.repository.Af_project_info_1Repository;
import com.elfe.arfactory.promotion.entity.Af_project_info_1Entity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class API1Service {
    private Af_project_info_1Repository api1Repository;

    @Transactional
    public Long api1Save(Af_project_info_1Dto api1Dto){
        Af_project_info_1Entity api1Entity = api1Dto.toEntity();
        api1Repository.save(api1Entity);
        return api1Dto.getAPI1_SEQ();
    }

    @Transactional
    public Page<Af_project_info_1Entity> getAPI1List(Pageable pageable){
        return api1Repository.findAPI1AllList(pageable);
    }
}
