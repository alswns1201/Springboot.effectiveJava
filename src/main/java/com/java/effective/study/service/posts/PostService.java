package com.java.effective.study.service.posts;


import com.java.effective.study.domain.posts.PostsRepository;
import com.java.effective.study.web.dto.PostSaveRequestDto;
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
}
