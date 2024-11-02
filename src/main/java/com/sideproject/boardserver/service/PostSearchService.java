package com.sideproject.boardserver.service;

import com.sideproject.boardserver.dto.PostDTO;
import com.sideproject.boardserver.dto.request.PostSearchRequest;

import java.util.List;

public interface PostSearchService {
    List<PostDTO> getPosts(PostSearchRequest postSearchRequest);

    List<PostDTO> getPostByTag(String tagName);
}
