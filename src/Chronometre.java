import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Permet de gérer un Text associé à une Timeline pour afficher un temps écoulé
 */
public class Chronometre extends Text {
    private Timeline timeline;
    private KeyFrame keyFrame;
    private ControleurChronometre actionTemps;
    private long startTime; // Start time in milliseconds

    /**
     * Constructeur permettant de créer le chronomètre
     * avec un label initialisé à "0:0"
     * Ce constructeur créer la Timeline, la KeyFrame et le contrôleur
     */
    public Chronometre() {
        this.setText("0:0");
        actionTemps = new ControleurChronometre(this);
        keyFrame = new KeyFrame(Duration.seconds(1), actionTemps);
        this.keyFrame= new KeyFrame(Duration.millis(1), this.actionTemps);
        // Initialize the Timeline with indefinite cycle count
        this.timeline = new Timeline(this.keyFrame);
        this.timeline.setCycleCount(Animation.INDEFINITE);
    }

    /**
     * Permet au controleur de mettre à jour le text
     * la durée est affichée sous la forme m:s
     * @param tempsMillisec la durée depuis à afficher
     */
    public void setTime(long tempsMillisec) {
        long elapsedSeconds = tempsMillisec / 1000;
        long minutes = elapsedSeconds / 60;
        long seconds = elapsedSeconds % 60;
        this.setText(minutes + ":" + seconds);
    }

    /**
     * Permet de démarrer le chronomètre
     */
    public void start() {
        // startTime = System.currentTimeMillis();
        timeline.play();
    }

    /**
     * Permet d'arrêter le chronomètre
     */
    public void stop() {
        timeline.stop();
    }

    /**
     * Permet de remettre le chronomètre à 0
     */
    public void resetTime() {
        stop();
        super.setText("0:0");
        // setTime(0);
        this.actionTemps.reset();
    }

}
