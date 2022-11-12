package com.miu.waa.assignment6.service;



import com.miu.waa.assignment6.domain.Post;
import com.miu.waa.assignment6.domain.User;
import com.miu.waa.assignment6.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    UserDto getById(long id);
    void save(User user);
    List<Post> getAllPostByPostId(long id);
    List<UserDto> getUserWithMorePostThanNum(int num);
    void deleteById(long id);
}
