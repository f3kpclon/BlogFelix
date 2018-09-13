package com.felix.blog.Pojo;

/**
 * Pojo registro
 */
public class RegistroUsuario {
  private String nombreUsuario;
  private String contraseña;
  private String confirmacionContraseña;
  private boolean activo;

  public RegistroUsuario() {
  }

  public RegistroUsuario(String nombreUsuario, String contraseña, String confirmacionContraseña, boolean activo) {
    this.nombreUsuario = nombreUsuario;
    this.contraseña = contraseña;
    this.confirmacionContraseña = confirmacionContraseña;
    this.activo = activo;
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }

  public boolean isActivo() {
    return activo;
  }

  public void setActivo(boolean activo) {
    this.activo = activo;
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

  public String getConfirmacionContraseña() {
    return confirmacionContraseña;
  }

  public void setConfirmacionContraseña(String confirmaciónContraseña) {
    this.confirmacionContraseña = confirmaciónContraseña;
  }
}
