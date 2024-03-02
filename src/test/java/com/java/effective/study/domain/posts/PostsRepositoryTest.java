package com.java.effective.study.domain.posts;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*; // static을 쓰면 바로 assertThat처럼 사용 가능.

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository repository;

    @AfterEach //Junit5에서는 @After -> @AfterEach 로 변경.
    public void cleanUp(){
        repository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title ="게시글 타이틀";
        String content = "게시글 내용";

        //@Build의 장점. 각 컬럼마다 순서와 상관없이 지정하여 값을 넣을수 있다.
        repository.save(Posts.builder().title(title).content(content).author("alswns1201@gmail.com").build());

        //when
        List<Posts> postList = repository.findAll();

        //then
        Posts post = postList.get(0);

        //then : 실제 post에 들어갔는가.
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);


    }


    @Test
    public void Auditing테스트(){
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,00,0,0);
        repository.save(Posts.builder().title("title").content("content").author("author").build());

        //when : 저장된걸 가지고 왔을떄
        List<Posts> postsList = repository.findAll();

        //then : 저장 날짜가 들어가 있는가 .
        Posts posts = postsList.get(0);
        System.out.println(posts.getCreateDate()+" "+ posts.getModifiedDate());
        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }


}