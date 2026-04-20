package com.projectfacul.dev.service;

import com.projectfacul.dev.dto.ProductDTOCreate;
import com.projectfacul.dev.model.Product;
import com.projectfacul.dev.model.UserEntity;
import com.projectfacul.dev.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByUser(UserEntity user) {
        return productRepository.findByUser(user);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public Product save(ProductDTOCreate productDTOCreate) {
        Product product = new Product(
                productDTOCreate.code(),
                productDTOCreate.username(),
                productDTOCreate.description()
        );

        return productRepository.save(product);
    }

}
