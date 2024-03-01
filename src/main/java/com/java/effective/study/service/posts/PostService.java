package com.java.effective.study.service.posts;


import com.java.effective.study.domain.posts.Posts;
import com.java.effective.study.domain.posts.PostsRepository;
import com.java.effective.study.web.dto.PostSaveRequestDto;
import com.java.effective.study.web.dto.PostsResponseDto;
import com.java.effective.study.web.dto.PostsUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private  final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId(); // JpaRepository를 상속받고 있어서 save 함수 사용 가능.

    }

    @Transactional
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id = "+id));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public Long update(Long id, PostsUpdateResponseDto requestDto)
    {
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id = "+id));
        entity.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }




}
