package com.aa.algoritmo.infrastructure.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local","dev","test"})
public class CorsLocalConfig {
}
