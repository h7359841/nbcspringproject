package com.sparta.education.controller;

import com.sparta.education.application.service.BoardService;
import com.sparta.education.application.service.dto.BoardResponse;
import com.sparta.education.application.service.dto.CreateBoardRequest;
import com.sparta.education.application.service.dto.UpdateBoardRequest;
import com.sparta.education.application.service.entity.Board;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("boards")
    public void createBoard(@RequestBody CreateBoardRequest createBoardRequest) {
        boardService.createBoard(createBoardRequest);
    }

    @GetMapping("boards/{boardId}")
    public BoardResponse getBoard(@PathVariable Long boardId) {
        return boardService.getBoard(boardId);
    }

    @PutMapping("boards/{boardId}")
    public void updateBoard(@PathVariable Long boardId, @RequestBody UpdateBoardRequest updateBoardRequest) {
        boardService.updateBoard(boardId, updateBoardRequest);
    }

    @DeleteMapping("boards/{boardId}")
    public void deleteBoard(@PathVariable Long boardId, @RequestParam String password) {
        System.out.println("password : " + password);
        boardService.deleteBoard(boardId, password);
    }

}
