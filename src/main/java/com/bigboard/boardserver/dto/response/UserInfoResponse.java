package com.bigboard.boardserver.dto.response;

import com.bigboard.boardserver.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoResponse {
    private UserDTO userDTO;
}