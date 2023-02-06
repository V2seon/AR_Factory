package com.elfe.arfactory.dto;

import com.elfe.arfactory.entity.Af_project_info_2_eEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_project_info_2_eDto {

    private Long API2E_SEQ;
    private Long API1_SEQ;
    private String API2E_CONTENTS;
    private String API2E_IMG1;
    private String API2E_IMG2;
    private String API2E_IMG3;
    private String API2E_IMG4;
    private String API2E_IMG5;
    private String API2E_IMG6;
    private LocalDateTime API2E_IDATETIME;
    private LocalDateTime API2E_UDATETIME;

    @Builder
    public Af_project_info_2_eDto(Long aPI2E_SEQ, Long aPI1_SEQ, String aPI2E_CONTENTS, String aPI2E_IMG1, String aPI2E_IMG2,
                                  String aPI2E_IMG3, String aPI2E_IMG4, String aPI2E_IMG5, String aPI2E_IMG6,
                                  LocalDateTime aPI2E_IDATETIME, LocalDateTime aPI2E_UDATETIME) {
        API2E_SEQ = aPI2E_SEQ;
        API1_SEQ = aPI1_SEQ;
        API2E_CONTENTS = aPI2E_CONTENTS;
        API2E_IMG1 = aPI2E_IMG1;
        API2E_IMG2 = aPI2E_IMG2;
        API2E_IMG3 = aPI2E_IMG3;
        API2E_IMG4 = aPI2E_IMG4;
        API2E_IMG5 = aPI2E_IMG5;
        API2E_IMG6 = aPI2E_IMG6;
        API2E_IDATETIME = aPI2E_IDATETIME;
        API2E_UDATETIME = aPI2E_UDATETIME;
    }

    public Af_project_info_2_eEntity toEntity(){
        Af_project_info_2_eEntity entity = Af_project_info_2_eEntity.builder()
                .aPI2E_SEQ(API2E_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aPI2E_CONTENTS(API2E_CONTENTS)
                .aPI2E_IMG1(API2E_IMG1)
                .aPI2E_IMG2(API2E_IMG2)
                .aPI2E_IMG3(API2E_IMG3)
                .aPI2E_IMG4(API2E_IMG4)
                .aPI2E_IMG5(API2E_IMG5)
                .aPI2E_IMG6(API2E_IMG6)
                .aPI2E_IDATETIME(API2E_IDATETIME)
                .aPI2E_UDATETIME(API2E_UDATETIME)
                .build();
        return entity;
    }

}
