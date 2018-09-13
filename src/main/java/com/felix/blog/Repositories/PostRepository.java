package com.felix.blog.Repositories;

import com.felix.blog.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

  List<Post> findByUsuario_Id(Long id);

}
