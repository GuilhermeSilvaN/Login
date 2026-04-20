package com.projectfacul.dev.dto;

import com.projectfacul.dev.model.UserEntity;

public record LoginDTO(
        String email,
        String password
) {

    public LoginDTO(UserEntity userEntity) {
        this(
                userEntity.getEmail(),
                userEntity.getPassword()
        );
    }

}
