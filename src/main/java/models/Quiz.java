package models;
import jakarta.persistence.*;

@Entity
@Table(name = "Quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quizID;

    @Column(name = "Titre")
    private String titre;
    public Quiz() {}

    public Quiz(int quizID, String titre) {
        this.quizID = quizID;
        this.titre = titre;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
