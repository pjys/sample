package com.pjys.board.service;

import com.pjys.board.dto.BoardDTO;
import com.pjys.board.dto.CreateBoardRequest;
import com.pjys.board.entity.Board;
import com.pjys.board.repository.BoardRepository;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
class BoardServiceTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;

    @Test
    @DisplayName("Auditing 기능 적용")
    void 게시판_생성_테스트() {
        // given
        CreateBoardRequest boardRequest = CreateBoardRequest();

        // when
        Long newBoardId = boardService.createBoard(boardRequest);
        Board findBoard = boardRepository.findById(newBoardId).get();

        // then
        Assert.assertNotNull(findBoard.getCreateDate());
    }

    @Test
    @DisplayName("게시판 조회 테스트")
    void 게시판_조회_테스트() {
        // given
        CreateBoardRequest boardRequest = CreateBoardRequest();

        // when
        Long newBoardId = boardService.createBoard(boardRequest);
        BoardDTO boardDTO = boardService.getBoard(newBoardId);

        // then
        Assert.assertNotNull(boardDTO.getCreateDate());
    }

    private CreateBoardRequest CreateBoardRequest() {
        CreateBoardRequest boardRequest = new CreateBoardRequest();
        boardRequest.setTitle("게시판테스트");
        boardRequest.setCategory("1");
        boardRequest.setContents("게시판내용");
        boardRequest.setUserId("lyh0208");
        boardRequest.setUserName("이연희");
        return boardRequest;
    }
}