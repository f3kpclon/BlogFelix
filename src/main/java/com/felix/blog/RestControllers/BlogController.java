package com.felix.blog.RestControllers;

import com.felix.blog.Entities.Comentario;
import com.felix.blog.Entities.Post;
import com.felix.blog.Entities.Usuario;
import com.felix.blog.ErrorHandlers.EntityNotFoundException;
import com.felix.blog.Pojo.ComentarioPojo;
import com.felix.blog.Service.ComentarioService;
import com.felix.blog.Service.PostService;
import com.felix.blog.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

  @Autowired
  private PostService postService;
  @Autowired
  private UsuarioService usuarioService;
  @Autowired
  private ComentarioService comentarioService;


  @GetMapping(value = "/posts")
  public List<Post> allPosts(){
    return postService.getAllPost();
  }
  @PostMapping(value = "/post")
  public String publicarPost(@RequestBody @Valid Post post)throws EntityNotFoundException{

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String nombreUsuarioActual = authentication.getName();

    if(post.getDiaCreacion() == null){
      post.setDiaCreacion(new Date());
      post.setUsuario(usuarioService.getUsuario1(nombreUsuarioActual));
      postService.savePost(post);
      return "Post Logrado";
    }else {
      post.setUsuario(usuarioService.getUsuario1(nombreUsuarioActual));
      postService.savePost(post);
      return "Post Logrado";
    }


  }

  @GetMapping(value = "/posts/{nombreUsuario}")
  public List<Post> postsByNombreUsuario(@PathVariable String nombreUsuario) throws EntityNotFoundException {
    return postService.findByUsuario(usuarioService.getUsuario1(nombreUsuario));
  }
  @DeleteMapping(value = "/deletePost/{id}")
  public boolean deletePost (@PathVariable Long id) throws EntityNotFoundException{
    return postService.deletePost(id);
  }
  @GetMapping(value = "posts/getPost/{id}")
  public Post getPostById (@PathVariable Long id)throws EntityNotFoundException{
    return postService.getPost(id);
  }
  @DeleteMapping(value = "/comment/{id}")
  public boolean deleteComment(@PathVariable Long id)throws EntityNotFoundException{
    return comentarioService.deletePost(id);
  }


  @GetMapping(value = "/comments/{postId}")
  public List<Comentario> getComments(@PathVariable Long postId)throws EntityNotFoundException{
    return comentarioService.getComentarios(postId);
  }

  @PostMapping(value = "/post/postComment")
  public boolean postComment(@RequestBody @Valid ComentarioPojo comment) throws EntityNotFoundException{
    Post post = postService.getPost(comment.getPostId());
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String nombreUsuarioActual = authentication.getName();
    Usuario creator = usuarioService.getUsuario1(nombreUsuarioActual);
    if(post == null || creator == null){
      return false;
    }else {
      comentarioService.guardarComentario(new Comentario(comment.getText(),post,creator));
      return true;
    }



  }

}
