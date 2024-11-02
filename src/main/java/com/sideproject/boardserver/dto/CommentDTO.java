package com.sideproject.boardserver.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class CommentDTO {
    private int id;
    private int postId;
    private String contents;
    private int subCommentId;

}
