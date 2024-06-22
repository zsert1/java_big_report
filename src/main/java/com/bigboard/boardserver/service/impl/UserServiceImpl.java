package com.bigboard.boardserver.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigboard.boardserver.dto.UserDTO;
import com.bigboard.boardserver.exception.DuplicatedException;
import com.bigboard.boardserver.mapper.UserProfileMapper;
import com.bigboard.boardserver.service.UserService;
import com.bigboard.boardserver.util.SHA256Util;

import static com.bigboard.boardserver.util.SHA256Util.encryptSHA256;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService{
   
   
    @Autowired
    private UserProfileMapper userProfileMapper;

    public UserServiceImpl(UserProfileMapper userProfileMapper) {
        this.userProfileMapper = userProfileMapper;
    }

    @Override
    public void register(UserDTO userProfile) {
        boolean duplicatedIdResult=isDuplicated(userProfile.getUserId());
        if(duplicatedIdResult){
            throw new DuplicatedException("중복된 아이디 입니다.");
        }
        userProfile.setCreateTime(new Date());
        userProfile.setPassword(encryptSHA256(userProfile.getPassword()));
        int insertCount =userProfileMapper.register(userProfile);

        if(insertCount !=1){
            log.error("insert Error 회원가입 메서드 확인 필요\n" +"Params:"+ userProfile);
        }
         // userProfile.setPassword()
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public UserDTO login(String id, String password) {
        String cryptoPassword=encryptSHA256(password);
        UserDTO memDto=userProfileMapper.findByIdAndPassword(id, cryptoPassword);
        return memDto;
    }

    @Override
    public boolean isDuplicated(String id) {
        return userProfileMapper.idCheck(id)==1;
    }

    @Override
    public UserDTO getUserInfo(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserInfo'");
    }

    @Override
    public void updatePassword(String id, String beforePassword, String afterPassword) {
        String cryptoPassword=encryptSHA256(beforePassword);
        UserDTO memberInfo=userProfileMapper.findByIdAndPassword(id, cryptoPassword);
        if(memberInfo != null){
            memberInfo.setPassword(encryptSHA256(afterPassword));
            userProfileMapper.updatePassword(memberInfo);
        } else {
            log.error("updatePasswrod ERROR! {}", memberInfo);
            throw new IllegalArgumentException("updatePasswrod ERROR! 비밀번호 변경 메서드를 확인해주세요\n" + "Params : " + memberInfo);
        }
    }

    @Override
    public void deleteId(String id, String password) {
        String cryptoPassword = SHA256Util.encryptSHA256(password);
        UserDTO memberInfo = userProfileMapper.findByIdAndPassword(id, cryptoPassword);

        if (memberInfo != null) {
            userProfileMapper.deleteUserProfile(memberInfo.getUserId());
        } else {
            log.error("deleteId ERROR! {}", memberInfo);
            throw new RuntimeException("deleteId ERROR! id 삭제 메서드를 확인해주세요\n" + "Params : " + memberInfo);
        }
    }

}
