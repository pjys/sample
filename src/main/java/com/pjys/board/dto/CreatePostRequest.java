package com.pjys.board.dto;

import lombok.Data;

@Data
public class CreatePostRequest {
    private String title;
    private String contents;
    private Category category;
    private String userId;
    private String userName;
}
