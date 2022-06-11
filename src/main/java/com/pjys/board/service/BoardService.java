package com.pjys.board.service;

import com.pjys.board.dto.BoardDTO;
import com.pjys.board.dto.CreateBoardRequest;
import com.pjys.board.entity.Board;
import com.pjys.board.mapper.BoardMapper;
import com.pjys.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;

    private final BoardMapper mapper = Mappers.getMapper(BoardMapper.class);

    public Long createBoard(CreateBoardRequest board) {
        Board newBoard = boardRepository.save(board.toEntity());
        return newBoard.getBoardId();
    }

    public BoardDTO getBoard(Long boardId) {
        Board boardById = boardRepository.getById(boardId);
        return BoardDTO.fromEntity(boardById);
    }

    public List<BoardDTO> boardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = mapper.to(boardList);

        return boardDTOList;
    }
}
