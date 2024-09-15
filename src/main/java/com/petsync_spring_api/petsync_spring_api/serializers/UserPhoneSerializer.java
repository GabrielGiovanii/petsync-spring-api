package com.petsync_spring_api.petsync_spring_api.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;

import java.io.IOException;

public class UserPhoneSerializer extends JsonSerializer<UserPhone> {

    @Override
    public void serialize(UserPhone userPhone, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("code", userPhone.getCode());
        jsonGenerator.writeStringField("number", userPhone.getNumber());

        if (shouldIncludeUser(userPhone)) {
            jsonGenerator.writeObjectField("user", userPhone.getUser());
        }

        jsonGenerator.writeEndObject();
    }

    private boolean shouldIncludeUser(UserPhone userPhone) {
        User user = userPhone.getUser();

        return user != null && user.getCpf() != null && user.getName() == null;
    }
}
