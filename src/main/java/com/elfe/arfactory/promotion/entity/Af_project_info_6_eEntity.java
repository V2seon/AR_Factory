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
@Table(name = "AF_PROJECT_INFO_6_E")
public class Af_project_info_6_eEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API6E_SEQ")
    private Long API6E_SEQ;

    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "API6E_OPT1")
    private String API6E_OPT1;

    @Column(name = "API6E_OPT2")
    private String API6E_OPT2;

    @Column(name = "API6E_OPT3")
    private String API6E_OPT3;

    @Column(name = "API6E_OPT4")
    private String API6E_OPT4;

    @Column(name = "API6E_OPT5")
    private String API6E_OPT5;

    @Column(name = "API6E_OPT6")
    private String API6E_OPT6;

    @Column(name = "API6E_OPT7")
    private String API6E_OPT7;

    @Column(name = "API6E_IDATETIME")
    private LocalDateTime API6E_IDATETIME;

    @Column(name = "API6E_UDATETIME")
    private LocalDateTime API6E_UDATETIME;

    @Builder
    public Af_project_info_6_eEntity(Long aPI6E_SEQ, Long aPI1_SEQ, String aPI6E_OPT1, String aPI6E_OPT2, String aPI6E_OPT3,
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
}
