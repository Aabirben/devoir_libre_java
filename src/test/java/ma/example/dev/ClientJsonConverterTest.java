package ma.example.dev;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientJsonConverterTest {

    @Test
    public void testToJson() throws JsonProcessingException {
        Client client = new Client(1, "Dupont", "Jean", "123 rue Exemple", "0123456789", "jean.dupont@example.com");
        String json = ClientJsonConverter.toJson(client);

        assertNotNull(json);
        assertTrue(json.contains("Dupont"));
        assertTrue(json.contains("Jean"));
    }

    @Test
    public void testFromJson() throws JsonProcessingException {
        String json = "{\"numClient\":1,\"nom\":\"Dupont\",\"prenom\":\"Jean\",\"adresse\":\"123 rue Exemple\",\"phone\":\"0123456789\",\"email\":\"jean.dupont@example.com\"}";
        Client client = ClientJsonConverter.fromJson(json);

        assertNotNull(client);
        assertEquals("Dupont", client.getNom());
        assertEquals("Jean", client.getPrenom());
    }
}
