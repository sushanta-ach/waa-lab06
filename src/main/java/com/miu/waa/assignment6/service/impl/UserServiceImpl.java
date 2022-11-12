package com.miu.waa.assignment6.service.impl;

import com.miu.waa.assignment6.domain.Post;
import com.miu.waa.assignment6.domain.User;

import com.miu.waa.assignment6.domain.dto.UserDto;
import com.miu.waa.assignment6.repo.UserRepo;
import com.miu.waa.assignment6.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<UserDto> getAll() {
        return userRepo.findAll().stream()
                .map(p -> modelMapper.map(p, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public List<Post> getAllPostByPostId(long id) {
        return userRepo.getAllPostByPostId(id);
    }

    @Override
    public List<UserDto> getUserWithMorePostThanNum(int num) {
        List<User> usersPosts=userRepo.getUserWithMorePostThanNum(num);

        return usersPosts.stream()
                .map(p->modelMapper.map(p,UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

//    @Override
//    public List<UserDto> getUserWithMorePost() {
//       List<User> usersWithMorePost=userRepo.getUserWithMoreThanOnePost();
//       return usersWithMorePost.stream()
//               .map(user->modelMapper.map(user,UserDto.class))
//               .collect(Collectors.toList());
//    }
}
