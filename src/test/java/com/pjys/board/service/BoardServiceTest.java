package com.pjys.board.service;

import com.pjys.board.dto.BoardDTO;
import com.pjys.board.dto.CreateBoardRequest;
import com.pjys.board.entity.Board;
import com.pjys.board.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
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

    @Test
    @DisplayName("게시판 추가 TEST")
    void 게시판_생성_테스트_JUNIT5() {
        /* F.I.R.S.T Unit Test  */
        //given
        CreateBoardRequest createBoardRequest = CreateBoardRequest();
        Board board = createBoardEntity(createBoardRequest);

        when(boardRepository.save(any())).thenReturn(board);
        Long result = boardService.createBoard(createBoardRequest);

        verify(boardRepository, times(1)).save(any());
        assertNotNull(result);
    }

    private Board createBoardEntity(CreateBoardRequest createBoardRequest) {
        return Board.builder()
                .title(createBoardRequest.getTitle())
                .category(createBoardRequest.getCategory())
                .contents(createBoardRequest.getContents())
                .userId(createBoardRequest.getUserId())
                .userName(createBoardRequest.getUserName())
                .build();
    }
}