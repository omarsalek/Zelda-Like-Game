package src.application.vue;
//Cette classe va nous permettre de gérer Link dans la vue.
import javax.swing.JOptionPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.acteur.Link;

public class VueLink {
    private Pane pane ;
    //Constructeur
    public VueLink(Pane pane) {
        this.pane=pane;
    }

    //Cette méthode va créer Link dans la vue.
    public void creerLink(Link link) {
        Image link1 = new Image(getClass().getResourceAsStream("hero.png"));
        ImageView linkView = new ImageView(link1);
        linkView.translateXProperty().bind(link.xProperty());
        linkView.translateYProperty().bind(link.yProperty());
        pane.getChildren().add(linkView);
        linkView.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null, "Hi je m'appelle Link !"));

    }
    public void modifierLink(Link link) {
        Image link2 = new Image(getClass().getResourceAsStream("LinkAvecepee.png"));
        ImageView linkView = new ImageView(link2);
        linkView.translateXProperty().bind(link.xProperty());
        linkView.translateYProperty().bind(link.yProperty());
        pane.getChildren().add(linkView);//
        linkView.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null, "Hi je m'appelle Link !"));
    	
    }
    public void modifierLinkarme(Link link) {
        Image link2 = new Image(getClass().getResourceAsStream("LinkAvecPistolet.png"));
        ImageView linkView = new ImageView(link2);
        linkView.translateXProperty().bind(link.xProperty());
        linkView.translateYProperty().bind(link.yProperty());
        pane.getChildren().add(linkView);
        linkView.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null, "Hi je m'appelle Link !"));
    	
    }
    
}