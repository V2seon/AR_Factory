package com.elfe.arfactory.admin.dto;

import com.elfe.arfactory.admin.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private Long AA_SEQ;
    private String AA_ID;
    private String AA_PW;

    @Builder
    public UserDto(Long aa_SEQ, String aa_ID, String aa_PW){
        AA_SEQ = aa_SEQ;
        AA_ID = aa_ID;
        AA_PW = aa_PW;
    }

    public UserEntity toEntity(){
        UserEntity entity = UserEntity.builder()
                .aa_seq(AA_SEQ)
                .aa_id(AA_ID)
                .aa_pw(AA_PW)
                .build();
        return entity;
    }
}
