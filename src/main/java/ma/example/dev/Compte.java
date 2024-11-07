package ma.example.dev;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


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

    @JsonIgnore  // Ignorer la référence client
    private Client client;
    @JsonIgnore  // Ignorer la référence banque
    private Banque banque;
    @JsonIgnore  // Ignorer les transactions pour éviter la boucle
    private Set<Transaction> transactions = new HashSet<>();

    // Constructeur par défaut
    public Compte() {
    }

    // Constructeur avec tous les attributs
    public Compte(int numCompte, LocalDateTime dateCreation, LocalDateTime dateUpdate, String devise, Client client, Banque banque) {
        this.numCompte = numCompte;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.devise = devise;
        this.client = client;
        this.banque = banque;
    }
    // Getters et Setters
    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}