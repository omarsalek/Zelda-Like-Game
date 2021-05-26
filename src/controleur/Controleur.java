package src.controleur;

import java.net.URL;

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
import javafx.scene.control.Label;
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
	@FXML
	private Ellipse Coeurs;
	@FXML
	private TilePane tilepane;
	@FXML
	private Pane pane;
	@FXML
	private Button CommencerJeu;
	@FXML
    private Label labelNbMorts;
	
	private Timeline gameLoop;
	private Boolean finDuJeu = false;
	private int temps;
	private VueGobelin GobelinVue;
	private VueTerrain terrainVue;
	private Terrain terrain;
	private VueLink linkVue;
	private Link link;
	private Gobelin Gobelin;
	private Environnement env;

	//Cette méthode va nous permettre de faire déplacer Link.
	@FXML
	void DeplacerLink(KeyEvent e) {
		if (finDuJeu) {
			e.consume();
			return;
		}
		//Ce switch case va faire déplacer Link dans 4 directions différentes.
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
			//Ce cas "A" va gérer l'attaque de Link : lorsque l'utilisateur appuie sur a, Link attque l'ennemi.
		case A:
			this.attaquerEtRefresh();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Choisissez la bonne touche SVP !");
			break;
		}
	}

	// Cette méthode va gérer l'attaque de Link et refresh la vue(acteur mort...).
	private void attaquerEtRefresh() {
		for (int i = this.pane.getChildren().size() - 1; i >= 0; i--) {
			Node c = this.pane.getChildren().get(i);
			if (c.getId() != null) {
				if (c instanceof ImageView && this.link.attaque() == true) {
					this.pane.getChildren().remove(c);
				}
			}
		}
	}

	// Cette méthode est la boucle de notre jeu (timer pour l'instant).
	private void initAnimation() {
		gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.7),
				(ev -> {
					if (temps == 200000) {
						finDuJeu = true;
						gameLoop.stop();
						JOptionPane.showMessageDialog(null, "Jeu arreté ,Au revoir !");
					} else {
						this.Gobelin.seDeplace();
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
		this.GobelinVue.afficherGobelin(Gobelin);
		
		this.env.nbMortsProperty().addListener((obse,old,nouv)-> this.labelNbMorts.setText(nouv.toString()));

		// démarre l'animation
		initAnimation();
		gameLoop.play();
	}
}