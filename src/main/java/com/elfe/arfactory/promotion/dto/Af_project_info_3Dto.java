package com.elfe.arfactory.promotion.dto;

import com.elfe.arfactory.promotion.entity.Af_project_info_3Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_project_info_3Dto {

    private Long API3_SEQ;
    private Long API1_SEQ;
    private String API3_CONTENT1;
    private String API3_CONTENT2;
    private LocalDateTime API3_IDATETIME;
    private LocalDateTime API3_UDATETIME;

    @Builder
    public Af_project_info_3Dto(Long aPI3_SEQ, Long aPI1_SEQ, String aPI3_CONTENT1, String aPI3_CONTENT2,
                                   LocalDateTime aPI3_IDATETIME, LocalDateTime aPI3_UDATETIME) {
        API3_SEQ = aPI3_SEQ;
        API1_SEQ = aPI1_SEQ;
        API3_CONTENT1 = aPI3_CONTENT1;
        API3_CONTENT2 = aPI3_CONTENT2;
        API3_IDATETIME = aPI3_IDATETIME;
        API3_UDATETIME = aPI3_UDATETIME;
    }

    public Af_project_info_3Entity toEntity(){
        Af_project_info_3Entity entity = Af_project_info_3Entity.builder()
                .aPI3_SEQ(API3_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aPI3_CONTENT1(API3_CONTENT1)
                .aPI3_CONTENT2(API3_CONTENT2)
                .aPI3_IDATETIME(API3_IDATETIME)
                .aPI3_UDATETIME(API3_UDATETIME)
                .build();
        return entity;
    }

}
