package com.pjys.board.controller;

import com.pjys.board.dto.BoardDTO;
import com.pjys.board.dto.CreateBoardRequest;
import com.pjys.board.entity.Board;
import com.pjys.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @GetMapping("/board/{id}")
    public String getBoard(Model model, @PathVariable long id) {
        BoardDTO board = boardService.getBoard(id);
        model.addAttribute("board", board);
        return "/board";
    }

    @PostMapping("/createBoard")
    public String createBoard(Model model, CreateBoardRequest createBoard) {
        Long newBoardId = boardService.createBoard(createBoard);
        BoardDTO board = boardService.getBoard(newBoardId);
        model.addAttribute("board", board);
        return "/board";
    }
}
