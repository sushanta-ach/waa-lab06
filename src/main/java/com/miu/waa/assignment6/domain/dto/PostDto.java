package com.miu.waa.assignment6.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    long id;
    String title;
    String content;
    String author;
}
