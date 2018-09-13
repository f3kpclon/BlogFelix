package com.felix.blog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.felix.blog.Entities.Post;
import com.felix.blog.Entities.Usuario;
import com.felix.blog.Entities.Role;
import com.felix.blog.Service.PostService;
import com.felix.blog.Service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


import java.util.Arrays;


@SpringBootApplication
public class BlogFelixApplication {

  public static void main(String[] args) {
    SpringApplication.run(BlogFelixApplication.class, args);
  }
  @Bean
  public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    MappingJackson2HttpMessageConverter converter =
        new MappingJackson2HttpMessageConverter(mapper);
    return converter;
  }

  @Bean
  public CommandLineRunner setupDefaultUser(UsuarioService service) {
    return args -> {
      service.saveUsuario(new Usuario(
          "felix",
          "admin",
          true,
          Arrays.asList(new Role("USUARIO"), new Role("ADMIN"))//roles

      ));
      service.saveUsuario(new Usuario(
          "kata",
          "admin",
          true,
          Arrays.asList(new Role("USUARIO"), new Role("ADMIN"))//roles

      ));
      service.saveUsuario(new Usuario(
          "nancy",
          "admin",
          true,
          Arrays.asList(new Role("USUARIO"), new Role("ADMIN"))//roles

      ));
      service.saveUsuario(new Usuario(
          "pepe",
          "admin",
          true,
          Arrays.asList(new Role("USUARIO"), new Role("ADMIN"))//roles

      ));
      service.saveUsuario(new Usuario(
          "Mayo",
          "admin",
          true,
          Arrays.asList(new Role("USUARIO"), new Role("ADMIN"))//roles

      ));
    };
  }

  }
