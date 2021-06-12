package src.application.vue;

import javax.swing.JOptionPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.acteur.Acteur;
import src.modele.acteur.Dragon;
import src.modele.acteur.Link;

public class VueActeurs {
	private Pane pane;

	// Constructeur
	public VueActeurs(Pane pane) {
		this.pane = pane;
	}
	 

	public void afficherLoup(Acteur m) {
		Image Lop = new Image(getClass().getResourceAsStream("Loup.png"));
		ImageView LoupVue = new ImageView(Lop);
		// On lui donne un id
		LoupVue.setId(m.getId());
		LoupVue.translateXProperty().bind(m.xProperty());
		LoupVue.translateYProperty().bind(m.yProperty());
		// Quand on click sur le loup la console affiche ses informations.
		LoupVue.setOnMouseClicked(e -> System.out.println("Attention " + m.getId() + " est un loup!"));
		pane.getChildren().add(LoupVue);

	}

	public void afficherGobelin(Acteur m) {
		// On attribue au gobelin une image.
		Image Gob = new Image(getClass().getResourceAsStream("Gobelin2.png"));
		ImageView GobelinVue = new ImageView(Gob);
		// On lui donne un id
		GobelinVue.setId(m.getId());
		GobelinVue.translateXProperty().bind(m.xProperty());
		GobelinVue.translateYProperty().bind(m.yProperty());
		// Quand on click sur le gobelin la console affiche ses informations.
		GobelinVue.setOnMouseClicked(e -> System.out.println("Attention " + m.getId() + " est un gobelin !"));
		pane.getChildren().add(GobelinVue);

	}

	public void afficherArcher(Acteur m) {

		// On attribue au archer une image.
		Image Archers = new Image(getClass().getResourceAsStream("archer.png"));
		ImageView ArcherVue = new ImageView(Archers);
		// On lui donne un id
		ArcherVue.setId(m.getId());
		ArcherVue.translateXProperty().bind(m.xProperty());
		ArcherVue.translateYProperty().bind(m.yProperty());
		// Quand on click sur l'archer la console affiche ses informations.
		ArcherVue.setOnMouseClicked(e -> System.out.println("Attention " + m.getId() + " est un archer !"));
		pane.getChildren().add(ArcherVue);

	}

	public void afficherDragon(Acteur m) {
		Image dragon1 = new Image(getClass().getResourceAsStream("BossDragon.png"));
		ImageView dragonvue = new ImageView(dragon1);
		// On lui donne un id
		dragonvue.setId(m.getId());
		dragonvue.translateXProperty().bind(m.xProperty());
		dragonvue.translateYProperty().bind(m.yProperty());
		// Quand on click sur le gobelin la console affiche ses informations.
		dragonvue.setOnMouseClicked(e -> System.out.println("Attention " + m.getId() + " est un dragon !"));
		pane.getChildren().add(dragonvue);
	}

	public void afficherZelda(Acteur m) {
		Image zelda = new Image(getClass().getResourceAsStream("zelda.png"));
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
