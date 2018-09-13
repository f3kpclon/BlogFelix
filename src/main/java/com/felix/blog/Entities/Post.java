package com.felix.blog.Entities;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {
  @Id
  @GeneratedValue(strategy =GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String cuerpo;
  private Date diaCreacion;
  @ManyToOne
  private Usuario usuario;

  public Post() {
  }

  public Long getId() {
    return id;
  }

  public Usuario getUsuario() {
    return usuario;
  }


  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getCuerpo() {
    return cuerpo;
  }

  public void setCuerpo(String cuerpo) {
    this.cuerpo = cuerpo;
  }

  public Date getDiaCreacion() {
    return diaCreacion;
  }

  public void setDiaCreacion(Date diaCreacion) {
    this.diaCreacion = diaCreacion;
  }


  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
