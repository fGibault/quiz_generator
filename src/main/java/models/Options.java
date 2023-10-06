package models;
import jakarta.persistence.*;

@Entity
@Table(name = "Options")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int optionID;

    @Column(name = "texte")
    private String texte;

    @Column(name = "EstVrai")
    private boolean estVrai;

    @ManyToOne
    @JoinColumn(name = "questionID", nullable = false)
    private Question question;

    public Options() {}

    public Options(int optionID, String texte, boolean estVrai, Question question) {
        this.optionID = optionID;
        this.texte = texte;
        this.estVrai = estVrai;
        this.question = question;
    }

    public int getOptionID() {
        return optionID;
    }

    public void setOptionID(int optionID) {
        this.optionID = optionID;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public boolean isEstVrai() {
        return estVrai;
    }

    public void setEstVrai(boolean estVrai) {
        this.estVrai = estVrai;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
