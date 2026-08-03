package com.rickdev.DevTasks.Controller;

import com.rickdev.DevTasks.Dto.TokenJwtDto;
import com.rickdev.DevTasks.Dto.UserDto;
import com.rickdev.DevTasks.Model.UserModel;
import com.rickdev.DevTasks.Service.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationManager manager;

    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity efetuarLogin (@RequestBody @Valid UserDto dto) {
        var authToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
        var authentication = manager.authenticate(authToken);
        var JWTtoken = tokenService.gerarToken((UserModel) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDto (JWTtoken));
    }

}
