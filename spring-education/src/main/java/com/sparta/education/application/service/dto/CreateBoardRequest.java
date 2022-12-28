package com.sparta.education.application.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateBoardRequest {
    private String title;
    private String writer;
    private String password;
    private String content;

}
