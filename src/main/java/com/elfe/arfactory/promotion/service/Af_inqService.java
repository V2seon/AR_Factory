package com.elfe.arfactory.promotion.service;

import com.elfe.arfactory.promotion.repository.Af_inqRepository;
import lombok.AllArgsConstructor;
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

}
