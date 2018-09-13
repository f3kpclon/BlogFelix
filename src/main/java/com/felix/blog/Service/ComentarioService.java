package com.felix.blog.Service;

import com.felix.blog.Entities.Comentario;
import com.felix.blog.ErrorHandlers.EntityNotFoundException;
import com.felix.blog.Repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ComentarioService {

  @Autowired
  private ComentarioRepository comentarioRepository;

  public List<Comentario> getComentarios(Long postId) throws EntityNotFoundException {
    List<Comentario>comentarios= new ArrayList<>();
    for (Comentario comentario:comentarioRepository.findByPostId(postId)) {
      if(comentario== null){
        throw new EntityNotFoundException(Comentario.class,"id",postId.toString());
      }
      comentarios.add(comentario);
    }
    return comentarios;


  }
  public void guardarComentario(Comentario comentario){
    comentarioRepository.save(comentario);
  }
  public boolean deletePost(Long id) {
    comentarioRepository.deleteById(id);
    return true;
  }
}
