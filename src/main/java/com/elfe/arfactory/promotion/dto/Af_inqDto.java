package com.elfe.arfactory.promotion.dto;

import com.elfe.arfactory.promotion.entity.Af_inqEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_inqDto {

    private Long AI_SEQ;
    private Long API1_SEQ;
    private String AI_NAME;
    private String AI_PHONE;
    private int AI_OPT;
    private int AI_STATE;
    private int AI_STATE2;
    private LocalDateTime AI_IDATETIME;
    private LocalDateTime AI_UDATETIME;

    @Builder
    public Af_inqDto(Long aI_SEQ, Long aPI1_SEQ, String aI_NAME, String aI_PHONE, int aI_OPT, int aI_STATE
            , int aI_STATE2, LocalDateTime aI_IDATETIME, LocalDateTime aI_UDATETIME) {
        AI_SEQ = aI_SEQ;
        API1_SEQ = aPI1_SEQ;
        AI_NAME = aI_NAME;
        AI_PHONE = aI_PHONE;
        AI_OPT = aI_OPT;
        AI_STATE = aI_STATE;
        AI_STATE2 = aI_STATE2;
        AI_IDATETIME = aI_IDATETIME;
        AI_UDATETIME = aI_UDATETIME;
    }

    public Af_inqEntity toEntity(){
        Af_inqEntity entity = Af_inqEntity.builder()
                .aI_SEQ(AI_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aI_NAME(AI_NAME)
                .aI_PHONE(AI_PHONE)
                .aI_OPT(AI_OPT)
                .aI_STATE(AI_STATE)
                .aI_STATE2(AI_STATE2)
                .aI_IDATETIME(AI_IDATETIME)
                .aI_UDATETIME(AI_UDATETIME)
                .build();
        return entity;
    }

}
