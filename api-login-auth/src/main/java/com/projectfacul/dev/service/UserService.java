package com.projectfacul.dev.service;

import com.projectfacul.dev.dto.UserEntityDTO;
import com.projectfacul.dev.mapper.MapperUserEntity;
import com.projectfacul.dev.model.UserEntity;
import com.projectfacul.dev.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntityDTO findByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsernameAndIsActive(username, true)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        return MapperUserEntity.UserEntityToUserEntityDTO(userEntity);
    }

    public UserEntity findByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmailAndIsActive(email, true)
                .orElseThrow(() -> new RuntimeException("Email not found!"));

        return userEntity;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try{
            System.out.println("Buscando email: "+ email);
            UserEntity user = findByEmail(email);

            return User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();
        } catch(UsernameNotFoundException e){
            throw new  UsernameNotFoundException("email not found : " + email);
        }

    }
}
