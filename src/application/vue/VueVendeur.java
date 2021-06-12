package src.application.vue;

import javax.swing.JOptionPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.acteur.Vendeur;

public class VueVendeur {
	private Pane pane;

	// Constructeur
	public VueVendeur(Pane pane) {
		this.pane = pane;
	}

	public void creerVendeur(Vendeur Vendeur) {
		Image Vendeur1 = new Image(getClass().getResourceAsStream("Vendeur.png"));
		ImageView VendeurView = new ImageView(Vendeur1);
		VendeurView.translateXProperty().bind(Vendeur.xProperty());
		VendeurView.translateYProperty().bind(Vendeur.yProperty());
		pane.getChildren().add(VendeurView);
		VendeurView.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null, "Hi c'est le magasinier !"));

	}
}