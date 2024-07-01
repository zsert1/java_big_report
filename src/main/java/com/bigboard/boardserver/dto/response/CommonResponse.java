package com.bigboard.boardserver.dto.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    private HttpStatus status;
    private String code;
    private String message;
    // 어떠한 값이 와도 받을 수 있도록
    private T requestBody;

}