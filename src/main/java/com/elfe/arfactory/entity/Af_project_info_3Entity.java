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
public class Af_project_info_3Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API3_SEQ")
    private Long API3_SEQ;

    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "API3_CONTENT1")
    private String API3_CONTENT1;

    @Column(name = "API3_CONTENT2")
    private String API3_CONTENT2;

    @Column(name = "API3_IDATETIME")
    private LocalDateTime API3_IDATETIME;

    @Column(name = "API3_UDATETIME")
    private LocalDateTime API3_UDATETIME;

    @Builder
    public Af_project_info_3Entity(Long aPI3_SEQ, Long aPI1_SEQ, String aPI3_CONTENT1, String aPI3_CONTENT2,
                                   LocalDateTime aPI3_IDATETIME, LocalDateTime aPI3_UDATETIME) {
        API3_SEQ = aPI3_SEQ;
        API1_SEQ = aPI1_SEQ;
        API3_CONTENT1 = aPI3_CONTENT1;
        API3_CONTENT2 = aPI3_CONTENT2;
        API3_IDATETIME = aPI3_IDATETIME;
        API3_UDATETIME = aPI3_UDATETIME;
    }
}
