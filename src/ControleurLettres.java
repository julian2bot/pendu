// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Button;

// /**
//  * Controleur du clavier
//  */
// public class ControleurLettres implements EventHandler<ActionEvent> {

//     /**
//      * modèle du jeu
//      */
//     private MotMystere modelePendu;
//     /**
//      * vue du jeu
//      */
//     private Pendu vuePendu;

//     /**
//      * @param modelePendu modèle du jeu
//      * @param vuePendu vue du jeu
//      */
//     ControleurLettres(MotMystere modelePendu, Pendu vuePendu){
//         this.vuePendu = vuePendu;
//         this.modelePendu = modelePendu;
//     }

//     /**
//      * Actions à effectuer lors du clic sur une touche du clavier
//      * Il faut donc: 
//      * Essayer la lettre, 
//      * mettre à jour l'affichage et 
//      * vérifier si la partie est finie
//      * @param actionEvent l'événement
//      */
//     @Override
//     public void handle(ActionEvent actionEvent) {
//         // non fini

        
//         System.out.println("Event lettre");

//         this.modelePendu.essaiLettre( (((Button)actionEvent.getSource()).getText()).charAt(0));
//         this.vuePendu.majAffichage();
//         // Button button = (Button) actionEvent.getSource();
//         // System.out.println("Button pressed: " + button.getText());

//         if (modelePendu.perdu()) {
//             System.out.println("c'est perdu");
//             Alert alert = vuePendu.popUpMessagePerdu();
//             alert.show();
//         } else if (this.modelePendu.gagne()) {
//             System.out.println("c'est gagné");
//             Alert alert = vuePendu.popUpMessageGagne();
//             alert.show();
//         }
        
//     }
// }
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
        System.out.println("Event lettre");

        // Récupérer le bouton cliqué et le désactiver
        Button button = (Button) actionEvent.getSource();
        button.setDisable(true);

        // Essayer la lettre
        this.modelePendu.essaiLettre(button.getText().charAt(0));

        // Mettre à jour l'affichage
        this.vuePendu.majAffichage();

        // Vérifier si la partie est finie
        if (modelePendu.perdu()) {
            System.out.println("c'est perdu");
            Alert alert = vuePendu.popUpMessagePerdu();
            alert.show();
        } else if (this.modelePendu.gagne()) {
            System.out.println("c'est gagné");
            Alert alert = vuePendu.popUpMessageGagne();
            alert.show();
        }
    }
}
