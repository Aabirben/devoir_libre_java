package ma.example.dev;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idBanque")
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore les propriétés inconnues
public class Banque {
    @JsonProperty("idBanque")
    private int idBanque;

    @JsonProperty("pays")
    private String pays;
    @JsonIgnore  // Ignorer les comptes pour éviter la boucle avec Compte
    private Set<Compte> comptes = new HashSet<>();

    // Constructeur par défaut requis pour la désérialisation JSON
    public Banque() {
    }

    // Constructeur avec tous les attributs
    public Banque(int idBanque, String pays) {
        this.idBanque = idBanque;
        this.pays = pays;
    }

    public int getIdBanque() {
        return idBanque;
    }

    public void setIdBanque(int idBanque) {
        this.idBanque = idBanque;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }
}