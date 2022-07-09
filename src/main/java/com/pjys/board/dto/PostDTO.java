package com.pjys.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PostDTO {
    private long postId;
    private String title;
    private BoardDTO board;
    private Category category;
    private String contents;
    private String userId;
    private String userName;
    private boolean delete;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private int views;
    private int comments;
}
