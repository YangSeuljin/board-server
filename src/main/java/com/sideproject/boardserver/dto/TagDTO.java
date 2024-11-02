package com.sideproject.boardserver.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class TagDTO {
    private int id;
    private String name;
    private String url;
    private int postId;
}
