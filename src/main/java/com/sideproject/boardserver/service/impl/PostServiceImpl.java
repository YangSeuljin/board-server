package com.sideproject.boardserver.service.impl;

import com.sideproject.boardserver.dto.CommentDTO;
import com.sideproject.boardserver.dto.PostDTO;
import com.sideproject.boardserver.dto.TagDTO;
import com.sideproject.boardserver.dto.UserDTO;
import com.sideproject.boardserver.mapper.CommentMapper;
import com.sideproject.boardserver.mapper.PostMapper;
import com.sideproject.boardserver.mapper.TagMapper;
import com.sideproject.boardserver.mapper.UserProfileMapper;
import com.sideproject.boardserver.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostMapper postMapper;
    private final UserProfileMapper userProfileMapper;
    private final CommentMapper commentMapper;
    private final TagMapper tagMapper;

    @Override
    public void deletePosts(int userId, int postId) {
        if (userId != 0 && postId != 0) {
            postMapper.deletePosts(postId);
        } else {
            log.error("deletePosts ERROR! {}", postId);
            throw new RuntimeException("deletePosts ERROR! 게시글 삭제 메서드를 확인해주세요." + postId);
        }
    }

    @Override
    public void register(String id, PostDTO postDTO) {
        UserDTO memberInfo = userProfileMapper.getUserProfile(id);
        postDTO.setUserId(memberInfo.getId());
        postDTO.setCreateTime(new Date());

        if (memberInfo != null) {
            postMapper.register(postDTO);
            int postId = postDTO.getId();
            for (int i = 0; i < postDTO.getTagDTOList().size(); i++) {
                TagDTO tagDTO = postDTO.getTagDTOList().get(i);
                tagMapper.register(tagDTO);
                Integer tagId = tagDTO.getId();
                tagMapper.createPostTag(tagId, postId);
            }
        } else {
            log.error("register ERROR! {}", postDTO);
            throw new RuntimeException("register ERROR! 게시글 등록 메서드를 확인해주세요" + postDTO);
        }
    }

    @Override
    public List<PostDTO> getMyPosts(int accountId) {
        List<PostDTO> postDtoList = postMapper.selectMyPosts(accountId);
        return postDtoList;
    }

    @Override
    public void updatePosts(PostDTO postDTO) {
        if (postDTO != null && postDTO.getId() != 0) {
            postMapper.updatePosts(postDTO);
        } else {
            log.error("updatePosts ERROR! {}", postDTO);
            throw new RuntimeException("updatePosts ERROR! 게시글 수정 메서드를 확인해주세요. " + postDTO);
        }
    }

    @Override
    public void registerComment(CommentDTO commentDTO) {
        if (commentDTO.getPostId() != 0) {
            commentMapper.register(commentDTO);
        } else {
            log.error("registerComment {}", commentDTO);
            throw new RuntimeException("registerComment " + commentDTO);
        }
    }

    @Override
    public void updateComment(CommentDTO commentDTO) {
        if (commentDTO != null) {
            commentMapper.updateComments(commentDTO);
        } else {
            log.error("updateComment error!");
            throw new RuntimeException("updateComment");
        }
    }

    @Override
    public void deletePostComment(int userId, int commentId) {
        if (userId != 0 && commentId != 0) {
            commentMapper.deletePostComment(commentId);
        } else {
            log.error("deletePostComment error!{}", commentId);
            throw new RuntimeException("delePostComment" + commentId);
        }
    }

    @Override
    public void registerTag(TagDTO tagDTO) {
        if (tagDTO != null) {
            tagMapper.register(tagDTO);
        } else {
            log.error("registerTag");
            throw new RuntimeException("registerTag");
        }
    }

    @Override
    public void updateTag(TagDTO tagDTO) {
        if (tagDTO != null) {
            tagMapper.updateTags(tagDTO);
        } else {
            log.error("updateTag error!");
            throw new RuntimeException("updateTag");
        }
    }

    @Override
    public void deletePostTag(int userId, int tagId) {
        if (userId != 0 && tagId != 0) {
            tagMapper.deletePostTag(tagId);
        } else {
            log.error("deletePostTag error!");
            throw new RuntimeException("deletePostTag");
        }
    }
}
