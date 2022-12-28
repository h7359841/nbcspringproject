package com.sparta.education.repository;

import com.sparta.education.application.service.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
