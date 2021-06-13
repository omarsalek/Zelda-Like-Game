package src.application.vue;
//Cette classe va nous permettre de gérer Link dans la vue.
import javax.swing.JOptionPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.acteur.Link;

public class VueLink {
	
    private Pane pane ;
    Image link1 = new Image(getClass().getResourceAsStream("../img/hero.png"));
    ImageView linkView = new ImageView(link1);
    Image link2 = new Image(getClass().getResourceAsStream("../img/LinkAvecepee.png"));
    ImageView linkView2 = new ImageView(link2);
    Image link3 = new Image(getClass().getResourceAsStream("../img/LinkAvecPistolet.png"));
    ImageView linkView3 = new ImageView(link3);
    
    //Constructeur
    public VueLink(Pane pane) {
        this.pane=pane;
        
    }

    //Cette méthode va créer Link dans la vue.
    public void creerLink(Link link) {
        linkView.translateXProperty().bind(link.xProperty());
        linkView.translateYProperty().bind(link.yProperty());
        pane.getChildren().add(linkView);
        linkView.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null, "Salut ! je m'appelle Link ! Aide moi à libérer la Princesse Zelda !"));
    }
    public void modifierLinkEpee(Link link) {
    	this.pane.getChildren().remove(linkView);
        linkView2.translateXProperty().bind(link.xProperty());
        linkView2.translateYProperty().bind(link.yProperty());
        pane.getChildren().add(linkView2);//
        linkView2.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null, "Salut ! je m'appelle Link ! Aide moi à libérer la Princesse Zelda !"));
    	
    }
    public void modifierLinkPistolet(Link link) {
    	this.pane.getChildren().remove(linkView2);
        linkView3.translateXProperty().bind(link.xProperty());
        linkView3.translateYProperty().bind(link.yProperty());
        pane.getChildren().add(linkView3);
        linkView3.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null, "Salut ! je m'appelle Link ! Aide moi à libérer la Princesse Zelda !"));
    	
    }
}
    
