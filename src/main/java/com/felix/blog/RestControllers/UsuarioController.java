package com.felix.blog.RestControllers;

import com.felix.blog.Entities.Role;
import com.felix.blog.Entities.Usuario;
import com.felix.blog.ErrorHandlers.EntityNotFoundException;
import com.felix.blog.Pojo.RegistroUsuario;
import com.felix.blog.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
public class UsuarioController {
  @Autowired
  private UsuarioService usuarioService;

  @Autowired
  private TokenStore tokenStore;

  /**
   *
   * @return
   */
  @GetMapping(value = "/usuarios")
  public List<Usuario> allUsuarios(){
    return usuarioService.getAllUsuarios();
  }

  @PostMapping(value = "/registro")
  public String registro (@RequestBody RegistroUsuario registroUsuario)  {

    if (!registroUsuario.getContraseña().equals(registroUsuario.getConfirmacionContraseña())){
      return "Contraseñas no coinciden";

    }else if (usuarioService.getUsuario1(registroUsuario.getNombreUsuario()) !=null){
      return "Usuario ya existe";

    }else {
      usuarioService.saveUsuario(new Usuario(registroUsuario.getNombreUsuario(), registroUsuario.getContraseña(),registroUsuario.isActivo(), Arrays.asList(new Role("USER"), new Role("ADMIN"))));
      return "Usuario creado";
    }

  }
  @GetMapping(value = "/logouts")
  public void logout (@RequestParam(value = "access_token") String accessToken){
    tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken));
  }
  @GetMapping(value = "/getUsername")
  public String getUserName(){
    return SecurityContextHolder.getContext().getAuthentication().getName();
  }
}
