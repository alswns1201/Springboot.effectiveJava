package com.java.effective.study.web;

import com.java.effective.study.service.posts.PostService;
import com.java.effective.study.web.dto.PostSaveRequestDto;
import com.java.effective.study.web.dto.PostsResponseDto;
import com.java.effective.study.web.dto.PostsUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto)
    {
        return postService.save(requestDto);
    }


    //조회
    @GetMapping("/api/vi/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {return postService.findById(id);}

    //수정
    @PutMapping("/api/vi/posts/{id}")
    public Long update(@PathVariable Long id , @RequestBody PostsUpdateResponseDto dto){return postService.update(id,dto);}




}
