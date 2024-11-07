package ma.example.dev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class BanqueJsonConverter {

    public static String toJson(Banque banque) throws JsonProcessingException {
        ObjectMapper mapper = JsonConverter.getMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return mapper.writeValueAsString(banque);
    }

    public static Banque fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = JsonConverter.getMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return mapper.readValue(json, Banque.class);
    }
}