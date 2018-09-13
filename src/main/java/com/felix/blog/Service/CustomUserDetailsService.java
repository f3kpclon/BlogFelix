package com.felix.blog.Service;


import com.felix.blog.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {


  @Autowired
  private UsuarioRepository usuarioRepository;



  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    return usuarioRepository.findByNombreUsuario(username)
        .map(usuario -> new org.springframework.security.core.userdetails.User(
            usuario.getNombreUsuario(),
            usuario.getContraseña(),
            usuario.isActive(),
            usuario.isActive(),
            usuario.isActive(),
            usuario.isActive(),
            AuthorityUtils.createAuthorityList(
                usuario.getRoles()
                .stream()
                .map(role -> "ROLE_" + role.getName().toUpperCase())
                .collect(Collectors.toList())
                .toArray(new String[]{}))))
        .orElseThrow(()-> new UsernameNotFoundException("Ningún usuario con" +
            "el nombre " + username + "se encuentra registrado"));



  }

}
