package com.pjys.board.dto;

import com.pjys.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BoardDTO {
    private long boardId;
    private String title;
    private String contents;
    private String category;
    private String userId;
    private String userName;
    private boolean isDelete;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private int views;
    private int comments;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .contents(contents)
                .category(category)
                .userId(userId)
                .userName(userName)
                .isDelete(false)
                .views(0)
                .comments(0)
                .build();
    }

    public static BoardDTO fromEntity(Board board){
        return BoardDTO.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .contents(board.getContents())
                .category(board.getCategory())
                .userId(board.getUserId())
                .userName(board.getUserName())
                .isDelete(board.isDelete())
                .createDate(board.getCreateDate())
                .updateDate(board.getUpdateDate())
                .views(board.getViews())
                .comments(board.getComments())
                .build();
    }
}
