package com.sideproject.boardserver.mapper;

import com.sideproject.boardserver.dto.TagDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    int register(TagDTO tagDTO);

    void updateTags(TagDTO tagDTO);

    void deletePostTag(int tagId);

    void createPostTag(Integer tagId, Integer postId);
}
