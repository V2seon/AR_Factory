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
@Table(name = "AF_PROJECT_INFO_2_E")
public class Af_project_info_2_eEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API2E_SEQ")
    private Long API2E_SEQ;

    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "API2E_CONTENTS")
    private String API2E_CONTENTS;

    @Column(name = "API2E_IMG1")
    private String API2E_IMG1;

    @Column(name = "API2E_IMG2")
    private String API2E_IMG2;

    @Column(name = "API2E_IMG3")
    private String API2E_IMG3;

    @Column(name = "API2E_IMG4")
    private String API2E_IMG4;

    @Column(name = "API2E_IMG5")
    private String API2E_IMG5;

    @Column(name = "API2E_IMG6")
    private String API2E_IMG6;

    @Column(name = "API2E_IDATETIME")
    private LocalDateTime API2E_IDATETIME;

    @Column(name = "API2E_UDATETIME")
    private LocalDateTime API2E_UDATETIME;

    @Builder
    public Af_project_info_2_eEntity(Long aPI2E_SEQ, Long aPI1_SEQ, String aPI2E_CONTENTS, String aPI2E_IMG1, String aPI2E_IMG2,
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
}
