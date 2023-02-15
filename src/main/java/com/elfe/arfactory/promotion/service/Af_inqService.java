package com.elfe.arfactory.promotion.service;

import com.elfe.arfactory.promotion.entity.Af_inqEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_1Entity;
import com.elfe.arfactory.promotion.repository.Af_inqRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.elfe.arfactory.promotion.dto.Af_inqDto;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class Af_inqService {

    private Af_inqRepository af_inqRepository;

    @Transactional
    public Long save(Af_inqDto af_inqDto){
        return af_inqRepository.save(af_inqDto.toEntity()).getAI_SEQ();
    }


    @Transactional
    public Page<Af_inqEntity> getAIList(Pageable pageable){
        return af_inqRepository.findAIAllList(pageable);
    }
}
