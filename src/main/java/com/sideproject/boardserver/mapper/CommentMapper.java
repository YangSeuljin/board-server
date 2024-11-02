package com.sideproject.boardserver.mapper;

import com.sideproject.boardserver.dto.CommentDTO;

public interface CommentMapper {
    int register(CommentDTO commentDTO);

    void updateComments(CommentDTO commentDTO);

    void deletePostComment(int commentId);
}
