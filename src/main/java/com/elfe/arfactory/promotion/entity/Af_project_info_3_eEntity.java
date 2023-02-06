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
@Table(name = "AF_PROJECT_INFO_3")
public class Af_project_info_3_eEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API3E_SEQ")
    private Long API3E_SEQ;

    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "API3E_CONTENT1")
    private String API3E_CONTENT1;

    @Column(name = "API3E_CONTENT2")
    private String API3E_CONTENT2;

    @Column(name = "API3E_IDATETIME")
    private LocalDateTime API3E_IDATETIME;

    @Column(name = "API3E_UDATETIME")
    private LocalDateTime API3E_UDATETIME;

    @Builder
    public Af_project_info_3_eEntity(Long aPI3E_SEQ, Long aPI1_SEQ, String aPI3E_CONTENT1, String aPI3E_CONTENT2,
                                     LocalDateTime aPI3E_IDATETIME, LocalDateTime aPI3E_UDATETIME) {
        API3E_SEQ = aPI3E_SEQ;
        API1_SEQ = aPI1_SEQ;
        API3E_CONTENT1 = aPI3E_CONTENT1;
        API3E_CONTENT2 = aPI3E_CONTENT2;
        API3E_IDATETIME = aPI3E_IDATETIME;
        API3E_UDATETIME = aPI3E_UDATETIME;
    }
}
