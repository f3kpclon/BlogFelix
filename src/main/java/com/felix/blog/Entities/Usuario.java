package com.felix.blog.Entities;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombreUsuario;
  @JsonIgnore
  private String contraseña;
  private boolean active;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Role> roles;


  public Usuario() {
  }

  public Usuario(String nombreUsuario, String contraseña, boolean active, List<Role> roles) {
    this.nombreUsuario = nombreUsuario;
    this.contraseña = contraseña;
    this.active = active;
    this.roles = roles;

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }


  public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
  }

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}
