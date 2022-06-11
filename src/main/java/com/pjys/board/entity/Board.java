package com.pjys.board.entity;

import com.pjys.common.config.BooleanToYNConverter;
import com.pjys.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

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

    //@Lob //postresql 에서 이 타입을 작성할 경우, DB OID 로 저장됨 그래서 TEXT COLUMN 으로 변경
    @Column(columnDefinition="TEXT")
    private String contents; // 본문

    @Column(length = 2)
    //@Convert(converter = CategoryConverter.class)
    @Enumerated(EnumType.STRING)
    private Category category; // 카테고리

    private String userId; // 작성자Id

    private String userName; // 작성자명

    @Column(name = "delete_yn" ,length = 1)
    @Convert(converter = BooleanToYNConverter.class)
    private boolean isDelete; // 삭제여부

    private int views; // 조회수

    private int comments; // 댓글수

    public void addViewCount() {
        this.views ++;
    }

}