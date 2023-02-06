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
@Table(name = "AF_REVIEW")
public class Af_reviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AR_SEQ")
    private Long AR_SEQ;

    @Column(name = "API1_SEQ")
    private Long API1_SEQ;

    @Column(name = "AR_NAME")
    private String AR_NAME;

    @Column(name = "AR_CONTENT")
    private String AR_CONTENT;

    @Column(name = "AR_STAR")
    private int AR_STAR;

    @Column(name = "AR_PASSWORD")
    private String AR_PASSWORD;

    @Column(name = "AR_STATE")
    private int AR_STATE;

    @Column(name = "AR_IDATETIME")
    private LocalDateTime AR_IDATETIME;

    @Column(name = "AR_UDATETIME")
    private LocalDateTime AR_UDATETIME;

    @Builder
    public Af_reviewEntity(Long aR_SEQ, Long aPI1_SEQ, String aR_NAME, String aR_CONTENT, int aR_STAR,
                        String aR_PASSWORD, int aR_STATE, LocalDateTime aPI6_IDATETIME, LocalDateTime aPI6_UDATETIME) {
        AR_SEQ = aR_SEQ;
        API1_SEQ = aPI1_SEQ;
        AR_NAME = aR_NAME;
        AR_CONTENT = aR_CONTENT;
        AR_STAR = aR_STAR;
        AR_PASSWORD = aR_PASSWORD;
        AR_STATE = aR_STATE;
        AR_IDATETIME = aPI6_IDATETIME;
        AR_UDATETIME = aPI6_UDATETIME;
    }
}
