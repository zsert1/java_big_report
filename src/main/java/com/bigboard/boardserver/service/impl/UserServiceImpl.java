package com.bigboard.boardserver.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigboard.boardserver.dto.UserDTO;
import com.bigboard.boardserver.exception.DuplicatedException;
import com.bigboard.boardserver.mapper.UserProfileMapper;
import com.bigboard.boardserver.service.UserService;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public boolean isDuplicated(String id) {
        return userProfileMapper.idCheck(id)==1;
        // TODO Auto-generated method stub
    }

    @Override
    public UserDTO getUserInfo(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserInfo'");
    }

    @Override
    public void updatePassword(String id, String beforePassword, String afterPassword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePassword'");
    }

    @Override
    public void deleteId(String id, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteId'");
    }

}
