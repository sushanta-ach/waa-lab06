package com.miu.waa.assignment6.controller;

import com.miu.waa.assignment6.aspect.annotation.ExecutionTime;
import com.miu.waa.assignment6.domain.Post;
import com.miu.waa.assignment6.domain.User;
import com.miu.waa.assignment6.domain.dto.UserDto;
import com.miu.waa.assignment6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
 public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    List<UserDto> getAll(){
        return userService.getAll();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getById(@PathVariable("id") long id){
        return userService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getAllPostByPostId(@PathVariable long id){
        return userService.getAllPostByPostId(id);
     }

     @GetMapping("/postsMoreThan/{num}")
    List<UserDto> getUserWithMorePostThanNum(@PathVariable int num){
        return userService.getUserWithMorePostThanNum(num);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }

}
