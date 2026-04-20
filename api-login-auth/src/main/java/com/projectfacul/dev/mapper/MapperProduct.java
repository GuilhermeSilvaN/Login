package com.projectfacul.dev.mapper;

import com.projectfacul.dev.dto.ProductDTO;
import com.projectfacul.dev.dto.ProductDTOCreate;
import com.projectfacul.dev.model.Product;

public class MapperProduct {
    //cria instancia de product quando for salvar;
    public static Product productDTOCreateToProductEntity(ProductDTOCreate productDTOCreate){
        return new Product(
                productDTOCreate.code(),
                productDTOCreate.username(),
                productDTOCreate.description()
        );
    }

    //cria instancia de product quando for retornar;
    public static ProductDTO productEntityToProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getCode(),
                product.getUsername(),
                product.getDescription()
        );
    }

    //utilizar quando for atualizar e não deixar vazer criação de instancias;
    public static void productUpdate(Product product, ProductDTOCreate productDTOCreate){
        product.setCode(productDTOCreate.code());
        product.setUsername(productDTOCreate.username());
        product.setDescription(productDTOCreate.description());
    }

}
