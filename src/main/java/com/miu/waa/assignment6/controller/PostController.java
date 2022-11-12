package com.miu.waa.assignment6.controller;

import com.miu.waa.assignment6.domain.dto.CommentDto;
import com.miu.waa.assignment6.domain.dto.PostDto;
import com.miu.waa.assignment6.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<PostDto> getPosts(){
        return postService.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getPostById(@PathVariable long id){
        return postService.findById(id);

    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PostDto post) {
        postService.save(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        postService.deleteById(id);
    }

    @GetMapping("/{postId}/comments")
    public List<CommentDto> getComments(@PathVariable long postId){
        return postService.getComments(postId);
    }

    @PostMapping("/{postId}/comments")
    public void addComment(@PathVariable long postId,@RequestBody CommentDto commentDto){
        postService.addComment(postId,commentDto);
    }

    @GetMapping("/title/{title}")
    List<PostDto> getAllPostsWithTitleMatch(@PathVariable String title){
        return postService.findByTitleMatch(title);
    }
}
