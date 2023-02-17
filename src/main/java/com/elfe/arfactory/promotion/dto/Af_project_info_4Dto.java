package com.elfe.arfactory.promotion.dto;

import com.elfe.arfactory.promotion.entity.Af_project_info_4Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_project_info_4Dto {

    private Long API4_SEQ;
    private Long API1_SEQ;
    private String API4_CONTENT1;
    private String API4_CONTENT2;
    private String API4_CONTENT3;
    private String API4_CONTENT4;
    private LocalDateTime API4_IDATETIME;
    private LocalDateTime API4_UDATETIME;

    @Builder
    public Af_project_info_4Dto(Long aPI4_SEQ, Long aPI1_SEQ, String aPI4_CONTENT1, String aPI4_CONTENT2, String aPI4_CONTENT3,
                                String aPI4_CONTENT4,LocalDateTime aPI4_IDATETIME, LocalDateTime aPI4_UDATETIME) {
        API4_SEQ = aPI4_SEQ;
        API1_SEQ = aPI1_SEQ;
        API4_CONTENT1 = aPI4_CONTENT1;
        API4_CONTENT2 = aPI4_CONTENT2;
        API4_CONTENT3 = aPI4_CONTENT3;
        API4_CONTENT4 = aPI4_CONTENT4;
        API4_IDATETIME = aPI4_IDATETIME;
        API4_UDATETIME = aPI4_UDATETIME;
    }

    public Af_project_info_4Entity toEntity(){
        Af_project_info_4Entity entity = Af_project_info_4Entity.builder()
                .aPI4_SEQ(API4_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aPI4_CONTENT1(API4_CONTENT1)
                .aPI4_CONTENT2(API4_CONTENT2)
                .aPI4_CONTENT3(API4_CONTENT3)
                .aPI4_CONTENT4(API4_CONTENT4)
                .aPI4_IDATETIME(API4_IDATETIME)
                .aPI4_UDATETIME(API4_UDATETIME)
                .build();
        return entity;
    }

}
