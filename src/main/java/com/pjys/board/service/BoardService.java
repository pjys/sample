package com.pjys.board.service;

import com.pjys.board.dto.BoardDTO;
import com.pjys.board.dto.CreateBoardRequest;
import com.pjys.board.entity.Board;
import com.pjys.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;

    public Long createBoard(CreateBoardRequest board) {
        Board newBoard = boardRepository.save(board.toEntity());
        return newBoard.getBoardId();
    }

    public BoardDTO getBoard(Long boardId) {
        Board boardById = boardRepository.getById(boardId);
        return BoardDTO.fromEntity(boardById);
    }
}
