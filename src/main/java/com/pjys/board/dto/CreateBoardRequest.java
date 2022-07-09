package com.pjys.board.dto;

import lombok.Data;

@Data
public class CreateBoardRequest {
    private String name;
    private String contents;
    private Category category;
    private String userId;
    private String userName;
}
