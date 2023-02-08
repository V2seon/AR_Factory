package com.elfe.arfactory.promotion.dto;

import com.elfe.arfactory.promotion.entity.Af_project_info_6Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_project_info_6Dto {

    private Long API6_SEQ;
    private Long API1_SEQ;
    private String API6_OPT1;
    private String API6_OPT2;
    private String API6_OPT3;
    private String API6_OPT4;
    private String API6_OPT5;
    private String API6_OPT6;
    private String API6_OPT7;
    private LocalDateTime API6_IDATETIME;
    private LocalDateTime API6_UDATETIME;

    @Builder
    public Af_project_info_6Dto(Long aPI6_SEQ, Long aPI1_SEQ, String aPI6_OPT1, String aPI6_OPT2, String aPI6_OPT3,
                                String aPI6_OPT4,String aPI6_OPT5,String aPI6_OPT6,String aPI6_OPT7,
                                LocalDateTime aPI6_IDATETIME, LocalDateTime aPI6_UDATETIME) {
        API6_SEQ = aPI6_SEQ;
        API1_SEQ = aPI1_SEQ;
        API6_OPT1 = aPI6_OPT1;
        API6_OPT2 = aPI6_OPT2;
        API6_OPT3 = aPI6_OPT3;
        API6_OPT4 = aPI6_OPT4;
        API6_OPT5 = aPI6_OPT5;
        API6_OPT6 = aPI6_OPT6;
        API6_OPT7 = aPI6_OPT7;
        API6_IDATETIME = aPI6_IDATETIME;
        API6_UDATETIME = aPI6_UDATETIME;
    }

    public Af_project_info_6Entity toEntity(){
        Af_project_info_6Entity entity = Af_project_info_6Entity.builder()
                .aPI6_SEQ(API6_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aPI6_OPT1(API6_OPT1)
                .aPI6_OPT2(API6_OPT2)
                .aPI6_OPT3(API6_OPT3)
                .aPI6_OPT4(API6_OPT4)
                .aPI6_OPT5(API6_OPT5)
                .aPI6_OPT6(API6_OPT6)
                .aPI6_OPT7(API6_OPT7)
                .aPI6_IDATETIME(API6_IDATETIME)
                .aPI6_UDATETIME(API6_UDATETIME)
                .build();
        return entity;
    }

}
