package com.system.hrapigatewayzull.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@RefreshScope //atualizar os valores da variaveis em tempo de execução com o actuator
public class AppConfig {

    // PEGANDO AS INFORMAÇÕES DO CONFIG-SERVER

    @Value("${jwt.secret}") //buscando do config server o valor desta propriedade
    private String jwtSecret;


    @Bean //componets utilizados para usar o jwt
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        //chave secreta que sera assinada seu tokens
        tokenConverter.setSigningKey(jwtSecret); //passar para o configserver, segredo provisorio....ajustado
        return tokenConverter;
    }

    //responsavel por ler as informações do token
    @Bean
    public JwtTokenStore tokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }

}
