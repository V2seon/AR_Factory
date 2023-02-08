package com.elfe.arfactory.promotion.entity;

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
@Table(name = "AF_PROJECT_INFO_5_E")
public class Af_project_info_5_eEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API5E_SEQ")
    private Long API5E_SEQ;

    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "API5E_CONTENT1")
    private String API5E_CONTENT1;

    @Column(name = "API5E_CONTENT2")
    private String API5E_CONTENT2;

    @Column(name = "API5E_CONTENT3")
    private String API5E_CONTENT3;

    @Column(name = "API5E_IDATETIME")
    private LocalDateTime API5E_IDATETIME;

    @Column(name = "API5E_UDATETIME")
    private LocalDateTime API5E_UDATETIME;

    @Builder
    public Af_project_info_5_eEntity(Long aPI5E_SEQ, Long aPI1_SEQ, String aPI5E_CONTENT1, String aPI5E_CONTENT2,
                                     String aPI5E_CONTENT3, LocalDateTime aPI5E_IDATETIME, LocalDateTime aPI5E_UDATETIME) {
        API5E_SEQ = aPI5E_SEQ;
        API1_SEQ = aPI1_SEQ;
        API5E_CONTENT1 = aPI5E_CONTENT1;
        API5E_CONTENT2 = aPI5E_CONTENT2;
        API5E_CONTENT3 = aPI5E_CONTENT3;
        API5E_IDATETIME = aPI5E_IDATETIME;
        API5E_UDATETIME = aPI5E_UDATETIME;
    }
}
