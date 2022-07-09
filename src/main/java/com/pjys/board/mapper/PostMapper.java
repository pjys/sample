package com.pjys.board.mapper;

import com.pjys.board.dto.CreatePostRequest;
import com.pjys.board.dto.PostDTO;
import com.pjys.board.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface PostMapper {

    Post to(PostDTO postDTO);

    @Mapping(target = "postId", ignore = true)
    @Mapping(target = "board", ignore = true)
    @Mapping(target = "delete", ignore = true)
    @Mapping(target = "views", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Post to(CreatePostRequest createPostRequest);

    PostDTO to(Post post);

    List<PostDTO> to(List<Post> postList);
}
