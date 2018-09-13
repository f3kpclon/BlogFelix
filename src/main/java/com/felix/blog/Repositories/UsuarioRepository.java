package com.felix.blog.Repositories;

import com.felix.blog.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author
 * @since
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

  Optional<Usuario> findByNombreUsuario(String nombreUsuario);
  Usuario findUsuarioByNombreUsuario(String nombreUsuario);


}
