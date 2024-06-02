import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurChronometre implements EventHandler<ActionEvent> {
    private long tempsPrec;
    private long tempsEcoule;
    private Chronometre chrono;

    public ControleurChronometre(Chronometre chrono) {
        this.chrono = chrono;
        tempsPrec = 0;
        tempsEcoule = 0;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        long currentTime = System.currentTimeMillis();
        tempsEcoule += currentTime - tempsPrec;
        tempsPrec = currentTime;
        chrono.setTime(tempsEcoule);
    }

    public void reset() {
        tempsPrec = System.currentTimeMillis();
        tempsEcoule = 0;
        chrono.setTime(0);
    }
}
