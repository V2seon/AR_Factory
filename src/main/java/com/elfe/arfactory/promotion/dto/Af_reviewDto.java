package com.elfe.arfactory.promotion.dto;

import com.elfe.arfactory.promotion.entity.Af_reviewEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_reviewDto {

    private Long AR_SEQ;
    private Long API1_SEQ;
    private String AR_NAME;
    private String AR_CONTENT;
    private int AR_STAR;
    private String AR_PASSWORD;
    private int AR_STATE;
    private LocalDateTime AR_IDATETIME;
    private LocalDateTime AR_UDATETIME;

    @Builder
    public Af_reviewDto(Long aR_SEQ, Long aPI1_SEQ, String aR_NAME, String aR_CONTENT, int aR_STAR,
                        String aR_PASSWORD, int aR_STATE, LocalDateTime aPI6_IDATETIME, LocalDateTime aPI6_UDATETIME) {
        AR_SEQ = aR_SEQ;
        API1_SEQ = aPI1_SEQ;
        AR_NAME = aR_NAME;
        AR_CONTENT = aR_CONTENT;
        AR_STAR = aR_STAR;
        AR_PASSWORD = aR_PASSWORD;
        AR_STATE = aR_STATE;
        AR_IDATETIME = aPI6_IDATETIME;
        AR_UDATETIME = aPI6_UDATETIME;
    }

    public Af_reviewEntity toEntity(){
        Af_reviewEntity entity = Af_reviewEntity.builder()
                .aR_SEQ(AR_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aR_NAME(AR_NAME)
                .aR_CONTENT(AR_CONTENT)
                .aR_STAR(AR_STAR)
                .aR_PASSWORD(AR_PASSWORD)
                .aR_STATE(AR_STATE)
                .aPI6_IDATETIME(AR_IDATETIME)
                .aPI6_UDATETIME(AR_UDATETIME)
                .build();
        return entity;
    }

}
