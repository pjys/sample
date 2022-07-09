package com.pjys.board.entity;

import com.pjys.board.dto.BoardCode;
import com.pjys.common.config.BooleanToYNConverter;
import com.pjys.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
    사용자별 게시판 설정
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "board_meta")
public class BoardMeta extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "bm_id")
    private long bmId;

    private String userId; // 사용자ID

    private BoardCode boardCode; // 게시판 공통 코드

    private String codeId; // 게시판 고유 코드

    private String codeName;

    @Column(name = "active_yn" ,length = 1)
    @Convert(converter = BooleanToYNConverter.class)
    private boolean isActive; // 사용여부
}