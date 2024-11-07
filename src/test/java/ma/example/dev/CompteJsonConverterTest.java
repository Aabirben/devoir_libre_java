package ma.example.dev;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class CompteJsonConverterTest {

    @Test
    public void testToJson() throws JsonProcessingException {
        Client client = new Client(1, "Dupont", "Jean", "123 rue Exemple", "0123456789", "jean.dupont@example.com");
        Banque banque = new Banque(1, "Maroc");
        Compte compte = new Compte(1, LocalDateTime.now(), LocalDateTime.now(), "MAD", client, banque);

        String json = CompteJsonConverter.toJson(compte);

        assertNotNull(json);
        assertTrue(json.contains("MAD"));
        assertTrue(json.contains("numCompte"));
    }

    @Test
    public void testFromJson() throws JsonProcessingException {
        String json = "{\"numCompte\":1,\"devise\":\"MAD\",\"client\":{\"numClient\":1,\"nom\":\"Dupont\"},\"banque\":{\"idBanque\":1,\"pays\":\"Maroc\"}}";
        Compte compte = CompteJsonConverter.fromJson(json);

        assertNotNull(compte);
        assertEquals("MAD", compte.getDevise());
        assertEquals(1, compte.getNumCompte());
    }
}
