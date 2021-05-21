package src.application.vue;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import src.modele.Terrain;

public class VueTerrain {
	private Terrain terrain;

	private TilePane tilepane;

	public VueTerrain(Terrain terrain, TilePane tilepane) {
		this.terrain = terrain;
		this.tilepane = tilepane;
	}

	public void afficherterrain() {
		Image Arbre = new Image(getClass().getResourceAsStream("arbre.png"));
		Image Arbre2 = new Image(getClass().getResourceAsStream("arbre2.png"));
		Image Eau = new Image(getClass().getResourceAsStream("eau.png"));
		Image Herbe = new Image(getClass().getResourceAsStream("herbe.png"));
		Image Pierre = new Image(getClass().getResourceAsStream("pierre.png"));

		int[][] codesTuiles = terrain.getCarte();

		for (int y = 0; y < codesTuiles.length; y++) {
			for (int x = 0; x < codesTuiles[y].length; x++) {
				ImageView ArbreView = new ImageView(Arbre);
				ImageView Arbre2View = new ImageView(Arbre2);
				ImageView EauView = new ImageView(Eau);
				ImageView HerbeView = new ImageView(Herbe);
				ImageView PierreView = new ImageView(Pierre);
				switch (codesTuiles[y][x]) {
				case 1:
					tilepane.getChildren().add(PierreView);
					break;
				case 0:
					tilepane.getChildren().add(HerbeView);
					break;
				case 4:
					tilepane.getChildren().add(EauView);
					break;
				case 3:
					tilepane.getChildren().add(Arbre2View);
					break;
				case 2:
					tilepane.getChildren().add(ArbreView);
					break;
				default:
					System.out.println("Pas de choix !");
				}

			}
		}

	}

	public static boolean pasbouger(int codetuile) {
		boolean PasBouger = false;
		ArrayList<Integer> ListeNonAccessibles = new ArrayList<Integer>();
		ListeNonAccessibles.add(1);
		ListeNonAccessibles.add(2);
		ListeNonAccessibles.add(3);
		ListeNonAccessibles.add(4);
		for (int i = 0; i < ListeNonAccessibles.size(); i++) {
			if (ListeNonAccessibles.get(i) == codetuile) {
				PasBouger = true;
			}
		}
		return PasBouger;
	}
	// switch---> TO DO il faut supprimer la liste et for et mettre un switch

}