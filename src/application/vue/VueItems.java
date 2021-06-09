package src.application.vue;

import javax.swing.JOptionPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.items.Items;



public class VueItems {
	 
	private Pane pane;

	  //Constructeur
	 
	  public VueItems(Pane pane) {
	      this.pane = pane;
	  }  
	  
	  public void afficherPotion(Items i) {
		  Image Potion = new Image(getClass().getResourceAsStream("PotionDeVie.png"));
		  ImageView PotionView = new ImageView(Potion);
		  PotionView.setId(i.getId());
		  PotionView.translateXProperty().bind(i.getxProperty());
		  PotionView.translateYProperty().bind(i.getyProperty());
		  pane.getChildren().add(PotionView);
	  }
	  
	  public void afficherShop() {
			Image Shop = new Image(getClass().getResourceAsStream("magasin.png"));
			ImageView ShopVue = new ImageView(Shop);
			ShopVue.setTranslateX(116);
			ShopVue.setTranslateY(137);
			ShopVue.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null,"Bienvenue au shop !"));
			pane.getChildren().add(ShopVue);
		}

}
