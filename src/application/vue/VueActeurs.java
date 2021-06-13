package src.application.vue;

import javax.swing.JOptionPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.acteur.Acteur;

public class VueActeurs {
	private Pane pane;

	// Constructeur
	public VueActeurs(Pane pane) {
		this.pane = pane;
	}
	 

	public void afficherLoup(Acteur m) {
		Image loup = new Image(getClass().getResourceAsStream("../img/Loup.png"));
		ImageView loupVue = new ImageView(loup);
		// On lui donne un id
		loupVue.setId(m.getId());
		loupVue.translateXProperty().bind(m.xProperty());
		loupVue.translateYProperty().bind(m.yProperty());
		// Quand on click sur le loup la console affiche ses informations.
		loupVue.setOnMouseClicked(e -> System.out.println("Attention " + m.getId() + " est un loup!"));
		pane.getChildren().add(loupVue);

	}

	public void afficherGobelin(Acteur m) {
		// On attribue au gobelin une image.
		Image gobelin = new Image(getClass().getResourceAsStream("../img/Gobelin2.png"));
		ImageView gobelinVue = new ImageView(gobelin);
		// On lui donne un id
		gobelinVue.setId(m.getId());
		gobelinVue.translateXProperty().bind(m.xProperty());
		gobelinVue.translateYProperty().bind(m.yProperty());
		// Quand on click sur le gobelin la console affiche ses informations.
		gobelinVue.setOnMouseClicked(e -> System.out.println("Attention " + m.getId() + " est un gobelin !"));
		pane.getChildren().add(gobelinVue);

	}

	public void afficherArcher(Acteur m) {

		// On attribue au archer une image.
		Image archer = new Image(getClass().getResourceAsStream("../img/archer.png"));
		ImageView archerVue = new ImageView(archer);
		// On lui donne un id
		archerVue.setId(m.getId());
		archerVue.translateXProperty().bind(m.xProperty());
		archerVue.translateYProperty().bind(m.yProperty());
		// Quand on click sur l'archer la console affiche ses informations.
		archerVue.setOnMouseClicked(e -> System.out.println("Attention " + m.getId() + " est un archer !"));
		pane.getChildren().add(archerVue);

	}

	public void afficherDragon(Acteur m) {
		Image dragon = new Image(getClass().getResourceAsStream("../img/BossDragon.png"));
		ImageView dragonVue = new ImageView(dragon);
		// On lui donne un id
		dragonVue.setId(m.getId());
		dragonVue.translateXProperty().bind(m.xProperty());
		dragonVue.translateYProperty().bind(m.yProperty());
		// Quand on click sur le gobelin la console affiche ses informations.
		dragonVue.setOnMouseClicked(e -> System.out.println("Attention " + m.getId() + " est un dragon !"));
		pane.getChildren().add(dragonVue);
	}

	public void afficherZelda(Acteur m) {
		Image zelda = new Image(getClass().getResourceAsStream("../img/zelda.png"));
		ImageView zeldaVue = new ImageView(zelda);
		// On lui donne un id
		zeldaVue.setId(m.getId());
		zeldaVue.translateXProperty().bind(m.xProperty());
		zeldaVue.translateYProperty().bind(m.yProperty());
		// Quand on click sur la princesse la console affiche ses informations.
		zeldaVue.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null,"LINK VIENT A MON SECOURS !!!"));
		pane.getChildren().add(zeldaVue);
	}
}
