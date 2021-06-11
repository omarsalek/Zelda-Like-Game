package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.armes.Arme;


public class VueArmes {

	private Pane pane;
	
	// Constructeur
	public VueArmes(Pane pane) {
		this.pane = pane;

	}

	public void afficherArc(Arme arc) {
		Image Arc = new Image(getClass().getResourceAsStream("fleche.png"));
		ImageView ArcVue = new ImageView(Arc);
		//On lui donne un id
		ArcVue.setId(arc.getId());
		ArcVue.translateXProperty().bind(arc.getxProperty());
		ArcVue.translateYProperty().bind(arc.getyProperty());
		//Quand on click sur l'arc la console affiche ses informations.
		ArcVue.setOnMouseClicked(e -> System.out.println("Attention " + arc.getId() + " est un arc !"));
		pane.getChildren().add(ArcVue);

	}
//	public void afficherArgent(Arme argent) {
//        Image Argent = new Image(getClass().getResourceAsStream("pieceArgent.png"));
//        ImageView ArgentVue = new ImageView(Argent);
//        //On lui donne un id
//        ArgentVue.setId(argent.getId());
//        ArgentVue.translateXProperty().bind(argent.getxProperty());
//        ArgentVue.translateYProperty().bind(argent.getyProperty());
//        //Quand on click sur l'arc la console affiche ses informations.
//        ArgentVue.setOnMouseClicked(e -> System.out.println("" + argent.getId() + " c'est argent !"));
//        pane.getChildren().add(ArgentVue);
//
//    }

	public void afficherEpee(Arme epee) {
		Image Epee = new Image(getClass().getResourceAsStream("epee.png"));
		ImageView EpeeVue = new ImageView(Epee);
		// On lui donne un id
		EpeeVue.setId(epee.getId());
		EpeeVue.translateXProperty().bind(epee.getxProperty());
		EpeeVue.translateYProperty().bind(epee.getyProperty());
		// Quand on click sur l'epee la console affiche ses informations.
		EpeeVue.setOnMouseClicked(e -> System.out.println("Attention " + epee.getId() + " est un epee !"));
		pane.getChildren().add(EpeeVue);

	}
	public void afficherpistolet(Arme a) {
		Image pisto = new Image(getClass().getResourceAsStream("pistolet.PNG"));
		ImageView pistoVue = new ImageView(pisto);
		//On lui donne un id
		pistoVue.setId(a.getId());
		pistoVue.translateXProperty().bind(a.getxProperty());
		pistoVue.translateYProperty().bind(a.getyProperty());
		//Quand on click sur l'arc la console affiche ses informations.
		pistoVue.setOnMouseClicked(e -> System.out.println("Attention " + a.getId() + " est un pistolet!"));
		pane.getChildren().add(pistoVue);

	}
	public void afficherFeu(Arme a) {
		Image Feu = new Image(getClass().getResourceAsStream("FeuDragon.PNG"));
		ImageView FeuVue = new ImageView(Feu);
		//On lui donne un id
		FeuVue.setId(a.getId());
		FeuVue.translateXProperty().bind(a.getxProperty());
		FeuVue.translateYProperty().bind(a.getyProperty());
		//Quand on click sur l'arc la console affiche ses informations.
		FeuVue.setOnMouseClicked(e -> System.out.println("Attention " + a.getId() + " c'est du feu"));
		pane.getChildren().add(FeuVue);

	}
}