package src.controleur;

import java.net.URL;

import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javafx.animation.KeyFrame; 
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import src.application.vue.VueArc;
import src.application.vue.VueArcher;
import src.application.vue.VueEpee;
import src.application.vue.VueGobelin;
import src.application.vue.VueLoup;
import src.application.vue.VueLink;
import src.application.vue.VueTerrain;
import src.modele.Arc;
import src.modele.Arme;
import src.modele.Environnement;
import src.modele.Epee;
import src.modele.Terrain;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Link;
import src.modele.acteur.Loup;

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
	private VueArcher ArcherVue;
	private VueEpee EpeeVue;
	private VueLoup LoupVue;
	private VueTerrain terrainVue;
	private Terrain terrain;
	private VueLink linkVue;
	private Link link;
	private VueArc arcVue;
	private Arc arc;
	private Epee epee;
	private Gobelin Gobelin;
	private Loup Loup;
	private Archers Archer;

	private Environnement env;

	// Cette méthode va nous permettre de faire déplacer Link.
	@FXML
	void DeplacerLink(KeyEvent e) {
		if (finDuJeu) {
			e.consume();
			return;
		}
		// Ce switch case va faire déplacer Link dans 4 directions différentes.
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
		// Ce cas "A" va gérer l'attaque de Link : lorsque l'utilisateur appuie sur a,
		// Link attque l'ennemi et aussi le gobelin attaque au meme temps.
		case B:
			this.link.prendreArme();
			break;
		case A:
			this.link.attaque();
			break;
		
		default:
			JOptionPane.showMessageDialog(null, "Choisissez la bonne touche SVP !");
			break;
		}
	}

	// Cette méthode est la boucle de notre jeu (timer pour l'instant).
	private void initAnimation() {
		gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(Duration.seconds(0.18), (ev -> {
			if (temps == 200000) {
				finDuJeu = true;
				gameLoop.stop();
				JOptionPane.showMessageDialog(null, "Jeu arreté ,Au revoir !");
			} else {
				this.Gobelin.seDeplace();
				this.Loup.seDeplace();
				for (Acteur m : this.env.getActeurs()) {
					if (m instanceof Archers) {
						if (m != null) {
							this.arc.TirerDepuisArc(link);
					}
				}

			}
				}
			temps++;

		}));
		gameLoop.getKeyFrames().add(kf);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Coeurs.setFill(Color.RED);

		this.env = new Environnement(960, 639);

		this.env.ajouterActeur(link);
		terrain = new Terrain();

		this.terrainVue = new VueTerrain(terrain, tilepane);
		this.terrainVue.afficherterrain();

		this.link = new Link(env);
		this.linkVue = new VueLink(pane);
		this.linkVue.creerLink(link);
		Coeurs.radiusXProperty().bind(this.link.pointsVIE().multiply(1));
		this.env.init();
		this.Gobelin = new Gobelin(env);
		this.GobelinVue = new VueGobelin(pane, env);
		this.GobelinVue.afficherGobelin(Gobelin);

		this.Archer = new Archers(env);
		this.ArcherVue = new VueArcher(pane, env);
		this.ArcherVue.afficherArcher(Archer);
		this.Loup = new Loup(env);
		this.LoupVue = new VueLoup(pane, env);
		this.LoupVue.afficherLoup(Loup);
		this.arc = new Arc(env);
		this.arcVue = new VueArc(pane, env);
		this.arcVue.afficherArc(arc);
		this.epee = new Epee(env);
		this.EpeeVue = new VueEpee(pane, env);
		this.EpeeVue.afficherEpee(epee);
		//this.env.getCameraLink().BougerCamera(100, 200);
		this.env.nbMortsProperty().addListener((obse, old, nouv) -> this.labelNbMorts.setText(nouv.toString()));
		this.env.getActeurs().addListener(new MonObservateurActeurs(this.pane));
		this.env.getArmes().addListener(new MonObservateurArmes(this.pane));

		// démarre l'animation
		initAnimation();
		gameLoop.play();
	}
}