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
@Table(name = "AF_INQ")
public class Af_inqEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AI_SEQ")
    private Long AI_SEQ;

    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "AI_NAME")
    private String AI_NAME;

    @Column(name = "AI_PHONE")
    private String AI_PHONE;

    @Column(name = "AI_OPT")
    private int AI_OPT;

    @Column(name = "AI_STATE")
    private int AI_STATE;

    @Column(name = "AI_STATE2")
    private int AI_STATE2;

    @Column(name = "AI_IDATETIME")
    private LocalDateTime AI_IDATETIME;

    @Column(name = "AI_UDATETIME")
    private LocalDateTime AI_UDATETIME;

    @Builder
    public Af_inqEntity(Long aI_SEQ, Long aPI1_SEQ, String aI_NAME, String aI_PHONE, int aI_OPT, int aI_STATE
            , int aI_STATE2, LocalDateTime aI_IDATETIME, LocalDateTime aI_UDATETIME) {
        AI_SEQ = aI_SEQ;
        API1_SEQ = aPI1_SEQ;
        AI_NAME = aI_NAME;
        AI_PHONE = aI_PHONE;
        AI_OPT = aI_OPT;
        AI_STATE = aI_STATE;
        AI_STATE2 = aI_STATE2;
        AI_IDATETIME = aI_IDATETIME;
        AI_UDATETIME = aI_UDATETIME;
    }
}
