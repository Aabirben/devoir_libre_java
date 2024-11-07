package ma.example.dev;

import com.fasterxml.jackson.core.JsonProcessingException;

public class BanqueJsonConverter {

    public static String toJson(Banque banque) throws JsonProcessingException {
        return JsonConverter.getMapper().writeValueAsString(banque);
    }

    public static Banque fromJson(String json) throws JsonProcessingException {
        return JsonConverter.getMapper().readValue(json, Banque.class);
    }
}
