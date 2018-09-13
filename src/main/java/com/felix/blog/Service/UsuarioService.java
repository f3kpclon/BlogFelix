package com.felix.blog.Service;

import com.felix.blog.Entities.Usuario;
import com.felix.blog.ErrorHandlers.EntityNotFoundException;
import com.felix.blog.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;


  /**
   *
   * @param usuario
   */
  public void saveUsuario(Usuario usuario){
    usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
    usuarioRepository.save(usuario);
  }

  /**
   *
   * @return array[]
   */
  public List<Usuario>getAllUsuarios(){
    return usuarioRepository.findAll();
  }

  /**
   *
   * @param nombreUsuario
   * @return
   */
  public Usuario getUsuario1(String nombreUsuario) {
   return usuarioRepository.findUsuarioByNombreUsuario(nombreUsuario);
  }


}
