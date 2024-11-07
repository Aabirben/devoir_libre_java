package ma.example.dev;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "numCompte")
public class Compte {
    @JsonProperty("numCompte")
    private int numCompte;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreation;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateUpdate;

    @JsonProperty("devise")
    private String devise;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "numCompte")
    @JsonManagedReference  // Gère la relation avec le client
    private Client client;
    @JsonManagedReference  // Gère la relation avec la banque et les transactions
    private Banque banque;

    private Set<Transaction> transactions = new HashSet<>();



    // Constructeur avec tous les attributs
    public Compte(int numCompte, LocalDateTime dateCreation, LocalDateTime dateUpdate, String devise, Client client, Banque banque) {
        this.numCompte = numCompte;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.devise = devise;
        this.client = client;
        this.banque = banque;
    }
}