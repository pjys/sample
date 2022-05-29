package com.pjys.board.dto;

import com.pjys.board.entity.Board;
import com.pjys.board.entity.Category;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateBoardRequest {
    private String title;
    private String contents;
    private String category;
    private String userId;
    private String userName;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .contents(contents)
                .category(Category.enumOf(category))
                .userId(userId)
                .userName(userName)
                .isDelete(false)
                .views(0)
                .comments(0)
                .build();
    }
}
