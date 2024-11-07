package ma.example.dev;

import com.fasterxml.jackson.core.JsonProcessingException;

public class TransactionJsonConverter {

    public static String toJson(Transaction transaction) throws JsonProcessingException {
        return JsonConverter.getMapper().writeValueAsString(transaction);
    }

    public static Transaction fromJson(String json) throws JsonProcessingException {
        return JsonConverter.getMapper().readValue(json, Transaction.class);
    }
}
