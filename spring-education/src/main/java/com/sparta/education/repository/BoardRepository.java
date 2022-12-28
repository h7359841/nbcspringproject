package com.sparta.education.repository;

import com.sparta.education.application.service.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByOrderByDateCreatedDesc();
}
