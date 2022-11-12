package com.miu.waa.assignment6.service.impl;

import com.miu.waa.assignment6.domain.Comment;
import com.miu.waa.assignment6.domain.Post;
import com.miu.waa.assignment6.domain.dto.CommentDto;
import com.miu.waa.assignment6.domain.dto.PostDto;
import com.miu.waa.assignment5.repo.PostRepo;
import com.miu.waa.assignment6.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<PostDto> findAll() {
        return postRepo.findAll().stream()
                .map(p->modelMapper.map(p,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.findById(id),PostDto.class);
    }

    @Override
    public void save(PostDto postdto) {
        Post post=modelMapper.map(postdto,Post.class);
        postRepo.save(post);
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void addComment(long id, CommentDto commentDto) {
        Post post=postRepo.findById(id);
        if(post!=null){
            post.getComments().add(modelMapper.map(commentDto,Comment.class));
            postRepo.save(post);
        }
    }

    @Override
    public List<CommentDto>getComments(long postId){
       List<Comment> comments=postRepo.findComments(postId);
       return comments.stream()
               .map(c->modelMapper.map(c,CommentDto.class))
               .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByTitleMatch(String title) {
        var posts=postRepo.findByTitleLike(title);
        return posts.stream()
                .map(p->modelMapper.map(p,PostDto.class))
                .collect(Collectors.toList());
    }
}
