// import javafx.animation.Animation;
// import javafx.animation.KeyFrame;
// import javafx.animation.Timeline;
// import javafx.scene.text.Text;
// import javafx.util.Duration;
// import javafx.scene.text.Font;
// import javafx.scene.text.TextAlignment;


// /**
//  * Permet de gérer un Text associé à une Timeline pour afficher un temps écoulé
//  */
// public class Chronometre extends Text{
//     /**
//      * timeline qui va gérer le temps
//      */
//     private Timeline timeline;
//     /**
//      * la fenêtre de temps
//      */
//     private KeyFrame keyFrame;
//     /**
//      * le contrôleur associé au chronomètre
//      */
//     private ControleurChronometre actionTemps;

//     /**
//      * Constructeur permettant de créer le chronomètre
//      * avec un label initialisé à "0:0:0"
//      * Ce constructeur créer la Timeline, la KeyFrame et le contrôleur
//      */
//     public Chronometre(){
//         // A implémenter
//     }

//     /**
//      * Permet au controleur de mettre à jour le text
//      * la durée est affichée sous la forme m:s
//      * @param tempsMillisec la durée depuis à afficher
//      */
//     public void setTime(long tempsMillisec){
//         // A implémenter
//     }

//     /**
//      * Permet de démarrer le chronomètre
//      */
//     public void start(){
//         // A implémenter
//     }

//     /**
//      * Permet d'arrêter le chronomètre
//      */
//     public void stop(){
//         // A implémenter
//     }

//     /**
//      * Permet de remettre le chronomètre à 0
//      */
//     public void resetTime(){
//         // A implémenter
//     }
// }

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
        // this.setFont(new Font(20));
        // this.setTextAlignment(TextAlignment.CENTER);

        // Initialize the KeyFrame to call the actionTemps every second
        // actionTemps = new ControleurChronometre();
        keyFrame = new KeyFrame(Duration.seconds(1), actionTemps);

        // Initialize the Timeline with indefinite cycle count
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
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
        startTime = System.currentTimeMillis();
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
        setTime(0);
    }

    // /**
    //  * Contrôleur interne pour mettre à jour le chronomètre
    //  */
    // private class ControleurChronometre implements EventHandler<ActionEvent> {
    //     @Override
    //     public void handle(ActionEvent event) {
    //         long currentTime = System.currentTimeMillis();
    //         long elapsedTime = currentTime - startTime;
    //         setTime(elapsedTime);
    //     }
    // }
}
