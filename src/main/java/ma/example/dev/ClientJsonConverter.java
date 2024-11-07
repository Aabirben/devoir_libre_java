package ma.example.dev;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ClientJsonConverter {

    public static String toJson(Client client) throws JsonProcessingException {
        return JsonConverter.getMapper().writeValueAsString(client);
    }

    public static Client fromJson(String json) throws JsonProcessingException {
        return JsonConverter.getMapper().readValue(json, Client.class);
    }
}