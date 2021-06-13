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
		Image arc_img = new Image(getClass().getResourceAsStream("../img/fleche.png"));
		ImageView arcVue = new ImageView(arc_img);
		//On lui donne un id
		arcVue.setId(arc.getId());
		arcVue.translateXProperty().bind(arc.getxProperty());
		arcVue.translateYProperty().bind(arc.getyProperty());
		//Quand on click sur l'arc la console affiche ses informations.
		arcVue.setOnMouseClicked(e -> System.out.println("Attention " + arc.getId() + " est un arc !"));
		pane.getChildren().add(arcVue);

	}
	public void afficherBalleDePistolet(Arme balleDePistolet) {
		Image balle = new Image(getClass().getResourceAsStream("../img/bullet.png"));
		ImageView balleVue = new ImageView(balle);
		//On lui donne un id
		balleVue.setId(balleDePistolet.getId());
		balleVue.translateXProperty().bind(balleDePistolet.getxProperty());
		balleVue.translateYProperty().bind(balleDePistolet.getyProperty());
		pane.getChildren().add(balleVue);

	}

	public void afficherEpee(Arme epee) {
		Image epee_img = new Image(getClass().getResourceAsStream("../img/epee.png"));
		ImageView epeeVue = new ImageView(epee_img);
		// On lui donne un id
		epeeVue.setId(epee.getId());
		epeeVue.translateXProperty().bind(epee.getxProperty());
		epeeVue.translateYProperty().bind(epee.getyProperty());
		epeeVue.setOnMouseClicked(e -> System.out.println("Attention " + epee.getId() + " est un epee !"));
		pane.getChildren().add(epeeVue);

	}
	public void afficherpistolet(Arme pistolet) {
		Image pistolet_img = new Image(getClass().getResourceAsStream("../img/pistolet.PNG"));
		ImageView pistoletVue = new ImageView(pistolet_img);
		//On lui donne un id
		pistoletVue.setId(pistolet.getId());
		pistoletVue.translateXProperty().bind(pistolet.getxProperty());
		pistoletVue.translateYProperty().bind(pistolet.getyProperty());
		pistoletVue.setOnMouseClicked(e -> System.out.println("Attention " + pistolet.getId() + " est un pistolet!"));
		pane.getChildren().add(pistoletVue);

	}
	public void afficherFeu(Arme bouleDeFeu) {
		Image bouleDeFeu_img = new Image(getClass().getResourceAsStream("../img/FeuDragon.PNG"));
		ImageView bouleDeFeuVue = new ImageView(bouleDeFeu_img);
		//On lui donne un id
		bouleDeFeuVue.setId(bouleDeFeu.getId());
		bouleDeFeuVue.translateXProperty().bind(bouleDeFeu.getxProperty());
		bouleDeFeuVue.translateYProperty().bind(bouleDeFeu.getyProperty());
		bouleDeFeuVue.setOnMouseClicked(e -> System.out.println("Attention " + bouleDeFeu.getId() + " c'est du feu"));
		pane.getChildren().add(bouleDeFeuVue);

	}
}