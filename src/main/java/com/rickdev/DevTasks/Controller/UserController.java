package com.rickdev.DevTasks.Controller;

import com.rickdev.DevTasks.Dto.TokenJwtDto;
import com.rickdev.DevTasks.Dto.UserDto;
import com.rickdev.DevTasks.Model.UserModel;
import com.rickdev.DevTasks.Service.TokenService;
import com.rickdev.DevTasks.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AuthenticationManager manager;

    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity efetuarLogin (@RequestBody @Valid UserDto dto) {
        var authToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
        var authentication = manager.authenticate(authToken);
        var JWTtoken = tokenService.gerarToken((UserModel) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDto (JWTtoken));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UserModel> cadastro(@RequestBody @Valid UserDto dto, UriComponentsBuilder uriBuilder) {
        var user = userService.cadastrar(dto);
        var uri = uriBuilder.path("/auth/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> atualizarPorId(@PathVariable Long id, @RequestBody @Valid UserDto dto){
        var atualizar = userService.atualizarPorId(id, dto);
        return ResponseEntity.status(200).body(atualizar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        userService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
