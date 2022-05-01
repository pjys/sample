package com.pjys.board.controller;

import com.pjys.board.dto.BoardDTO;
import com.pjys.board.repository.BoardRepository;
import com.pjys.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/{id}")
    public String getBoard(@PathVariable long id) {

        return "";
    }

    @PostMapping("/createBoard")
    public String createBoard(BoardDTO boardDTO) {

        BoardDTO board = boardService.createBoard(boardDTO);

        return "";
    }
}
