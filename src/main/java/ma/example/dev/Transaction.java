package ma.example.dev;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Transaction {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("timestamp")  // Ajout de l'annotation pour la sérialisation
    private final LocalDateTime timestamp;

    @JsonProperty("reference")
    private final String reference;
    @JsonIgnore  // Ignorer les comptes pour éviter la boucle avec Compte
    private final Set<Compte> comptesAssocies;

    @JsonProperty("type")
    private final Type type;

    // Constructeur avec tous les attributs, le type est calculé automatiquement
    public Transaction(LocalDateTime timestamp, String reference, Set<Compte> comptesAssocies) {
        this.timestamp = timestamp;
        this.reference = reference;
        this.comptesAssocies = Collections.unmodifiableSet(new HashSet<>(comptesAssocies));
        this.type = calculerTypeTransaction(comptesAssocies); // Utilisation de la méthode statique
    }
    // Constructeur par défaut
    public Transaction() {
        // Initialisation par défaut
        this.timestamp = LocalDateTime.now(); // vous pouvez utiliser une valeur par défaut
        this.reference = ""; // valeur par défaut
        this.comptesAssocies = new HashSet<>(); // initialisation d'un set vide
        this.type = Type.VIRINT; // type par défaut
    }
    // Méthode statique pour calculer le type de transaction
    public static Type calculerTypeTransaction(Set<Compte> comptesAssocies) {
        int nombreComptes = comptesAssocies.size();

        if (nombreComptes < 2) {
            throw new IllegalArgumentException("Une transaction doit impliquer au moins deux comptes.");
        }

        if (nombreComptes > 2) {
            return Type.VIRMULTA;
        } else {
            Compte[] comptesArray = comptesAssocies.toArray(new Compte[0]);
            Compte compte1 = comptesArray[0];
            Compte compte2 = comptesArray[1];

            boolean memeBanque = compte1.getBanque().equals(compte2.getBanque());
            boolean memePays = compte1.getBanque().getPays().equals(compte2.getBanque().getPays());

            if (memeBanque) {
                return Type.VIRINT;
            } else if (memePays) {
                return Type.VIREST;
            } else {
                return Type.VIRCHAC;
            }
        }
    }

    // Getters pour les champs immuables
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getReference() {
        return reference;
    }

    public Set<Compte> getComptesAssocies() {
        return comptesAssocies;
    }

    public Type getType() {
        return type;
    }

    // Enumération Type définissant les différents types de transactions
    public enum Type {
        VIRINT,   // Virement interne (même banque)
        VIREST,   // Virement externe (même pays, banque différente)
        VIRCHAC,  // Virement international (banques dans des pays différents)
        VIRMULTA  // Virement multiple (plus de deux comptes impliqués)
    }
}
