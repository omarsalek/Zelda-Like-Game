package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.Arme;


public class ArmesVue {

	private Pane pane;
	
	// Constructeur
	public ArmesVue(Pane pane) {
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
}