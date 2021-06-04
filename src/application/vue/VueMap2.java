package src.application.vue;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import src.modele.Map2;

public class VueMap2 {
	private Map2 map2;
	private TilePane tilepane;
	//Constructeur
	public VueMap2(Map2 map, TilePane tilepane) {
		this.map2 = map;
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
		Image pierres = new Image(getClass().getResourceAsStream("pierres.png"));
		Image panneau = new Image(getClass().getResourceAsStream("panneau.png"));
		Image feu = new Image(getClass().getResourceAsStream("feu.png"));
		Image bateau = new Image(getClass().getResourceAsStream("bateau.png"));

		int[][] codesTuiles = map2.lireFichier();

		//for qui va parcourir et remplir le tableau d'images.
		for (int y = 0; y < codesTuiles.length; y++) {
			for (int x = 0; x < codesTuiles[y].length; x++) {
				
				ImageView ArbreView = new ImageView(Arbre);
				ImageView Arbre2View = new ImageView(Arbre2);
				ImageView EauView = new ImageView(Eau);
				ImageView HerbeView = new ImageView(Herbe);
				ImageView PierreView = new ImageView(Pierre);
				ImageView pierresView = new ImageView(pierres);
				ImageView panneauView = new ImageView(panneau);
				ImageView feuView = new ImageView(feu);
				ImageView bateauView = new ImageView(bateau);
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
				case 6:
					tilepane.getChildren().add(pierresView);
					break;
				case 8:
					tilepane.getChildren().add(panneauView);
					break;
				case 5:
					tilepane.getChildren().add(feuView);
					break;
				case 7:
					tilepane.getChildren().add(bateauView);
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
		ListeNonAccessibles.add(7);
		ListeNonAccessibles.add(5);
		ListeNonAccessibles.add(6);
		ListeNonAccessibles.add(8);
		for (int i = 0; i < ListeNonAccessibles.size(); i++) {
			if (ListeNonAccessibles.get(i) == codetuile) {
				blocage = true;
			}
		}
 		return blocage;

	}
}
