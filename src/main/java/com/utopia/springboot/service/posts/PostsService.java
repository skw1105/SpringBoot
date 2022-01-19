package com.utopia.springboot.service.posts;

import com.utopia.springboot.controller.dto.PostsListResponseDto;
import com.utopia.springboot.controller.dto.PostsResponseDto;
import com.utopia.springboot.controller.dto.PostsSaveRequestDto;
import com.utopia.springboot.controller.dto.PostsUpdateRequestDto;
import com.utopia.springboot.domain.posts.Posts;
import com.utopia.springboot.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// Service Layer: 도메인 간의 순서, 트랜잭션 등을 처리함.

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        // PostsListResponseDto::new
        // posts -> new PostsListResponseDto(posts)
        // findAllDesc로 가져온 데이터를 List<PostsListResponseDto>로 만들어주는거임.
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);
    }
}
