package com.bigboard.boardserver.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.bigboard.boardserver.dto.UserDTO;
import com.bigboard.boardserver.exception.DuplicatedException;
import com.bigboard.boardserver.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public void register(UserDTO userProfile) {
        boolean duplicatedIdResult=isDuplicated(userProfile.getUserId());
        if(duplicatedIdResult){
            throw new DuplicatedException("중복된 아이디 입니다.");
        }
        userProfile.setCreateTime(new Date());
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isDuplicated'");
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
