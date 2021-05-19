package src.controleur;

import java.net.URL;//cc
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import src.application.vue.VueEnvironnement;
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
	private Timeline gameLoop;
	private Boolean enterPressed = false;
	// modif
	private int temps;
	private VueEnvironnement EnvVue;
	private VueTerrain terrainVue;
	@FXML
	private TilePane tilepane;
	private Environnement env;
	@FXML
	private Button CommencerJeu;

	private Terrain terrain;
	private VueLink linkVue;
	private Link link;

	@FXML
	void DeplacerLink(KeyEvent e) {
		if (enterPressed) {
			e.consume();// L'evenement est consommée
			return;
		}
		switch (e.getCode()) {
		case RIGHT:
			System.out.println("Link se deplace a droit ");
			this.link.DeplacerLinkRight();
			break;
		case LEFT:
			System.out.println("Link se deplace a gauche ");
			this.link.DeplacerLinkLeft();
			break;
		case UP:
			System.out.println("Link se deplace en haut ");
			this.link.DeplacerLinkUP();
			break;
		case DOWN:
			System.out.println("Link se deplace en bas ");
			this.link.DeplacerLinkDown();
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
		for (int i = this.tilepane.getChildren().size() - 1; i >= 0; i--) {
			Node c = this.tilepane.getChildren().get(i);
			if (c.getId() != null) {
				if (c instanceof Circle && this.link.attaque() == true) {
					this.tilepane.getChildren().remove(c);
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
				Duration.seconds(0.017),
				// on dÃ©finit ce qui se passe Ã  chaque frame
				// c'est un eventHandler d'ou le lambda
				(ev -> {
					if (temps == 200000) {
						// System.out.println("Jeu Arreté !");

						enterPressed = true;
						gameLoop.stop();
						JOptionPane.showMessageDialog(null, "Jeu arreté ,Au revoir !");

					}
					temps++;

				}));
		gameLoop.getKeyFrames().add(kf);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.env = new Environnement(960,640);
		this.env.ajouter(link);
		terrain = new Terrain();
		tilepane.setPrefColumns(960);
		this.terrainVue = new VueTerrain(terrain, tilepane);
		this.terrainVue.afficherterrain();
		this.link = new Link(env);
		this.linkVue = new VueLink(tilepane);
		this.linkVue.creerLink(link);
		this.EnvVue = new VueEnvironnement(tilepane, env);
		this.env.init();
		this.EnvVue.AfficherGobelin();

		// demarre l'animation
		initAnimation();
		gameLoop.play();

	}

}
