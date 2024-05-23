import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ButtonBar.ButtonData ;

import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;


/**
 * Vue du jeu du pendu
 */
public class Pendu extends Application {
    /**
     * modèle du jeu
     **/
    private MotMystere modelePendu;
    /**
     * Liste qui contient les images du jeu
     */
    private ArrayList<Image> lesImages;
    /**
     * Liste qui contient les noms des niveaux
     */    
    public List<String> niveaux;

    // les différents contrôles qui seront mis à jour ou consultés pour l'affichage
    /**
     * le dessin du pendu
     */
    private ImageView dessin;
    /**
     * le mot à trouver avec les lettres déjà trouvé
     */
    private Text motCrypte;
    /**
     * la barre de progression qui indique le nombre de tentatives
     */
    private ProgressBar pg;
    /**
     * le clavier qui sera géré par une classe à implémenter
     */
    private Clavier clavier;
    /**
     * le text qui indique le niveau de difficulté
     */
    private Text leNiveau;
    /**
     * le chronomètre qui sera géré par une clasee à implémenter
     */
    private Chronometre chrono;
    /**
     * le panel Central qui pourra être modifié selon le mode (accueil ou jeu)
     */
    private BorderPane panelCentral;
    /**
     * le bouton Paramètre / Engrenage
     */
    private Button boutonParametres;
    /**
     * le bouton Accueil / Maison
     */    
    private Button boutonMaison;
    /**
     * le bouton qui permet de (lancer ou relancer une partie
     */ 
    private Button bJouer;

    /**
     * initialise les attributs (créer le modèle, charge les images, crée le chrono ...)
     */
    @Override
    public void init() {
        this.modelePendu = new MotMystere("C:/Julian/ihm/pendu/src/message", 3, 10, MotMystere.FACILE, 10);
        // this.modelePendu = new MotMystere("/usr/share/dict/french", 3, 10, MotMystere.FACILE, 10);
        this.lesImages = new ArrayList<Image>();
        this.chargerImages("./img");
        // A terminer d'implementer
        panelCentral = new BorderPane();
        ImageView img = new ImageView(new Image(new File("img\\parametres.png").toURI().toString()));
        img.setFitHeight(100);
        img.setFitWidth(100); 
        this.boutonParametres = new Button("Paramètres");
        this.boutonMaison = new Button("Maison");
        this.bJouer = new Button("Lancer une Partie");
        this.dessin = new ImageView();
    }

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédantes
     */
    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.titre());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 800);
    }

    /**
     * @return le panel contenant le titre du jeu
     */
    private Pane titre(){
        // A implementer          
        Pane banniere = new Pane();
        BorderPane header = new BorderPane();
        HBox lesboutons = new HBox();
        Label titre = new Label("Jeu du Pendu");
        lesboutons.getChildren().addAll(this.boutonParametres, this.boutonMaison);

        header.setLeft(titre);
        header.setRight(lesboutons);
        banniere.getChildren().addAll(header);
        return banniere;

        // File imageFile = new File("img\\user.png");
        // Image imageDecline = new Image(new File("img\\user.png").toURI().toString());

        // Button deconnexion=new Button("Deconnexion" , new ImageView(new Image(new File("img\\user.png").toURI().toString())));
        // File imageFileNext = new File("img\\next.png");
        // Image imageDeclineNext = new Image(imageFileNext.toURI().toString());

        // Button apres=new Button("Question suivante" , new ImageView(imageDeclineNext));

    }

    // /**
     // * @return le panel du chronomètre
     // */
    // private TitledPane leChrono(){
        // A implementer
        // TitledPane res = new TitledPane();
        // return res;
    // }

    // /**
     // * @return la fenêtre de jeu avec le mot crypté, l'image, la barre
     // *         de progression et le clavier
     // */
    // private Pane fenetreJeu(){
        // A implementer
        // Pane res = new Pane();
        // return res;
    // }

    // /**
     // * @return la fenêtre d'accueil sur laquelle on peut choisir les paramètres de jeu
     // */
    // private Pane fenetreAccueil(){
        // A implementer    
        // Pane res = new Pane();
        // return res;
    // }

    /**
     * charge les images à afficher en fonction des erreurs
     * @param repertoire répertoire où se trouvent les images
     */
    private void chargerImages(String repertoire){
        for (int i=0; i<this.modelePendu.getNbErreursMax()+1; i++){
            File file = new File(repertoire+"/pendu"+i+".png");
            System.out.println(file.toURI().toString());
            this.lesImages.add(new Image(file.toURI().toString()));
        }
    }


    public void modeAccueil(){
        VBox t = new VBox();
        
        // Créer un groupe de toggle pour les RadioButtons
        ToggleGroup group = new ToggleGroup();

        // Créer les RadioButtons
        RadioButton radioButtonFacile = new RadioButton("Facile");
        radioButtonFacile.setToggleGroup(group);
        RadioButton radioButtonMeduim = new RadioButton("Méduim");
        radioButtonMeduim.setToggleGroup(group);
        RadioButton radioButtonDifficile = new RadioButton("Difficile");
        radioButtonDifficile.setToggleGroup(group);
        RadioButton radioButtonExpert = new RadioButton("Expert");
        radioButtonExpert.setToggleGroup(group);

        VBox vbox = new VBox(10, radioButtonFacile, radioButtonMeduim, radioButtonDifficile, radioButtonExpert);
        this.bJouer.setOnAction(new ControleurLancerPartie(modelePendu, this));
        // Créer un TitledPane et y ajouter le VBox
        TitledPane titledPane = new TitledPane("Niveau de difficulté", vbox);
        titledPane.setCollapsible(false);
        t.getChildren().addAll(this.bJouer, titledPane);
        panelCentral.setCenter(t);

    }
    
    public void modeJeu(){
        // A implementer
        BorderPane jeuHBox = new BorderPane();
        
        // PARTIE GAUCHE
        VBox imgBtn = new VBox();
        VBox nivChrono = new VBox();
        Label leMot = new Label("esfdsfsd");
        // IMAGE

        String imagePath = "file://./img/pendu0.png";
        
        dessin = new ImageView(imagePath);

        // progress bar
        TilePane listBouton = new TilePane();
        imgBtn.getChildren().addAll(leMot, dessin, listBouton);
        
        // PARTIE DROITE
        Label nivLabel = new Label("Niveau");
        
        TitledPane chrono = new TitledPane("Chronomettre", new HBox(new Label("39sec")));
        chrono.setCollapsible(false);
        Button nouveauMot = new Button();
        // nouveauMot.setOnAction(ControleurNouveauMot());

        nivChrono.getChildren().addAll(nivLabel,chrono, nouveauMot);

        // jeuHBox.getChildren().addAll(imgBtn, nivChrono);
        jeuHBox.setCenter(imgBtn);
        jeuHBox.setRight(nivChrono);
        panelCentral.setCenter(jeuHBox);
    }
    
    public void modeParametres(){
        // A implémenter
    }

    /** lance une partie */
    public void lancePartie(){
        this.modeJeu();
    }

    /**
     * raffraichit l'affichage selon les données du modèle
     */
    public void majAffichage(){
        chargerImages("./img");        
    }

    /**
     * accesseur du chronomètre (pour les controleur du jeu)
     * @return le chronomètre du jeu
     */
    public Chronometre getChrono(){
        // A implémenter
        return null; // A enlever
    }

    public Alert popUpPartieEnCours(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"La partie est en cours!\n Etes-vous sûr de l'interrompre ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }
        
    public Alert popUpReglesDuJeu(){
        // A implementer
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        return alert;
    }
    
    public Alert popUpMessageGagne(){
        // A implementer
        Alert alert = new Alert(Alert.AlertType.INFORMATION);        
        return alert;
    }
    
    public Alert popUpMessagePerdu(){
        // A implementer    
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        return alert;
    }

    /**
     * créer le graphe de scène et lance le jeu
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("IUTEAM'S - La plateforme de jeux de l'IUTO");
        stage.setScene(this.laScene());
        this.modeAccueil();
        stage.show();
        
    }

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
