package com.utopia.springboot.service.posts;

import com.utopia.springboot.controller.dto.PostsResponseDto;
import com.utopia.springboot.controller.dto.PostsSaveRequestDto;
import com.utopia.springboot.controller.dto.PostsUpdateRequestDto;
import com.utopia.springboot.domain.posts.Posts;
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

    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
