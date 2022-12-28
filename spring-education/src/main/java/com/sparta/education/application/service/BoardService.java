package com.sparta.education.application.service;

import com.sparta.education.application.service.dto.BoardResponse;
import com.sparta.education.application.service.dto.CreateBoardRequest;
import com.sparta.education.application.service.dto.UpdateBoardRequest;
import com.sparta.education.application.service.entity.Board;
import com.sparta.education.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void createBoard(CreateBoardRequest createBoardRequest) {
        Board board = new Board(createBoardRequest.getTitle(), createBoardRequest.getWriter(), createBoardRequest.getPassword(), createBoardRequest.getContent());
        boardRepository.save(board);

    }

    public BoardResponse getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시물 없음"));
        return new BoardResponse(board);
    }

    @Transactional
    public void updateBoard(Long boardId, UpdateBoardRequest updateBoardRequest) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시물 없음"));
        // 수정 요청시 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인후 업데이트하기
        if(board.isValidPassword(updateBoardRequest.getPassword())) {
            board.update(updateBoardRequest.getTitle(), updateBoardRequest.getWriter(), updateBoardRequest.getContent());
            boardRepository.save(board);
        } else {
            throw new IllegalArgumentException("패스워드가 틀렸습니다.");
        }
    }

    public void deleteBoard(Long boardId, String password) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시물 없음"));
        if(board.isValidPassword(password)) {
            boardRepository.delete(board);
        } else {
            throw new IllegalArgumentException("패스워드가 틀렸습니다.");
        }
    }

    public List<BoardResponse> getBoardList() {
        List<Board> boardList = boardRepository.findAllByOrderByDateCreatedDesc();
        List<BoardResponse> boardResponseList = new ArrayList<>();
        for(Board board : boardList) {
            boardResponseList.add(new BoardResponse(board));
        }
        return boardResponseList;
    }
}
