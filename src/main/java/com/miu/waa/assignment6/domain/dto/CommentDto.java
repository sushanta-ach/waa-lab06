package com.miu.waa.assignment6.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    @Id
    long id;
    String name;
}
