package ma.example.dev;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try {
            // Création d'une banque
            Banque banque = new Banque(1, "Maroc");

            // Création d'un client
            Client client = new Client(1, "Dupont", "Jean", "123 rue Exemple", "0123456789", "jean.dupont@example.com");

            // Création de comptes associés au client et à la banque
            Compte compte1 = new Compte(1, LocalDateTime.now(), LocalDateTime.now(), "MAD", client, banque);
            Compte compte2 = new Compte(2, LocalDateTime.now(), LocalDateTime.now(), "USD", client, banque);

            // Ajout des comptes au client et à la banque
            client.getComptes().add(compte1);
            client.getComptes().add(compte2);
            banque.getComptes().add(compte1);
            banque.getComptes().add(compte2);

            // Création d'une transaction impliquant les deux comptes
            Set<Compte> comptesAssocies = new HashSet<>();
            comptesAssocies.add(compte1);
            comptesAssocies.add(compte2);
            Transaction transaction = new Transaction(LocalDateTime.now(), "REF123", comptesAssocies);

            // Conversion en JSON
            String clientJson = ClientJsonConverter.toJson(client);
            String banqueJson = BanqueJsonConverter.toJson(banque);
            String compteJson = CompteJsonConverter.toJson(compte1);
            String transactionJson = TransactionJsonConverter.toJson(transaction);

            // Affichage des JSON
            System.out.println("Client JSON: " + clientJson);
            System.out.println("Banque JSON: " + banqueJson);
            System.out.println("Compte JSON: " + compteJson);
            System.out.println("Transaction JSON: " + transactionJson);

            // Désérialisation à partir de JSON
            Client clientFromJson = ClientJsonConverter.fromJson(clientJson);
            Banque banqueFromJson = BanqueJsonConverter.fromJson(banqueJson);
            Compte compteFromJson = CompteJsonConverter.fromJson(compteJson);
            Transaction transactionFromJson = TransactionJsonConverter.fromJson(transactionJson);

            // Vérification de la désérialisation
            System.out.println("\nClient désérialisé: " + clientFromJson.getNom() + " " + clientFromJson.getPrenom());
            System.out.println("Banque désérialisée: " + banqueFromJson.getPays());
            System.out.println("Compte désérialisé: " + compteFromJson.getDevise());
            System.out.println("Transaction désérialisée, Référence: " + transactionFromJson.getReference());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
