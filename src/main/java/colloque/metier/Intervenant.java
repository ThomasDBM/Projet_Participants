package colloque.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Intervenant extends Participant{

    @Column(name = "phone")
    private String phone_number;

    @Column(name = "titre")
    private String titre;


    public Intervenant() {
        super();
    }

    public Intervenant(long num_pers, String nom, String prenom, String email, Date date_naiss, String organisation, String observation, String phone_number, String titre) {
        super(num_pers, nom, prenom, email, date_naiss, organisation, observation);
        this.phone_number = phone_number;
        this.titre = titre;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Intervenant{" +
                "num_pers=" + this.getNum_pers() +
                ", nom='" + this.getNom() + '\'' +
                ", prenom='" + this.getPrenom() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", date_naiss=" + this.getDate_naiss() +
                ", organisation='" + this.getOrganisation() + '\'' +
                ", observation='" + this.getObservation() + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }
}
