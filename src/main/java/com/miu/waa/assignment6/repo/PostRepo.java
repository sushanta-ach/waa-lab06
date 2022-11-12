package com.miu.waa.assignment5.repo;

import com.miu.waa.assignment6.domain.Comment;
import com.miu.waa.assignment6.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PostRepo extends JpaRepository<Post, Long> {
    Post findById(long id);
    @Query(value="select p.comments from Post p where p.id=:id")
    List<Comment> findComments(long id);

   //@Query(value="select p from Post p where p.title like %title")
    List<Post> findByTitleLike(String title);
}
