package com.pjys.board.entity;

import com.pjys.common.config.BooleanToYNConverter;
import com.pjys.common.entity.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "board")
public class Board extends BaseEntity {

    @Id @GeneratedValue
    private long boardId; // 게시글번호

    @Column(nullable = false)
    private String title; // 제목

    @Lob
    private String contents; // 본문

    @Column(length = 2)
    private String category; // 카테고리

    private String userId; // 작성자Id

    private String userName; // 작성자명

    @Column(name = "delete_yn" ,length = 1)
    @Convert(converter = BooleanToYNConverter.class)
    private boolean isDelete; // 삭제여부

    private int views; // 조회수

    private int comments; // 댓글수

}