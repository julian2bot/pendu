import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * Controleur du clavier
 */
public class ControleurLettres implements EventHandler<ActionEvent> {

    /**
     * modèle du jeu
     */
    private MotMystere modelePendu;
    /**
     * vue du jeu
     */
    private Pendu vuePendu;

    /**
     * @param modelePendu modèle du jeu
     * @param vuePendu vue du jeu
     */
    ControleurLettres(MotMystere modelePendu, Pendu vuePendu){
        this.vuePendu = vuePendu;
        this.modelePendu = modelePendu;
    }

    /**
     * Actions à effectuer lors du clic sur une touche du clavier
     * Il faut donc: 
     * Essayer la lettre, 
     * mettre à jour l'affichage et 
     * vérifier si la partie est finie
     * @param actionEvent l'événement
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        // non fini
        System.out.println("Event lettre");
        this.modelePendu.essaiLettre( (((Button)actionEvent.getSource()).getText()).charAt(0));
        this.vuePendu.majAffichage();
        if(modelePendu.perdu()){
            vuePendu.popUpMessagePerdu();
        }
        else if (this.modelePendu.gagne()){
            vuePendu.popUpMessageGagne();
        }
    }
}
