package com.projectfacul.dev.dto;

import com.projectfacul.dev.model.Product;

public record ProductDTO(
        Long id,
        String code,
        String username,
        String description
) {
    public ProductDTO(Long id, String code, String username, String description) {
        this.id = id;
        this.code = code;
        this.username = username;
        this.description = description;
    }

    public ProductDTO(Product product){
        this(
                product.getId(),
                product.getCode(),
                product.getUsername(),
                product.getDescription()
        );
    }
}
