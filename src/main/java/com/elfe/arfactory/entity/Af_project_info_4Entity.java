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
@Table(name = "AF_PROJECT_INFO_4")
public class Af_project_info_4Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API4_SEQ")
    private Long API4_SEQ;

    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "API4_CONTENT1")
    private String API4_CONTENT1;

    @Column(name = "API4_CONTENT2")
    private String API4_CONTENT2;

    @Column(name = "API4_CONTENT3")
    private String API4_CONTENT3;

    @Column(name = "API4_CONTENT4")
    private String API4_CONTENT4;

    @Column(name = "API4_IDATETIME")
    private LocalDateTime API4_IDATETIME;

    @Column(name = "API4_UDATETIME")
    private LocalDateTime API4_UDATETIME;

    @Builder
    public Af_project_info_4Entity(Long aPI4_SEQ, Long aPI1_SEQ, String aPI4_CONTENT1, String aPI4_CONTENT2,String aPI4_CONTENT3
                                    ,String aPI4_CONTENT4,LocalDateTime aPI4_IDATETIME, LocalDateTime aPI4_UDATETIME) {
        API4_SEQ = aPI4_SEQ;
        API1_SEQ = aPI1_SEQ;
        API4_CONTENT1 = aPI4_CONTENT1;
        API4_CONTENT2 = aPI4_CONTENT2;
        API4_CONTENT3 = aPI4_CONTENT3;
        API4_CONTENT4 = aPI4_CONTENT4;
        API4_IDATETIME = aPI4_IDATETIME;
        API4_UDATETIME = aPI4_UDATETIME;
    }
}
