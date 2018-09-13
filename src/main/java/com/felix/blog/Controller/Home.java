package com.felix.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
  @GetMapping(value = "/")
  public String Index(){
    return "index";
  }


  @GetMapping(value="/registration")
  public String register(){
    return "register";
  }

  @GetMapping(value="/login")
  public String login(){
    return "login";
  }

  @GetMapping(value="post/{id}")
  public String singlePost(){
    return "post";
  }
}
