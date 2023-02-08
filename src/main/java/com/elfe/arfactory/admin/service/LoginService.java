package com.elfe.arfactory.admin.service;

import com.elfe.arfactory.admin.dto.UserDto;
import com.elfe.arfactory.admin.entity.UserEntity;
import com.elfe.arfactory.admin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LoginService {
    private UserRepository userRepository;
    @Transactional
    public int loginAdmin(String userid, String userpw){
        int returnValue = 0;
        Optional<UserEntity> optionalAdminEntity = userRepository.findByAaidAndAapw(userid, userpw);
        if(!optionalAdminEntity.isPresent()){
            returnValue = 0;
        }else{
            returnValue = 1;
        }
        return returnValue;
    }


    @Transactional
    public Long save(UserDto userDto){
        UserEntity userEntity = userDto.toEntity();
        userRepository.save(userEntity);
        return userDto.getAA_SEQ();
    }
}
