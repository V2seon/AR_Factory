package com.elfe.arfactory.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Setter
@Table(name = "AF_ADMIN")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AA_SEQ")
    private Long aaseq;

    @Column(name = "AA_ID")
    private String aaid;

    @Column(name = "AA_PW")
    private String aapw;

    @Builder
    public UserEntity(Long aa_seq, String aa_id, String aa_pw){
        this.aaseq = aa_seq;
        this.aaid = aa_id;
        this.aapw = aa_pw;
    }
}
