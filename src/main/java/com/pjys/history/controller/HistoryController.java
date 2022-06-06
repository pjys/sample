package com.pjys.history.controller;

import com.pjys.history.model.HistoryDTO;
import com.pjys.history.service.HistroyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class HistoryController {

    @Autowired
    private final HistroyService histroyService;

    @ApiOperation(value = "borad 모든 이력 조회", notes = "boardhistory 테이블의 모든정보를 가져온다")
    @GetMapping("/board/history")
    public ResponseEntity<List<HistoryDTO>> allSelectHistory() {
        return ResponseEntity.ok(histroyService.allSelectHistory());
    }
}
