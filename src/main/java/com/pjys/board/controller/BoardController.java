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
    public String boardDetail(Model model, @PathVariable long id) {
        BoardDTO board = boardService.getBoard(id);
        model.addAttribute("board", board);
        return "/board/board";
    }

    @PostMapping("/board/write")
    public String boardAdd(Model model, CreateBoardRequest createBoard) {
        createBoard.setUserName("이연희");
        createBoard.setUserId("lyh0208");
        Long newBoardId = boardService.createBoard(createBoard);
        //BoardDTO board = boardService.getBoard(newBoardId);
        //model.addAttribute("board", board);
        return "/board/board";
    }

    @GetMapping("/board/writeForm")
    public String boardWriteForm(Model model) {
        // TODO : 카테고리 개인화
        return "/board/board_form";
    }

    @GetMapping("/boards")
    public String boardList(Model model) {
        //BoardDTO board = boardService.getBoard(id);
        //model.addAttribute("board", board);
        return "/board/board_list";
    }
}
