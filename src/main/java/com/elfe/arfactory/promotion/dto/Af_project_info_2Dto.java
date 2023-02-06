package com.elfe.arfactory.dto;

import com.elfe.arfactory.entity.Af_project_info_2Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_project_info_2Dto {

    private Long API2_SEQ;
    private Long API1_SEQ;
    private String API2_CONTENTS;
    private String API2_IMG1;
    private String API2_IMG2;
    private String API2_IMG3;
    private String API2_IMG4;
    private String API2_IMG5;
    private String API2_IMG6;
    private LocalDateTime API2_IDATETIME;
    private LocalDateTime API2_UDATETIME;

    @Builder
    public Af_project_info_2Dto(Long aPI2_SEQ, Long aPI1_SEQ, String aPI2_CONTENTS, String aPI2_IMG1, String aPI2_IMG2,
                                   String aPI2_IMG3, String aPI2_IMG4, String aPI2_IMG5, String aPI2_IMG6,
                                   LocalDateTime aPI2_IDATETIME,LocalDateTime aPI2_UDATETIME) {
        API2_SEQ = aPI2_SEQ;
        API1_SEQ = aPI1_SEQ;
        API2_CONTENTS = aPI2_CONTENTS;
        API2_IMG1 = aPI2_IMG1;
        API2_IMG2 = aPI2_IMG2;
        API2_IMG3 = aPI2_IMG3;
        API2_IMG4 = aPI2_IMG4;
        API2_IMG5 = aPI2_IMG5;
        API2_IMG6 = aPI2_IMG6;
        API2_IDATETIME = aPI2_IDATETIME;
        API2_UDATETIME = aPI2_UDATETIME;
    }

    public Af_project_info_2Entity toEntity(){
        Af_project_info_2Entity entity = Af_project_info_2Entity.builder()
                .aPI2_SEQ(API2_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aPI2_CONTENTS(API2_CONTENTS)
                .aPI2_IMG1(API2_IMG1)
                .aPI2_IMG2(API2_IMG2)
                .aPI2_IMG3(API2_IMG3)
                .aPI2_IMG4(API2_IMG4)
                .aPI2_IMG5(API2_IMG5)
                .aPI2_IMG6(API2_IMG6)
                .aPI2_IDATETIME(API2_IDATETIME)
                .aPI2_UDATETIME(API2_UDATETIME)
                .build();
        return entity;
    }

}
