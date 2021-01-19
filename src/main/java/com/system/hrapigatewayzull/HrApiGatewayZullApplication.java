package com.system.hrapigatewayzull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient //tambem é um client eureka
public class HrApiGatewayZullApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiGatewayZullApplication.class, args);
	}

}
