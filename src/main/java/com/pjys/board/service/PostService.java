package com.pjys.board.service;

import com.pjys.board.dto.CreatePostRequest;
import com.pjys.board.dto.PostDTO;
import com.pjys.board.entity.Post;
import com.pjys.board.mapper.PostMapper;
import com.pjys.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    private final PostMapper mapper = Mappers.getMapper(PostMapper.class);

    public Long createPost(CreatePostRequest postRequest) {
        Post post = postRepository.save(mapper.to(postRequest));
        return post.getPostId();
    }

    public PostDTO getPost(Long posId) {
        Post postById = postRepository.getById(posId);
        return mapper.to(postById);
    }

    public List<PostDTO> postList() {
        List<Post> postList = postRepository.findAll();

        return mapper.to(postList);
    }
}
