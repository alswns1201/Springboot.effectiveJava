package com.java.effective.study.web.dto;

import com.java.effective.study.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateResponseDto {

    private String title;
    private String content;


    @Builder
    public PostsUpdateResponseDto(String title, String content)
    {
        this.title =title;
        this.content =content;
    }


}
