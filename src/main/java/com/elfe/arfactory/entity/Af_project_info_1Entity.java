package com.elfe.arfactory.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Setter
@Table(name = "AF_PROJECT_INFO_1")
public class Af_project_info_1Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "API1_NAME")
    private String API1_NAME;

    @Column(name = "API1_TYPE")
    private String API1_TYPE;

    @Column(name = "API1_NAME_E")
    private String API1_NAME_E;

    @Column(name = "API1_TYPE_R")
    private String API1_TYPE_R;

    @Column(name = "API1_PLAYSTORE")
    private String API1_PLAYSTORE;

    @Column(name = "API1_APPSTORE")
    private String API1_APPSTORE;

    @Column(name = "API1_VIEW_SEQ")
    private int API1_VIEW_SEQ;

    @Column(name = "API1_STATE")
    private int API1_STATE;

    @Column(name = "API1_IDATETIME")
    private LocalDateTime API1_IDATETIME;

    @Column(name = "API1_UDATETIME")
    private LocalDateTime API1_UDATETIME;

    @Builder
    public Af_project_info_1Entity(Long aPI1_SEQ, String aPI1_NAME, String aPI1_TYPE, String aPI1_NAME_E, String aPI1_TYPE_R,
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
}
