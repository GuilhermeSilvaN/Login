package com.projectfacul.dev.controller;

import com.projectfacul.dev.dto.LoginDTO;
import com.projectfacul.dev.dto.LoginResponseDTO;
import com.projectfacul.dev.dto.UserEntityDTO;
import com.projectfacul.dev.dto.UserEntityDTOCreate;
import com.projectfacul.dev.mapper.MapperUserEntity;
import com.projectfacul.dev.model.UserEntity;
import com.projectfacul.dev.repository.UserRepository;
import com.projectfacul.dev.service.JwtService;
import com.projectfacul.dev.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/login")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public  AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO data){
        try{
            //1. cria otken de autenticacao (email + senha)
            var authToken = new UsernamePasswordAuthenticationToken(
                    data.email(),
                    data.password()
            );

            // 2. Autentica (Spring valida automaticamente)
            Authentication auth = authenticationManager.authenticate(authToken);

            // 3. pega o usuario autenticado (mais seguro que usar data.email())
            String email = auth.getName();

            UserEntity user = userRepository.findByEmailAndIsActive(email, true)
                    .orElseThrow(() -> new RuntimeException("Email not found!"));

            // 4. gera o JWT
            String token = jwtService.generateToken(email);

            LoginResponseDTO response = new LoginResponseDTO(
                    token,
                    user.getId(),
                    user.getUsername()
            );

            // 5. retorna resposta
            return ResponseEntity.ok().body(response);

        } catch(Exception ex){
            ex.printStackTrace(); //mostra o erro;
            return ResponseEntity.status(401).body("Erro no login, que mierda");
        }

    }



    @PostMapping("/register")
    public ResponseEntity<UserEntityDTO> registerUser(@RequestBody UserEntityDTOCreate  userEntityDTOCreate) {
        UserEntity userEntity = MapperUserEntity.UserEntityDTOCreateToUserEntity(userEntityDTOCreate);
        userEntity.setPassword(passwordEncoder.encode(userEntityDTOCreate.password()));

        userRepository.save(userEntity);

        return ResponseEntity.ok().body(MapperUserEntity.UserEntityToUserEntityDTO(userEntity));
    }

    @GetMapping
    public ResponseEntity<String> hello () {
        return ResponseEntity.ok().body("Hello World mesmo");
    }
}
