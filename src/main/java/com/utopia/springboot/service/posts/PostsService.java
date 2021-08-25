package com.utopia.springboot.service.posts;

import com.utopia.springboot.controller.dto.PostsSaveRequestDto;
import com.utopia.springboot.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Service Layer: 도메인 간의 순서, 트랜잭션 등을 처리함.

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
