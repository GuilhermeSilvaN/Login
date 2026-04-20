package com.projectfacul.dev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="tb_product")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String username;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Product() {}

    public Product(String code, String username, String description) {
        this.code = code;
        this.username = username;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public UserEntity getUser() {
        return user;
    }
}
