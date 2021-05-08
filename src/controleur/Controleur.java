package src.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import src.modele.Terrain;
import src.modele.Terrain;

public class Controleur implements Initializable {

	@FXML
	private TilePane tilepane;
	private Terrain terrain;

	public void afficherterrain() {

		tilepane.setPadding(new Insets(121));
		tilepane.setMaxHeight(570);
		tilepane.setMaxWidth(570);

		for (int i1 = 0; i1 < terrain.getCarte().length; i1++) {
			for (int j = 0; j < terrain.getCarte()[i1].length; j++) {
				Image Herbe = new Image(getClass().getResourceAsStream("herbe.png"));
				ImageView HerbeView = new ImageView(Herbe);
				Image Pierres = new Image(getClass().getResourceAsStream("pierres.png"));
				ImageView PierresView = new ImageView(Pierres);
				Image Terre = new Image(getClass().getResourceAsStream("terre.png"));
				ImageView TerreView = new ImageView(Terre);
				Image Feu = new Image(getClass().getResourceAsStream("feu.png"));
				ImageView FeuView = new ImageView(Feu);
				switch (terrain.getCarte()[i1][j]) {
				case 2:
					tilepane.getChildren().add(HerbeView);
					break;
				case 3:
					tilepane.getChildren().add(TerreView);
					break;
				case 4:
					tilepane.getChildren().add(PierresView);
					break;
				case 1:
					tilepane.getChildren().add(FeuView);
					break;
				default:
					System.out.println("Pas de choix !");
				}

			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		terrain = new Terrain();
		this.afficherterrain();

	}

}