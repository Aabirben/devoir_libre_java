package ma.example.dev;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class TransactionJsonConverterTest {

    @Test
    public void testToJson() throws JsonProcessingException {
        Client client = new Client(1, "Dupont", "Jean", "123 rue Exemple", "0123456789", "jean.dupont@example.com");
        Banque banque = new Banque(1, "Maroc");
        Compte compte1 = new Compte(1, LocalDateTime.now(), LocalDateTime.now(), "MAD", client, banque);
        Compte compte2 = new Compte(2, LocalDateTime.now(), LocalDateTime.now(), "MAD", client, banque);

        Set<Compte> comptesAssocies = new HashSet<>();
        comptesAssocies.add(compte1);
        comptesAssocies.add(compte2);

        Transaction transaction = new Transaction(LocalDateTime.now(), "REF123", comptesAssocies);
        String json = TransactionJsonConverter.toJson(transaction);

        assertNotNull(json);
        assertTrue(json.contains("REF123"));
    }

    @Test
    public void testFromJson() throws JsonProcessingException {
        String json = "{\"reference\":\"REF123\",\"timestamp\":\"2024-11-07 12:00:00\",\"comptesAssocies\":[{\"numCompte\":1,\"devise\":\"MAD\"}]}";
        Transaction transaction = TransactionJsonConverter.fromJson(json);

        assertNotNull(transaction);
        assertEquals("REF123", transaction.getReference());
        assertNotNull(transaction.getTimestamp());
    }
}
