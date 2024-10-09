package com.sideproject.boardserver.service;

import com.sideproject.boardserver.dto.PostDTO;

import java.util.List;

public interface PostService {
    void register(String id, PostDTO postDTO);

    List<PostDTO> getMyPosts(int accountId);
    void deletePosts(int userId, int postId);
    void updatePosts(PostDTO postDTO);
}
