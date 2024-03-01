package com.java.effective.study.web.dto;

import com.java.effective.study.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class PostsResponseDto {

        private Long id;
        private String title;
        private String content;
        private String author;


        public PostsResponseDto(Posts entity)
        {
            this.id = entity.getId();
            this.title =entity.getTitle();
            this.content =entity.getContent();
            this.author = entity.getAuthor();
        }




}
