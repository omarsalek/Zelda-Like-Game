package src.controleur;

import java.net.URL;//cc
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.Property;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import src.application.vue.VueGobelin;
import src.application.vue.VueLink;
import src.application.vue.VueTerrain;
import src.modele.Acteur;
import src.modele.Archers;
import src.modele.Environnement;
import src.modele.Gobelin;
import src.modele.Link;
import src.modele.Loup;
import src.modele.Terrain;

public class Controleur implements Initializable {
	// permet de definir l'animation
	@FXML
	private Ellipse Coeurs;
	@FXML
	private TilePane tilepane;
	@FXML
	private Pane pane;
	@FXML
	private Button CommencerJeu;

	private Timeline gameLoop;
	private Boolean enterPressed = false;
	private int temps;
	private VueGobelin GobelinVue;
	private VueTerrain terrainVue;
	private Terrain terrain;
	private VueLink linkVue;
	private Link link;
	private Gobelin Gobelin;
	private Environnement env;

	@FXML
	void DeplacerLink(KeyEvent e) {
		if (enterPressed) {
			e.consume();// L'evenement est consommée
			return;
		}
		switch (e.getCode()) {
		case RIGHT:
			System.out.println("Link se deplace a droit ");
			this.link.DeplacerLinkRight(this.terrain);
			break;
		case LEFT:
			System.out.println("Link se deplace a gauche ");
			this.link.DeplacerLinkLeft(this.terrain);
			break;
		case UP:
			System.out.println("Link se deplace en haut ");
			this.link.DeplacerLinkUP(this.terrain);
			break;
		case DOWN:
			System.out.println("Link se deplace en bas ");
			this.link.DeplacerLinkDown(this.terrain);
			break;
		case A:
			this.AttaquerEtRefraiche();

			break;

		default:
			JOptionPane.showMessageDialog(null, "Choisissez la bonne touche SVP !");
			break;
		}

	}

	private void AttaquerEtRefraiche() {
		for (int i = this.pane.getChildren().size() - 1; i >= 0; i--) {
			Node c = this.pane.getChildren().get(i);
			if (c.getId() != null) {
				if (c instanceof ImageView && this.link.attaque() == true) {
					this.pane.getChildren().remove(c);
				}

			}
		}
	}

	private void initAnimation() {
		gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on dÃ©finit le FPS (nbre de frame par seconde)
				Duration.seconds(0.7),
				// on dÃ©finit ce qui se passe Ã  chaque frame
				// c'est un eventHandler d'ou le lambda
				(ev -> {
					if (temps == 200000) {
						// System.out.println("Jeu Arreté !");
						enterPressed = true;
						gameLoop.stop();
						JOptionPane.showMessageDialog(null, "Jeu arreté ,Au revoir !");

					} else {
						this.Gobelin.seDeplace();
						// this.Gobelin.DeplacerGobelinLeft();

						// this.Gobelin.DeplacerGobelinDown();

					}
					temps++;

				}));
		gameLoop.getKeyFrames().add(kf);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Coeurs.setFill(Color.RED);

		this.env = new Environnement();
		this.env.ajouter(link);
		terrain = new Terrain();
		this.terrainVue = new VueTerrain(terrain, tilepane);
		this.terrainVue.afficherterrain();
		this.link = new Link(env);
		this.linkVue = new VueLink(pane);
		this.linkVue.creerLink(link);
		Coeurs.radiusXProperty().bind(this.link.pointsVIE().multiply(1));
		this.GobelinVue = new VueGobelin(pane, env);
		this.env.init();
		this.Gobelin = new Gobelin(env);
		this.GobelinVue.AfficherGobelin(Gobelin);

		// demarre l'animation
		initAnimation();
		gameLoop.play();

	}

}
