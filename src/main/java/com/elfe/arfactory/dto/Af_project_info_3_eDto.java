package com.elfe.arfactory.dto;

import com.elfe.arfactory.entity.Af_project_info_3_eEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_project_info_3_eDto {

    private Long API3E_SEQ;
    private Long API1_SEQ;
    private String API3E_CONTENT1;
    private String API3E_CONTENT2;
    private LocalDateTime API3E_IDATETIME;
    private LocalDateTime API3E_UDATETIME;

    @Builder
    public Af_project_info_3_eDto(Long aPI3E_SEQ, Long aPI1_SEQ, String aPI3E_CONTENT1, String aPI3E_CONTENT2,
                                     LocalDateTime aPI3E_IDATETIME, LocalDateTime aPI3E_UDATETIME) {
        API3E_SEQ = aPI3E_SEQ;
        API1_SEQ = aPI1_SEQ;
        API3E_CONTENT1 = aPI3E_CONTENT1;
        API3E_CONTENT2 = aPI3E_CONTENT2;
        API3E_IDATETIME = aPI3E_IDATETIME;
        API3E_UDATETIME = aPI3E_UDATETIME;
    }

    public Af_project_info_3_eEntity toEntity(){
        Af_project_info_3_eEntity entity = Af_project_info_3_eEntity.builder()
                .aPI3E_SEQ(API3E_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aPI3E_CONTENT1(API3E_CONTENT1)
                .aPI3E_CONTENT2(API3E_CONTENT2)
                .aPI3E_IDATETIME(API3E_IDATETIME)
                .aPI3E_UDATETIME(API3E_UDATETIME)
                .build();
        return entity;
    }

}
