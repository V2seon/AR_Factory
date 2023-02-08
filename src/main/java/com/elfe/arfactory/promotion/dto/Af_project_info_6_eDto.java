package com.elfe.arfactory.promotion.dto;

import com.elfe.arfactory.promotion.entity.Af_project_info_6_eEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_project_info_6_eDto {

    private Long API6E_SEQ;
    private Long API1_SEQ;
    private String API6E_OPT1;
    private String API6E_OPT2;
    private String API6E_OPT3;
    private String API6E_OPT4;
    private String API6E_OPT5;
    private String API6E_OPT6;
    private String API6E_OPT7;
    private LocalDateTime API6E_IDATETIME;
    private LocalDateTime API6E_UDATETIME;

    @Builder
    public Af_project_info_6_eDto(Long aPI6E_SEQ, Long aPI1_SEQ, String aPI6E_OPT1, String aPI6E_OPT2, String aPI6E_OPT3,
                                  String aPI6E_OPT4, String aPI6E_OPT5, String aPI6E_OPT6, String aPI6E_OPT7,
                                  LocalDateTime aPI6E_IDATETIME, LocalDateTime aPI6E_UDATETIME) {
        API6E_SEQ = aPI6E_SEQ;
        API1_SEQ = aPI1_SEQ;
        API6E_OPT1 = aPI6E_OPT1;
        API6E_OPT2 = aPI6E_OPT2;
        API6E_OPT3 = aPI6E_OPT3;
        API6E_OPT4 = aPI6E_OPT4;
        API6E_OPT5 = aPI6E_OPT5;
        API6E_OPT6 = aPI6E_OPT6;
        API6E_OPT7 = aPI6E_OPT7;
        API6E_IDATETIME = aPI6E_IDATETIME;
        API6E_UDATETIME = aPI6E_UDATETIME;
    }

    public Af_project_info_6_eEntity toEntity(){
        Af_project_info_6_eEntity entity = Af_project_info_6_eEntity.builder()
                .aPI6E_SEQ(API6E_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aPI6E_OPT1(API6E_OPT1)
                .aPI6E_OPT2(API6E_OPT2)
                .aPI6E_OPT3(API6E_OPT3)
                .aPI6E_OPT4(API6E_OPT4)
                .aPI6E_OPT5(API6E_OPT5)
                .aPI6E_OPT6(API6E_OPT6)
                .aPI6E_OPT7(API6E_OPT7)
                .aPI6E_IDATETIME(API6E_IDATETIME)
                .aPI6E_UDATETIME(API6E_UDATETIME)
                .build();
        return entity;
    }

}
