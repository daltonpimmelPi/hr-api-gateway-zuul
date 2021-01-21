package com.system.hrapigatewayzull.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

    @Bean //componets utilizados para usar o jwt
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        //chave secreta que sera assinada seu tokens
        tokenConverter.setSigningKey("MY-SECRET-KEY"); //passar para o configserver, segredo provisorio
        return tokenConverter;
    }

    //responsavel por ler as informações do token
    @Bean
    public JwtTokenStore tokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }

}
