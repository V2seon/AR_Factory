package com.elfe.arfactory.promotion.service;

import com.elfe.arfactory.promotion.dto.Af_inqDto;
import com.elfe.arfactory.promotion.dto.Af_reviewDto;
import com.elfe.arfactory.promotion.repository.Af_inqRepository;
import com.elfe.arfactory.promotion.repository.Af_reviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class Af_reviewService {

    private Af_reviewRepository af_reviewRepository;

    @Transactional
    public Long save(Af_reviewDto af_reviewDto){
        return af_reviewRepository.save(af_reviewDto.toEntity()).getAR_SEQ();
    }

}
