package com.sideproject.boardserver.service;

import com.sideproject.boardserver.dto.CommentDTO;
import com.sideproject.boardserver.dto.PostDTO;
import com.sideproject.boardserver.dto.TagDTO;

import java.util.List;

public interface PostService {
    void register(String id, PostDTO postDTO);

    List<PostDTO> getMyPosts(int accountId);

    void deletePosts(int userId, int postId);

    void updatePosts(PostDTO postDTO);

    void registerComment(CommentDTO commentDTO);

    void updateComment(CommentDTO commentDTO);

    void deletePostComment(int userId, int commentId);

    void registerTag(TagDTO tagDTO);

    void updateTag(TagDTO tagDTO);

    void deletePostTag(int userId, int tagId);
}
