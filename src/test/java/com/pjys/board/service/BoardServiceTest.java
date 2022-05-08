package com.pjys.board.service;

import com.pjys.board.dto.BoardDTO;
import com.pjys.board.dto.CreateBoardRequest;
import com.pjys.board.entity.Board;
import com.pjys.board.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@Slf4j
@ExtendWith(MockitoExtension.class)
class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;

    @Test
    @DisplayName("게시판 추가 TEST")
    void 게시판_생성_테스트() {
        /* F.I.R.S.T Unit Test  */
        //given
        CreateBoardRequest boardRequest = CreateBoardRequest();
        Board board = createBoardEntity(boardRequest);

        Long fakeBoardId = 1L;
        ReflectionTestUtils.setField(board, "boardId", fakeBoardId);

        //moking
        given(boardRepository.save(any()))
                .willReturn(board);
        given(boardRepository.findById(fakeBoardId))
                .willReturn(Optional.ofNullable(board));
        //when
        Long newBoardId = boardService.createBoard(boardRequest);

        //then
        Board findBoard = boardRepository.findById(newBoardId).get();

        assertEquals(board.getBoardId(),findBoard.getBoardId());
        assertEquals(board.getTitle(),findBoard.getTitle());
        assertEquals(board.getContents(),findBoard.getContents());
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