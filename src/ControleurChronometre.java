import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurChronometre implements EventHandler<ActionEvent> {
    private long tempsPrec;
    private long tempsEcoule;
    private Chronometre chrono;
    /**
     * Initialise le chrono par defaut
     * @param chrono Chrono
     */  
    public ControleurChronometre(Chronometre chrono) {
        this.chrono = chrono;
        tempsPrec = -1;
        tempsEcoule = System.currentTimeMillis();
    }
    /**
     * controler qui remets le temps 
     * @param actionevent event
     */ 
    @Override
    public void handle(ActionEvent actionEvent) {
        if(this.tempsPrec != -1){
            this.chrono.setTime((this.tempsPrec - this.tempsEcoule));
        }
        this.tempsPrec = System.currentTimeMillis();

    }
    /**
     * remets le chrono a zero
     */ 
    public void reset() {
        tempsPrec = -1;
        tempsEcoule = System.currentTimeMillis();
    }
}
