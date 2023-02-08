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
@Table(name = "AF_PROJECT_INFO_5")
public class Af_project_info_5Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API5_SEQ")
    private Long API5_SEQ;

    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "API5_CONTENT1")
    private String API5_CONTENT1;

    @Column(name = "API5_CONTENT2")
    private String API5_CONTENT2;

    @Column(name = "API5_CONTENT3")
    private String API5_CONTENT3;

    @Column(name = "API5_IDATETIME")
    private LocalDateTime API5_IDATETIME;

    @Column(name = "API5_UDATETIME")
    private LocalDateTime API5_UDATETIME;

    @Builder
    public Af_project_info_5Entity(Long aPI5_SEQ, Long aPI1_SEQ, String aPI5_CONTENT1, String aPI5_CONTENT2,
                                String aPI5_CONTENT3, LocalDateTime aPI5_IDATETIME, LocalDateTime aPI5_UDATETIME) {
        API5_SEQ = aPI5_SEQ;
        API1_SEQ = aPI1_SEQ;
        API5_CONTENT1 = aPI5_CONTENT1;
        API5_CONTENT2 = aPI5_CONTENT2;
        API5_CONTENT3 = aPI5_CONTENT3;
        API5_IDATETIME = aPI5_IDATETIME;
        API5_UDATETIME = aPI5_UDATETIME;
    }
}
