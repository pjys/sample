package com.pjys.board.entity;

import com.pjys.board.dto.Category;
import com.pjys.common.config.BooleanToYNConverter;
import com.pjys.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "post")
public class Post extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private long postId;

    @Column(name = "title",nullable = false)
    private String title; // 제목

    @ManyToOne
    @JoinColumn(name = "brd_id")
    private Board board; // 게시판 정보

    @Column(length = 15)
    @Enumerated(EnumType.STRING)
    private Category category; // 카테고리

    //@Lob // Postresql 에서 이 타입을 작성할 경우, DB OID 로 저장됨 그래서 TEXT COLUMN 으로 변경
    @Column(name = "contents", columnDefinition="TEXT")
    private String contents; // 본문

    @Column(name = "user_id")
    private String userId; // 작성자Id

    @Column(name = "user_name")
    private String userName; // 작성자명

    @Column(name = "delete_yn" ,length = 1)
    @Convert(converter = BooleanToYNConverter.class)
    private boolean delete = false; // 삭제여부

    @Column(name = "views")
    private int views = 0; // 조회수

    @Column(name = "comments")
    private int comments = 0; // 댓글수

    public void addViewCount() {
        this.views ++;
    }
}
