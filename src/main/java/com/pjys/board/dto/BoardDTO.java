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
public class BoardDTO {
    private long boardId;
    private String name;
    private String userId;
    private String userName;
    private boolean delete;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
