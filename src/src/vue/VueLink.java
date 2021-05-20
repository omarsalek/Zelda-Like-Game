package src.vue;

import javax.swing.JOptionPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import src.modele.Link;

public class VueLink {
    private TilePane tilepane ;

    public VueLink(TilePane tilepane) {
    	this.tilepane=tilepane;
    }
    
    public void creerLink(Link link) {
        Image link1 = new Image(getClass().getResourceAsStream("link.png"));
        ImageView linkView = new ImageView(link1);
        tilepane.getChildren().add(linkView);
        linkView.translateXProperty().bind(link.xProperty());
        linkView.translateYProperty().bind(link.yProperty());
        linkView.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null, "Hi je m'appelle Link !"));
    }

}