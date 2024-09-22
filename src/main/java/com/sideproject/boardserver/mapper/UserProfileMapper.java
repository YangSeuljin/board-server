package com.sideproject.boardserver.mapper;

import com.sideproject.boardserver.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserProfileMapper {
    UserDTO getUserProfile(@Param("id") String id);

    int insertUserProfile(
            @Param("id") String id, @Param("password") String password,
            @Param("name") String name, @Param("phone") String phone,
            @Param("address") String address, @Param("createTime") String createTime,
            @Param("updateTime") String updateTime
    );

    int deleteUserProfile(@Param("id") String id);

    UserDTO indByIdAndPassword(@Param("id") String id, @Param("password") String password);

    int idCheck(@Param("id") String id);

    int updatePassword(UserDTO user);

    int updateAddress(UserDTO user);

    int register(UserDTO userProfile);

    UserDTO findByIdAndPassword(String id, String cryptoPassword);
}
