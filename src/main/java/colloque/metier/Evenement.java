package colloque.metier;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long num_event;

    @Column(name = "intitule", nullable = false)
    private String intitule;

    @Column(name = "theme", nullable = false)
    private String theme;

    @Column(name = "date_debut", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date_debut;

    @Column(name = "duree", nullable = false)
    private Double duree;

    @Column(name = "nb_part_max", nullable = false)
    private int nb_part_max;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "organisateur", nullable = false)
    private String organisateur;

    @Column(name = "type_even", nullable = false)
    private String type_even;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Participant> participants = new ArrayList<>();

    public Evenement() {
    }

    public Evenement(String intitule, String theme, Date date_debut, Double duree, int nb_part_max, String description, String organisateur, String type_even, List<Participant> participants)  {
        this.intitule = intitule;
        this.theme = theme;
        this.date_debut = date_debut;
        this.duree = duree;
        this.nb_part_max = nb_part_max;
        this.description = description;
        this.organisateur = organisateur;
        this.type_even = type_even;
        this.participants = participants;
    }

    public long getNum_event() {
        return num_event;
    }

    public void setNum_event(long num_event) {
        this.num_event = num_event;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Double getDuree() {
        return duree;
    }

    public void setDuree(Double duree) {
        this.duree = duree;
    }

    public int getNb_part_max() {
        return nb_part_max;
    }

    public void setNb_part_max(int nb_part_max) {
        this.nb_part_max = nb_part_max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public String getType_even() {
        return type_even;
    }

    public void setType_even(String type_even) {
        this.type_even = type_even;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public void addParticipant(Participant participant){
        this.participants.add(participant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evenement evenement = (Evenement) o;
        return num_event == evenement.num_event && nb_part_max == evenement.nb_part_max && intitule.equals(evenement.intitule) && theme.equals(evenement.theme) && date_debut.equals(evenement.date_debut) && duree.equals(evenement.duree) && Objects.equals(description, evenement.description) && Objects.equals(organisateur, evenement.organisateur) && type_even.equals(evenement.type_even);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num_event, intitule, theme, date_debut, duree, nb_part_max, description, organisateur, type_even);
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "num_event=" + num_event +
                ", intitule='" + intitule + '\'' +
                ", theme='" + theme + '\'' +
                ", date_debut=" + date_debut +
                ", duree=" + duree +
                ", nb_part_max=" + nb_part_max +
                ", description='" + description + '\'' +
                ", organisateur='" + organisateur + '\'' +
                ", type_even='" + type_even + '\'' +
                '}';
    }
}
