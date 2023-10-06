package models;
import jakarta.persistence.*;

@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionID;

    @Column(name = "Enonce")
    private String enonce;

    @Column(name = "Difficulte")
    private String difficulte;
    public Question() {}

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public Question(int questionID, String enonce, String difficulte) {
        this.questionID = questionID;
        this.enonce = enonce;
        this.difficulte = difficulte;


    }
}
