package com.miu.waa.assignment6.repo;


import com.miu.waa.assignment6.domain.Post;
import com.miu.waa.assignment6.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByName(String name);

    @Query(value = "SELECT u.posts from User u WHERE u.id = :id")
    List<Post> getAllPostByPostId(long id);

    @Query(value="select u FROM User u where size(u.posts)>:num")
    List<User>getUserWithMorePostThanNum(int num);

}
