package com.felix.blog.Service;

import com.felix.blog.Entities.Post;
import com.felix.blog.Entities.Usuario;
import com.felix.blog.ErrorHandlers.EntityNotFoundException;
import com.felix.blog.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * PostService
 */
@Service
public class PostService {
  @Autowired
  private PostRepository postRepository;

  /**
   *
   * @param idPost
   * @return
   * @throws EntityNotFoundException
   */
  public boolean deletePost(Long idPost) throws EntityNotFoundException {
    Post thePost = postRepository.getOne(idPost);
    if(thePost == null){
      throw  new EntityNotFoundException(Post.class,"id",idPost.toString());

    }else {
      postRepository.deleteById(idPost);
      return true;
    }

  }

  /**
   *
   * @param usuario
   * @return
   * @throws EntityNotFoundException
   */
  public List<Post> findByUsuario(Usuario usuario) throws EntityNotFoundException {
    List<Post>posts = new ArrayList<>();
    for (Post post:postRepository.findByUsuario_Id(usuario.getId())) {
      if(post == null){
        throw new EntityNotFoundException(Post.class,"id",usuario.getId().toString());
      }
      posts.add(post);
    }
    return posts;
  }

  /**
   *
   * @return array[]
   */
  public List<Post> getAllPost(){
    return postRepository.findAll();
  }

  /**
   *
   * @param id
   * @return
   * @throws EntityNotFoundException
   */
  public Post getPost(Long id) throws EntityNotFoundException {
    Post post = postRepository.getOne(id);
    if (post == null) {
      throw  new EntityNotFoundException(Post.class,"id",id.toString());
    }
    return post;
  }

  /**
   *
   * @param post
   */
  public void savePost(Post post){
    postRepository.save(post);
  }
}
