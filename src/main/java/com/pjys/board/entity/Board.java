package com.pjys.board.entity;

import com.pjys.common.config.BooleanToYNConverter;
import com.pjys.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*

    게시판 테이블

 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "board")
public class Board extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "brd_id")
    private long boardId; // 게시판번호

    @Column(name = "name", nullable = false)
    private String name; // 제목

    @Column(name = "user_id")
    private String userId; // 생성자 ID

    @Column(name = "user_name")
    private String userName; // 생성자명

    @Column(name = "delete_yn" ,length = 1)
    @Convert(converter = BooleanToYNConverter.class)
    private boolean delete = false; // 삭제여부

}