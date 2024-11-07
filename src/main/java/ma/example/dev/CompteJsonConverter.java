package ma.example.dev;

import com.fasterxml.jackson.core.JsonProcessingException;

public class CompteJsonConverter {

    public static String toJson(Compte compte) throws JsonProcessingException {
        return JsonConverter.getMapper().writeValueAsString(compte);
    }

    public static Compte fromJson(String json) throws JsonProcessingException {
        return JsonConverter.getMapper().readValue(json, Compte.class);
    }
}