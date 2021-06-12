package src.application.vue;

import javax.swing.JOptionPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.items.Item;



public class VueItems {
	 
	private Pane pane;

	  //Constructeur
	 
	  public VueItems(Pane pane) {
	      this.pane = pane;
	  }  
	  
	  public void afficherPotion(Item i) {
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
	  public void afficherChateau() {
			Image chateau = new Image(getClass().getResourceAsStream("chateau.png"));
			ImageView chateauVue = new ImageView(chateau);
			chateauVue.setTranslateX(700);
			chateauVue.setTranslateY(80);
			chateauVue.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null,"Bienvenue au chateau !"));
			pane.getChildren().add(chateauVue);
		}

}
