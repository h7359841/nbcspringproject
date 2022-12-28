package com.sparta.education.application.service.dto;

import com.sparta.education.application.service.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponse {
    private final String title;
    private final String writer;
    private final String content;
    private final LocalDateTime dateCreated;
    private final LocalDateTime dateUpdated;

    public BoardResponse(Board board) {
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.content = board.getContent();
        this.dateCreated = board.getDateCreated();
        this.dateUpdated = board.getDateUpdated();
    }
}
