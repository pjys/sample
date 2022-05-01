package com.pjys.board.service;

import com.pjys.board.dto.BoardDTO;
import com.pjys.board.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public BoardDTO createBoard(BoardDTO board) {
        return null;
    }
}
