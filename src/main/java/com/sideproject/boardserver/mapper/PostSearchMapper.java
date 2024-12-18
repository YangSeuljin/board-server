package com.sideproject.boardserver.mapper;

import com.sideproject.boardserver.dto.PostDTO;
import com.sideproject.boardserver.dto.request.PostSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostSearchMapper {
    List<PostDTO> selectPosts(PostSearchRequest postSearchRequest);

    List<PostDTO> getPostByTag(String tagName);
}
