package ma.example.dev;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BanqueJsonConverterTest {

    @Test
    public void testToJson() throws JsonProcessingException {
        Banque banque = new Banque(1, "Maroc");
        String json = BanqueJsonConverter.toJson(banque);

        assertNotNull(json);
        assertTrue(json.contains("Maroc"));
    }

    @Test
    public void testFromJson() throws JsonProcessingException {
        String json = "{\"idBanque\":1,\"pays\":\"Maroc\"}";
        Banque banque = BanqueJsonConverter.fromJson(json);

        assertNotNull(banque);
        assertEquals(1, banque.getIdBanque());
        assertEquals("Maroc", banque.getPays());
    }
}