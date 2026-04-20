package com.projectfacul.dev.controller;

import com.projectfacul.dev.dto.UserEntityDTO;
import com.projectfacul.dev.model.Product;
import com.projectfacul.dev.model.UserEntity;
import com.projectfacul.dev.repository.UserRepository;
import com.projectfacul.dev.service.ProductService;
import com.projectfacul.dev.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    private UserRepository userRepository;

    public ProductController(ProductService productService,  UserRepository userRepository) {
        this.productService = productService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String test(){
        return "test";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getAllProducts(Authentication authentication){

        System.out.println(authentication);

        String email = authentication.getName(); //vem do token;

        UserEntity user = userRepository.findByEmailAndIsActive(email, true)
                .orElseThrow(() -> new RuntimeException("Email not found!"));

        List<Product> products = productService.findByUser(user);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.findById(id));
    }

}
