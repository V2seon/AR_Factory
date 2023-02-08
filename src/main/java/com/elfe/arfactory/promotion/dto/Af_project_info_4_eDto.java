package com.elfe.arfactory.promotion.dto;

import com.elfe.arfactory.promotion.entity.Af_project_info_4_eEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_project_info_4_eDto {

    private Long API4E_SEQ;
    private Long API1_SEQ;
    private String API4E_CONTENT1;
    private String API4E_CONTENT2;
    private String API4E_CONTENT3;
    private String API4E_CONTENT4;
    private LocalDateTime API4E_IDATETIME;
    private LocalDateTime API4E_UDATETIME;

    @Builder
    public Af_project_info_4_eDto(Long aPI4E_SEQ, Long aPI1_SEQ, String aPI4E_CONTENT1, String aPI4E_CONTENT2, String aPI4E_CONTENT3,
                                  String aPI4E_CONTENT4, LocalDateTime aPI4E_IDATETIME, LocalDateTime aPI4E_UDATETIME) {
        API4E_SEQ = aPI4E_SEQ;
        API1_SEQ = aPI1_SEQ;
        API4E_CONTENT1 = aPI4E_CONTENT1;
        API4E_CONTENT2 = aPI4E_CONTENT2;
        API4E_CONTENT3 = aPI4E_CONTENT3;
        API4E_CONTENT4 = aPI4E_CONTENT4;
        API4E_IDATETIME = aPI4E_IDATETIME;
        API4E_UDATETIME = aPI4E_UDATETIME;
    }

    public Af_project_info_4_eEntity toEntity(){
        Af_project_info_4_eEntity entity = Af_project_info_4_eEntity.builder()
                .aPI4E_SEQ(API4E_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aPI4E_CONTENT1(API4E_CONTENT1)
                .aPI4E_CONTENT2(API4E_CONTENT2)
                .aPI4E_CONTENT1(API4E_CONTENT3)
                .aPI4E_CONTENT2(API4E_CONTENT4)
                .aPI4E_IDATETIME(API4E_IDATETIME)
                .aPI4E_UDATETIME(API4E_UDATETIME)
                .build();
        return entity;
    }

}
