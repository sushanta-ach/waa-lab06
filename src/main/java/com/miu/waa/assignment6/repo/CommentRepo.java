package com.miu.waa.assignment6.repo;

import com.miu.waa.assignment6.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {
}
