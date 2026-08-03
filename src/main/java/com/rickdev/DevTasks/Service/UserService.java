package com.rickdev.DevTasks.Service;

import com.rickdev.DevTasks.Dto.UserDto;
import com.rickdev.DevTasks.Model.UserModel;
import com.rickdev.DevTasks.Repository.UserRepository;
import com.rickdev.DevTasks.Security.SecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private SecurityConfig securityConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        return user;
    }

    public UserModel cadastrar(UserDto dto) {
        var user = new UserModel();
        user.setLogin(dto.login());
        String senhaCriptografada = securityConfig.passwordEncoder().encode(dto.senha());
        user.setSenha(senhaCriptografada);
        return userRepository.save(user);
    }

    public UserModel atualizarPorId(Long id, UserDto dto) {
        var user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Id nao encontrado"));
        user.setLogin(dto.login());
        String senhaCriptografada = securityConfig.passwordEncoder().encode(dto.senha());
        user.setLogin(senhaCriptografada);
        return userRepository.saveAndFlush(user);
    }

    public void deletarPorId(Long id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }else {
            throw new RuntimeException("Id Nao identificado");
        }
    }

}
