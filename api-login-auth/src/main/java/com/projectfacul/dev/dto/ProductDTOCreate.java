package com.projectfacul.dev.dto;

import com.projectfacul.dev.model.Product;

public record ProductDTOCreate(
        String code,
        String username,
        String description
) {
    public ProductDTOCreate(String code, String username, String description) {
        this.code = code;
        this.username = username;
        this.description = description;
    }

    public ProductDTOCreate(Product product){
        this(
                product.getCode(),
                product.getUsername(),
                product.getDescription()
        );
    }
}
