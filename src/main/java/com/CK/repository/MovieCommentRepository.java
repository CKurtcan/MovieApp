package com.CK.repository;

import com.CK.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCommentRepository extends JpaRepository<MovieComment, Long> {
}
