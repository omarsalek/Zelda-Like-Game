package src.application.vue;

import javax.swing.JOptionPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.Link;

public class VueLink {
    private Pane pane ;

    public VueLink(Pane pane) {
    	this.pane=pane;
    }
    
    public void creerLink(Link link) {
        Image link1 = new Image(getClass().getResourceAsStream("hero.png"));
        ImageView linkView = new ImageView(link1);
        linkView.translateXProperty().bind(link.xProperty());
        linkView.translateYProperty().bind(link.yProperty());
        pane.getChildren().add(linkView);

        linkView.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null, "Hi je m'appelle Link !"));

    }

}