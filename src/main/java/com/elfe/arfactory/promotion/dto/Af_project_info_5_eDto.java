package com.elfe.arfactory.promotion.dto;

import com.elfe.arfactory.promotion.entity.Af_project_info_5_eEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_project_info_5_eDto {

    private Long API5E_SEQ;
    private Long API1_SEQ;
    private String API5E_CONTENT1;
    private String API5E_CONTENT2;
    private String API5E_CONTENT3;
    private LocalDateTime API5E_IDATETIME;
    private LocalDateTime API5E_UDATETIME;

    @Builder
    public Af_project_info_5_eDto(Long aPI5E_SEQ, Long aPI1_SEQ, String aPI5E_CONTENT1, String aPI5E_CONTENT2,
                                     String aPI5E_CONTENT3, LocalDateTime aPI5E_IDATETIME, LocalDateTime aPI5E_UDATETIME) {
        API5E_SEQ = aPI5E_SEQ;
        API1_SEQ = aPI1_SEQ;
        API5E_CONTENT1 = aPI5E_CONTENT1;
        API5E_CONTENT2 = aPI5E_CONTENT2;
        API5E_CONTENT3 = aPI5E_CONTENT3;
        API5E_IDATETIME = aPI5E_IDATETIME;
        API5E_UDATETIME = aPI5E_UDATETIME;
    }

    public Af_project_info_5_eEntity toEntity(){
        Af_project_info_5_eEntity entity = Af_project_info_5_eEntity.builder()
                .aPI5E_SEQ(API5E_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aPI5E_CONTENT1(API5E_CONTENT1)
                .aPI5E_CONTENT2(API5E_CONTENT2)
                .aPI5E_CONTENT3(API5E_CONTENT3)
                .aPI5E_IDATETIME(API5E_IDATETIME)
                .aPI5E_UDATETIME(API5E_UDATETIME)
                .build();
        return entity;
    }

}
