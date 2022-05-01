package com.pjys.board.entity;

import com.pjys.common.config.BooleanToYNConverter;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity(name = "board")
public class Board {

    @Id @GeneratedValue
    private long boardId;

    @Column(nullable = false)
    private String title;

    private String contents;

    @Column(length = 2)
    private String category;

    private String userId;

    private String userName;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean isDelete;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    private int views;
}