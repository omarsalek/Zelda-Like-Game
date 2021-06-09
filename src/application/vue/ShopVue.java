package src.application.vue;

import javax.swing.JOptionPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ShopVue {
	private Pane pane;

	// Constructeur
	public ShopVue(Pane pane) {
		this.pane = pane;
	}

	public void afficherShop() {
		Image Shop = new Image(getClass().getResourceAsStream("magasin.png"));
		ImageView ShopVue = new ImageView(Shop);
		ShopVue.setTranslateX(400);
		ShopVue.setTranslateY(100);
		ShopVue.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null,"Bienvenue au shop ! "));
		pane.getChildren().add(ShopVue);

	}

}
