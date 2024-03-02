package com.java.effective.study.web;

import com.java.effective.study.domain.posts.Posts;
import com.java.effective.study.domain.posts.PostsRepository;
import com.java.effective.study.web.dto.PostSaveRequestDto;
import com.java.effective.study.web.dto.PostsUpdateResponseDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {

    @LocalServerPort
    private int port;


    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void repositoryClear() throws Exception{
        postsRepository.deleteAll();
    }

    @Test
    public void Post등록테스트() throws Exception{
        //given
        String title = "title_test";
        String content ="content_test";

        PostSaveRequestDto requestDto =  PostSaveRequestDto.builder().title(title).content(content).author("author").build();

        String url ="http://localhost:";
        url = url+port+"/api/v1/posts";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url,requestDto,Long.class);


        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);

    }

    @Test
    public void 조회후수정_테스트() throws Exception{
         //given
        //임시로 데이터를 넣고.
        Posts data  = postsRepository.save(Posts.builder().title("임시타이틀").content("임시컨텐츠").build());

        Long update_id = data.getId();
        String update_title = "반영타이틀";
        String update_content ="반영컨텐츠";


        PostsUpdateResponseDto updateDto = PostsUpdateResponseDto.builder().title(update_title).content(update_content).build();

        String url ="http://localhost:";
        url = url+port+"/api/v1/posts/"+update_id;

        HttpEntity<PostsUpdateResponseDto> requestEntity = new HttpEntity<>(updateDto);

        //when
          ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,requestEntity,Long.class);
            /**오류 아직 모르겟음.
             * Error while extracting response for type [class java.lang.Long] and content type [application/json];*/

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(update_title);




    }




}