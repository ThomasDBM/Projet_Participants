package colloque.metier;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Participant {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long num_pers;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_naiss", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date_naiss;

    @Column(name = "organisation", nullable = false)
    private String organisation;

    @Column(name = "observation", nullable = false)
    private String observation;

    public Participant() {
    }

    public Participant(long num_pers, String nom, String prenom, String email, Date date_naiss, String organisation, String observation) {
        this.num_pers = num_pers;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisation = organisation;
        this.observation = observation;
    }

    public long getNum_pers() {
        return num_pers;
    }

    public void setNum_pers(long num_pers) {
        this.num_pers = num_pers;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return num_pers == that.num_pers && nom.equals(that.nom) && prenom.equals(that.prenom) && email.equals(that.email) && date_naiss.equals(that.date_naiss) && Objects.equals(organisation, that.organisation) && Objects.equals(observation, that.observation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num_pers, nom, prenom, email, date_naiss, organisation, observation);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "num_pers=" + num_pers +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", date_naiss=" + date_naiss +
                ", organisation='" + organisation + '\'' +
                ", observation='" + observation + '\'' +
                '}';
    }
}
