package com.sideproject.boardserver.service.impl;

import com.sideproject.boardserver.dto.PostDTO;
import com.sideproject.boardserver.dto.request.PostSearchRequest;
import com.sideproject.boardserver.mapper.PostSearchMapper;
import com.sideproject.boardserver.service.PostSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PostSearchServiceImpl implements PostSearchService {
    private final PostSearchMapper postSearchMapper;
    private final RedisTemplate redisTemplate;

    @Cacheable(value = "getPosts", key = "'getPosts' + #postSearchRequest.getName() + #postSearchRequest.getCategoryId()")
    @Override
    public List<PostDTO> getPosts(PostSearchRequest postSearchRequest) {
        List<PostDTO> postDTOList = null;
        try {
            postDTOList = postSearchMapper.selectPosts(postSearchRequest);
        } catch (RuntimeException e) {
            log.error("selectPosts 실패", e.getMessage());
        }
        return postDTOList;
    }

    @Override
    public List<PostDTO> getPostByTag(String tagName) {
        List<PostDTO> postDTOList = null;
        try {
            postDTOList = postSearchMapper.getPostByTag(tagName);
        } catch (RuntimeException e) {
            log.error("selectPosts 실패");
        }
        return postDTOList;
    }
}
