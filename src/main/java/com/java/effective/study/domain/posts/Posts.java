package com.java.effective.study.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가.
@Entity             // JPA에서 객체를 의미.
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increament가 적용.
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    private String author;


    @Builder
    public Posts(String title, String content, String author)
    {
        this.title =title;
        this.content = content;
        this.author =author;
    }

    public void update(String title, String content)
    {
        this.title =title;
        this.content =content;
    }

}
