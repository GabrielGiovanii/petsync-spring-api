package com.petsync_spring_api.petsync_spring_api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;
import com.petsync_spring_api.petsync_spring_api.serializers.UserPhoneSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();

        module.addSerializer(UserPhone.class, new UserPhoneSerializer());
        mapper.registerModule(module);

        return mapper;
    }
}
