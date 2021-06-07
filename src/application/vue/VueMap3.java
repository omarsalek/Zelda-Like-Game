package src.application.vue;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import src.modele.Map;
import src.modele.Map3;

public class VueMap3 {
	private Map3 map;
	private TilePane tilepane;
	
	//Constructeur
	public VueMap3(Map3 map3, TilePane tilepane) {
		this.map = map3;
		this.tilepane = tilepane;
	}

	//Cette méthode va gérer l'affichage entier de notre terrain.S
	public void afficherterrain() {
		//On commence par créer les Image.
		Image Arbre = new Image(getClass().getResourceAsStream("Arbre.png"));
		Image Arbre2 = new Image(getClass().getResourceAsStream("Arbre2.png"));
		Image Eau = new Image(getClass().getResourceAsStream("Eau.png"));
		Image Herbe = new Image(getClass().getResourceAsStream("Herbe.png"));
		Image Pierre = new Image(getClass().getResourceAsStream("Pierre.png"));
		Image panneau = new Image(getClass().getResourceAsStream("panneau.png"));
		Image feu = new Image(getClass().getResourceAsStream("feu.png"));
		Image sol = new Image(getClass().getResourceAsStream("sol.png"));

		int[][] codesTuiles = map.lireFichier();

		//for qui va parcourir et remplir le tableau d'images.
		for (int y = 0; y < codesTuiles.length; y++) {
			for (int x = 0; x < codesTuiles[y].length; x++) {
				
				ImageView ArbreView = new ImageView(Arbre);
				ImageView Arbre2View = new ImageView(Arbre2);
				ImageView EauView = new ImageView(Eau);
				ImageView HerbeView = new ImageView(Herbe);
				ImageView PierreView = new ImageView(Pierre);
				ImageView panneauView = new ImageView(panneau);
				ImageView feuView = new ImageView(feu);
				ImageView solView = new ImageView(sol);
				//Switch case qui va faire la correspondace entre la tuile et l'image octroyé à chacun des numéros de la tuile.
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
				case 8:
					tilepane.getChildren().add(panneauView);
					break;
				case 5:
					tilepane.getChildren().add(feuView);
					break;
				case 9:
					tilepane.getChildren().add(solView);
					break;
				default:
				}
			}
		}
	}
	
	public static boolean collisions(int codetuile) {
		boolean blocage = false;
		ArrayList<Integer> ListeNonAccessibles = new ArrayList<Integer>();
		ListeNonAccessibles.add(1);
		ListeNonAccessibles.add(2);
		ListeNonAccessibles.add(3);
		ListeNonAccessibles.add(4);
		ListeNonAccessibles.add(8);
		ListeNonAccessibles.add(5);
		for (int i = 0; i < ListeNonAccessibles.size(); i++) {
			if (ListeNonAccessibles.get(i) == codetuile) {
				blocage = true;
			}
		}
 		return blocage;

	}
}
