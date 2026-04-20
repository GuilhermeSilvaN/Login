package com.projectfacul.dev.repository;

import com.projectfacul.dev.model.Product;
import com.projectfacul.dev.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByUser(UserEntity user);
}
