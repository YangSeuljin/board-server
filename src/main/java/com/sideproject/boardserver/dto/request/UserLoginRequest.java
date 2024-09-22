package com.sideproject.boardserver.dto.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class UserLoginRequest {
    @NonNull
    private String userID;
    @NonNull
    private String password;
}