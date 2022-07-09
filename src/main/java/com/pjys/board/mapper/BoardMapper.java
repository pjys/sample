package com.pjys.board.mapper;

import com.pjys.board.dto.BoardDTO;
import com.pjys.board.dto.CreateBoardRequest;
import com.pjys.board.entity.Board;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    Board to(BoardDTO boardDTO);
    Board to(CreateBoardRequest createBoardRequest);
    BoardDTO to(Board board);

    List<BoardDTO> to(List<Board> boardList);
}
