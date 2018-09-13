package com.felix.blog.Repositories;

import com.felix.blog.Entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
  /**
   *
   * @param postId
   * @return
   */
  List <Comentario> findByPostId(Long postId);
}
