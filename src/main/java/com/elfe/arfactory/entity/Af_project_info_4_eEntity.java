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
@Table(name = "AF_PROJECT_INFO_4_E")
public class Af_project_info_4_eEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API4E_SEQ")
    private Long API4E_SEQ;

    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "API4E_CONTENT1")
    private String API4E_CONTENT1;

    @Column(name = "API4E_CONTENT2")
    private String API4E_CONTENT2;

    @Column(name = "API4E_CONTENT3")
    private String API4E_CONTENT3;

    @Column(name = "API4E_CONTENT4")
    private String API4E_CONTENT4;

    @Column(name = "API4E_IDATETIME")
    private LocalDateTime API4E_IDATETIME;

    @Column(name = "API4E_UDATETIME")
    private LocalDateTime API4E_UDATETIME;

    @Builder
    public Af_project_info_4_eEntity(Long aPI4E_SEQ, Long aPI1_SEQ, String aPI4E_CONTENT1, String aPI4E_CONTENT2, String aPI4E_CONTENT3,
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
}
