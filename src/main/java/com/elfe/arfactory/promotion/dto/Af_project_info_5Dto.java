package com.elfe.arfactory.promotion.dto;

import com.elfe.arfactory.promotion.entity.Af_project_info_5Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_project_info_5Dto {

    private Long API5_SEQ;
    private Long API1_SEQ;
    private String API5_CONTENT1;
    private String API5_CONTENT2;
    private String API5_CONTENT3;
    private LocalDateTime API5_IDATETIME;
    private LocalDateTime API5_UDATETIME;

    @Builder
    public Af_project_info_5Dto(Long aPI5_SEQ, Long aPI1_SEQ, String aPI5_CONTENT1, String aPI5_CONTENT2,
                                String aPI5_CONTENT3, LocalDateTime aPI5_IDATETIME, LocalDateTime aPI5_UDATETIME) {
        API5_SEQ = aPI5_SEQ;
        API1_SEQ = aPI1_SEQ;
        API5_CONTENT1 = aPI5_CONTENT1;
        API5_CONTENT2 = aPI5_CONTENT2;
        API5_CONTENT3 = aPI5_CONTENT3;
        API5_IDATETIME = aPI5_IDATETIME;
        API5_UDATETIME = aPI5_UDATETIME;
    }

    public Af_project_info_5Entity toEntity(){
        Af_project_info_5Entity entity = Af_project_info_5Entity.builder()
                .aPI5_SEQ(API5_SEQ)
                .aPI1_SEQ(API1_SEQ)
                .aPI5_CONTENT1(API5_CONTENT1)
                .aPI5_CONTENT2(API5_CONTENT2)
                .aPI5_CONTENT3(API5_CONTENT3)
                .aPI5_IDATETIME(API5_IDATETIME)
                .aPI5_UDATETIME(API5_UDATETIME)
                .build();
        return entity;
    }

}
