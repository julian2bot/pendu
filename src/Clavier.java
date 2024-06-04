

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Clavier extends TilePane {
    private List<Button> clavier;
    /**
     * Initialise le clavier par defaut
     * @param Clavier liste de bouton 
     * @param ActionTouches event 
     */ 
    public Clavier(String touches, EventHandler<ActionEvent> actionTouches) {
        this.setPadding(new Insets(10));
        this.setHgap(5);
        this.setVgap(5);
        this.setAlignment(Pos.CENTER);

        clavier = new ArrayList<>();
        for (char touche : touches.toCharArray()) {
            Button button = new Button(String.valueOf(touche));
            button.setOnAction(actionTouches);
            button.setShape(new Ellipse(20,15));
            button.setMinSize(40, 30);
            button.setMaxSize(40, 30);
            clavier.add(button);
            this.getChildren().add(button);
        }
    }
    /**
     * desactive les touches
     * @param Touche les touches
     */ 
    public void desactiveTouches(Set<String> touchesDesactivees) {
        for (Button button : clavier) {
            if (touchesDesactivees.contains(button.getText())) {
                button.setDisable(true);
            } else {
                button.setDisable(false);
            }
        }
    }

}
