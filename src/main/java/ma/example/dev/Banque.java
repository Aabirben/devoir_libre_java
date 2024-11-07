package ma.example.dev;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idBanque")
@JsonIgnoreProperties({"comptes"}) // Ignore la relation "comptes" pendant la désérialisation
public class Banque {
    @JsonProperty("idBanque")
    private int idBanque;

    @JsonProperty("pays")
    private String pays;
    @JsonBackReference // Ajoutez cette annotation pour éviter la boucle infinie dans la relation avec Compte
    private Set<Compte> comptes = new HashSet<>();



    // Constructeur avec tous les attributs
    public Banque(int idBanque, String pays) {
        this.idBanque = idBanque;
        this.pays = pays;
    }
}