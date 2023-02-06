package com.elfe.arfactory.dto;

import com.elfe.arfactory.entity.Af_project_info_1Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Af_project_info_1Dto {

    private Long API1_SEQ;
    private String API1_NAME;
    private String API1_TYPE;
    private String API1_NAME_E;
    private String API1_TYPE_R;
    private String API1_PLAYSTORE;
    private String API1_APPSTORE;
    private int API1_VIEW_SEQ;
    private int API1_STATE;
    private LocalDateTime API1_IDATETIME;
    private LocalDateTime API1_UDATETIME;

    @Builder
    public Af_project_info_1Dto(Long aPI1_SEQ, String aPI1_NAME, String aPI1_TYPE, String aPI1_NAME_E, String aPI1_TYPE_R,
                                String aPI1_PLAYSTORE, String aPI1_APPSTORE, int aPI1_VIEW_SEQ, int aPI1_STATE,
                                LocalDateTime aPI1_IDATETIME,LocalDateTime aPI1_UDATETIME) {
        API1_SEQ = aPI1_SEQ;
        API1_NAME = aPI1_NAME;
        API1_TYPE = aPI1_TYPE;
        API1_NAME_E = aPI1_NAME_E;
        API1_TYPE_R = aPI1_TYPE_R;
        API1_PLAYSTORE = aPI1_PLAYSTORE;
        API1_APPSTORE = aPI1_APPSTORE;
        API1_VIEW_SEQ = aPI1_VIEW_SEQ;
        API1_STATE = aPI1_STATE;
        API1_IDATETIME = aPI1_IDATETIME;
        API1_UDATETIME = aPI1_UDATETIME;
    }

    public Af_project_info_1Entity toEntity(){
        Af_project_info_1Entity entity = Af_project_info_1Entity.builder()
                .aPI1_SEQ(API1_SEQ)
                .aPI1_NAME(API1_NAME)
                .aPI1_TYPE(API1_TYPE)
                .aPI1_NAME_E(API1_NAME_E)
                .aPI1_TYPE_R(API1_TYPE_R)
                .aPI1_PLAYSTORE(API1_PLAYSTORE)
                .aPI1_APPSTORE(API1_APPSTORE)
                .aPI1_VIEW_SEQ(API1_VIEW_SEQ)
                .aPI1_STATE(API1_STATE)
                .aPI1_IDATETIME(API1_IDATETIME)
                .aPI1_UDATETIME(API1_UDATETIME)
                .build();
        return entity;
    }
}
