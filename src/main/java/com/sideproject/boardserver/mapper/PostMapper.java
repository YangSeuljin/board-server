package com.sideproject.boardserver.mapper;

import com.sideproject.boardserver.dto.PostDTO;

import java.util.List;

public interface PostMapper {
    int register(PostDTO postDTO);

    List<PostDTO> selectMyPosts(int accountId);

    void updatePosts(PostDTO postDTO);

    void deletePosts(int postId);
}
