package com.felix.blog.configAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


  @Autowired
  private AuthenticationManager autheticationManager;
  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   *
   * @param oauthServer
   * @throws Exception
   */
  @Override
  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    oauthServer.checkTokenAccess("isAuthenticated()");
  }

  /**
   *
   * @param clients
   * @throws Exception
   */
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory().withClient("Client_Felix")
                      .authorizedGrantTypes("client_credentials","password")
                      .authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
                      .scopes("read","write","trust")
                      .resourceIds("oauth2-resource")
                      .accessTokenValiditySeconds(5000)
                      .secret(passwordEncoder.encode("secret"));
  }

  /**
   *
   * @param endpoints
   * @throws Exception
   */
  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.authenticationManager(autheticationManager);
    endpoints.tokenStore(getTokenStore());
  }
  @Bean
  public TokenStore getTokenStore (){
    return new InMemoryTokenStore();
  }

}
