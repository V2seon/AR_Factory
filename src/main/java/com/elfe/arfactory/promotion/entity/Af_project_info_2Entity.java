package com.elfe.arfactory.promotion.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Entity
@Setter
@Table(name = "AF_PROJECT_INFO_2")
public class Af_project_info_2Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API2_SEQ")
    private Long API2_SEQ;

    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "API2_CONTENTS")
    private String API2_CONTENTS;

    @Column(name = "API2_IMG1")
    private String API2_IMG1;

    @Column(name = "API2_IMG2")
    private String API2_IMG2;

    @Column(name = "API2_IMG3")
    private String API2_IMG3;

    @Column(name = "API2_IMG4")
    private String API2_IMG4;

    @Column(name = "API2_IMG5")
    private String API2_IMG5;

    @Column(name = "API2_IMG6")
    private String API2_IMG6;

    @Column(name = "API2_IDATETIME")
    private LocalDateTime API2_IDATETIME;

    @Column(name = "API2_UDATETIME")
    private LocalDateTime API2_UDATETIME;

    @Builder
    public Af_project_info_2Entity(Long aPI2_SEQ, Long aPI1_SEQ, String aPI2_CONTENTS, String aPI2_IMG1, String aPI2_IMG2,
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

}
