package com.miu.waa.assignment6.service;

import com.miu.waa.assignment6.domain.Post;
import com.miu.waa.assignment6.domain.User;
import com.miu.waa.assignment6.domain.dto.CommentDto;
import com.miu.waa.assignment6.domain.dto.PostDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PostService {
     List<PostDto> findAll();
     PostDto findById(long id);
    void save(PostDto postdto);
    void deleteById(long id);
    void addComment(long postId, CommentDto commentDto);
    List<CommentDto> getComments(long postId);
    List<PostDto> findByTitleMatch(String title);

}
