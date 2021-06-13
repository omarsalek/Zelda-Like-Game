package src.application.vue;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import src.modele.Terrain;

public class VueTerrain {
	
	private Terrain map;
	private TilePane tilepane;
	private Terrain map2;
	
	//Constructeur
	public VueTerrain(Terrain map, TilePane tilepane) {
		this.map = map;
		this.tilepane = tilepane;
//		this.map2=new VueTerrain(map,tilepane);
	}
	//Cette mï¿½thode va gï¿½rer l'affichage entier de notre terrain.S
	
	public void afficherterrain() {
		//On commence par crï¿½er les Image.
		Image Arbre = new Image(getClass().getResourceAsStream("../img/Arbre.png"));
		Image Arbre2 = new Image(getClass().getResourceAsStream("../img/Arbre2.png"));
		Image Eau = new Image(getClass().getResourceAsStream("../img/Eau.png"));
		Image Herbe = new Image(getClass().getResourceAsStream("../img/Herbe.png"));
		Image Pierre = new Image(getClass().getResourceAsStream("../img/Pierre.png"));

		int[][] codesTuiles = map.lireFichier("map.csv");

		//for qui va parcourir et remplir le tableau d'images.
		for (int y = 0; y < codesTuiles.length; y++) {
			for (int x = 0; x < codesTuiles[y].length; x++) {
				
				ImageView ArbreView = new ImageView(Arbre);
				ImageView Arbre2View = new ImageView(Arbre2);
				ImageView EauView = new ImageView(Eau);
				ImageView HerbeView = new ImageView(Herbe);
				ImageView PierreView = new ImageView(Pierre);
				//Switch case qui va faire la correspondace entre la tuile et l'image octroyï¿½ ï¿½ chacun des numï¿½ros de la tuile.
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
				}
			}
		}
	}
	
	public static boolean collisions(int codetuile) {// Le mettre dans le modèle TERRAIN.
		boolean blocage = false;
		ArrayList<Integer> ListeNonAccessibles = new ArrayList<Integer>();
		ListeNonAccessibles.add(1);
		ListeNonAccessibles.add(2);
		ListeNonAccessibles.add(3);
		ListeNonAccessibles.add(4);
		for (int i = 0; i < ListeNonAccessibles.size(); i++) {
			if (ListeNonAccessibles.get(i) == codetuile) {
				blocage = true;
			}
		}
 		return blocage;

	}
	public void afficherterrain2() {
		//On commence par créer les Image.
		Image Arbre = new Image(getClass().getResourceAsStream("../img/Arbre.png"));
		Image drapeau_noir = new Image(getClass().getResourceAsStream("../img/drapeau_noir.png"));
		Image Arbre2 = new Image(getClass().getResourceAsStream("../img/Arbre2.png"));
		Image herbe = new Image(getClass().getResourceAsStream("../img/Herbe.png"));
		Image pierre = new Image(getClass().getResourceAsStream("../img/Pierre.png"));
		Image sol = new Image(getClass().getResourceAsStream("../img/sol.png"));
		Image feu = new Image(getClass().getResourceAsStream("../img/feu.png"));
		Image lave = new Image(getClass().getResourceAsStream("../img/lave.png"));

		int[][] codesTuiles = map.lireFichier("map2.csv");

		//for qui va parcourir et remplir le tableau d'images.
		for (int y = 0; y < codesTuiles.length; y++) {
			for (int x = 0; x < codesTuiles[y].length; x++) {
				
				ImageView ArbreView = new ImageView(Arbre);
				ImageView drapeau_noirView = new ImageView(drapeau_noir);
				ImageView Arbre2View = new ImageView(Arbre2);
				ImageView herbeView = new ImageView(herbe);
				ImageView pierreView = new ImageView(pierre);
				ImageView solView = new ImageView(sol);
				ImageView feuView = new ImageView(feu);
				ImageView laveView = new ImageView(lave);
				
				//Switch case qui va faire la correspondace entre la tuile et l'image octroyé entre chacun des numéros de la tuile.
				switch (codesTuiles[y][x]) {
				case 0:
					tilepane.getChildren().add(herbeView);
					break;
				case 1:
					tilepane.getChildren().add(pierreView);
					break;
				case 2:
					tilepane.getChildren().add(ArbreView);
					break;
				case 3:
					tilepane.getChildren().add(Arbre2View);
					break;
				case 9:
					tilepane.getChildren().add(solView);
					break;
				case 10:
					tilepane.getChildren().add(laveView);
					break;
				case 11:
					tilepane.getChildren().add(drapeau_noirView);
					break;
				case 12:
					tilepane.getChildren().add(feuView);
					break;
				default:
				}
			}
		}
		}
	
	public static boolean collisions2(int codetuile) {
		boolean blocage = false;
		ArrayList<Integer> ListeNonAccessibles = new ArrayList<Integer>();
		ListeNonAccessibles.add(1);
		ListeNonAccessibles.add(2);
		ListeNonAccessibles.add(3);
		ListeNonAccessibles.add(11);
		ListeNonAccessibles.add(12);
		for (int i = 0; i < ListeNonAccessibles.size(); i++) {
			if (ListeNonAccessibles.get(i) == codetuile) {
				blocage = true;
			}
		}
 		return blocage;
	}

}