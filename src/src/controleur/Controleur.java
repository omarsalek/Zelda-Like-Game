package src.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;
import src.application.vue.VueItems;
import src.application.vue.VueLink;
import src.application.vue.VueTerrain;
import src.application.vue.VueVendeur;
import src.modele.Environnement;
import src.modele.Terrain;
import src.modele.acteur.Acteur;
import src.modele.acteur.Link;
import src.modele.acteur.Vendeur;
import src.modele.armes.Arme;

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
	@FXML
	private Label nbpieceOr;
	@FXML
	private Label labelDiscussion;
	int val = 0;
	private Timeline gameLoop;
	private Boolean finDuJeu = false;
	private int temps;
	private VueVendeur vendeurVue;
	private VueTerrain mapVue;
	private Terrain map;
	private VueLink linkVue;
	private Link link;

	private Environnement env;
//	private Dragon drag ;
//	private Pistolet pistolet ;
	private Vendeur vendeur;
	private VueItems itemView;

	// Cette m√©thode va nous permettre de faire d√©placer Link.
	@FXML
	void DeplacerLink(KeyEvent e) {
		if (finDuJeu) {
			e.consume();
			return;
		}
		// Ce switch case va faire d√©placer Link dans 4 directions diffÈrentes.
		switch (e.getCode()) {
		case RIGHT:
			System.out.println("Link se deplace a droit ");
			this.link.DeplacerRight();
			break;
		case LEFT:
			System.out.println("Link se deplace a gauche ");
			this.link.DeplacerLeft();

			break;
		case UP:
			System.out.println("Link se deplace en haut ");//
			this.link.DeplacerUP();

			break;
		case DOWN:
			System.out.println("Link se deplace en bas ");
			// this.link.DeplacerDown();
			if (this.link.isChargerLaDeuxiemeMap() == false) {
				System.out.println("pas de deuxieme maps");
				this.link.DeplacerDown();
			} else {

				changermap2();
				this.link.setChargerLaDeuxiemeMap(false);
				this.env.discussionProperty().setValue("Acheter un pistolet a 1 euro !! ");
				this.link.DeplacerDown();

			}

			break;

		case P:
			if (this.link.prendreArme()) {
				this.linkVue.modifierLink(link);
			} else {
				System.out.println("Pas d'arme d'arme ‡ proximitÈ");
			}
			break;
		case A:// Ce cas "A" va g√©rer l'attaque de Link : lorsque l'utilisateur appuie sur a,
				// Link attque l'ennemi et aussi le gobelin attaque au meme temps.
			this.link.attaque();
			break;
		case T:
			if (this.link.prendrepistolet()) {
				this.linkVue.modifierLinkarme(link);

			} else {
				System.out.println("Pas d'arme d'arme ‡ proximitÈ");
			}
			break;
		case C:
				if (this.link.acheterPistolet() == true) {
					this.linkVue.modifierLinkarme(link);
				}
				if (this.link.scannerAlentours() == 2) {
					JOptionPane.showMessageDialog(null, "Merci de m'avoir sauver Link !");
				}
			

			break;
		case B:
			System.out.println("avant:" + this.link.getPtv());
			this.link.boirePotion();
			System.out.println("Link boit la potion !");
			System.out.println("apres" + this.link.getPtv());
			break;
		default:
			JOptionPane.showMessageDialog(null, "Choisissez la bonne touche SVP !");
			break;
		}
	}

	public void changermap2() {
		for (int i = this.tilepane.getChildren().size() - 1; i >= 0; i--) {
			Node c = this.tilepane.getChildren().get(i);
			this.tilepane.getChildren().remove(c);
		}
		map = new Terrain();
		this.env.CreerBoss();
		this.link.setNom_map("map2.csv");
		this.mapVue = new VueTerrain(map, tilepane);
		this.mapVue.afficherterrain2();
		this.itemView = new VueItems(pane);
		this.itemView.afficherShop();
		this.itemView.afficherChateau();
		this.env.getItems().addListener(new MonObservateurItems(this.pane, env));
		MonObservateurItems itemsView = new MonObservateurItems(pane, env);
		itemsView.afficherItems();
		this.vendeur = new Vendeur(env);
		this.env.ajouterActeur(vendeur);
		this.vendeurVue = new VueVendeur(pane);
		this.vendeurVue.creerVendeur(vendeur);
	}

	// Cette m√©thode est la boucle de notre jeu (timer pour l'instant).
	private void initAnimation() {
		gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(Duration.seconds(0.18), (ev -> {
			if (temps == 20000) {
				finDuJeu = true;
				gameLoop.stop();
				JOptionPane.showMessageDialog(null, "Jeu arretÈ , au revoir !");

			} else {
				this.env.SeDeplacerTousLesActeurs();
				// this.env.agir
				this.env.ajouterdesennemies();

				if (this.env.ArcherEstMort() == false) {

					this.env.trouverArc().TirerDepuisArc(link);

				}
				if (this.env.DragonEstMort() == false) {
					this.env.trouverFeu().TirerDepuisdragon(link);
				}
				if (this.env.SeDeplacerTousLesActeurs() == false) {
					this.link.CollisionEnnemieLeft();
				} else {
					this.link.CollisionEnnemieRight();
				}

			}
			temps++;

		}));
		gameLoop.getKeyFrames().add(kf);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		map = new Terrain();
		Coeurs.setFill(Color.RED);
		this.env = new Environnement(960, 639, map);
		this.link = new Link(env);
		this.env.ajouterActeur(link);
		this.linkVue = new VueLink(pane);
		this.linkVue.creerLink(link);
		this.link.setNom_map("map.csv");
		System.out.println(this.link.getNom_map());
		this.mapVue = new VueTerrain(map, tilepane);
		this.mapVue.afficherterrain();
		this.env.init();
		this.env.getArmes().addListener(new MonObservateurArmes(this.pane, env));
		this.env.getActeurs().addListener(new MonObservateurActeurs(this.pane, env));
		Coeurs.radiusXProperty().bind(this.link.pointsVIE().multiply(1));
		MonObservateurActeurs ActeursVues = new MonObservateurActeurs(pane, env);
		MonObservateurArmes ArmesVues = new MonObservateurArmes(pane, env);
		ActeursVues.AfficherActeurs();
		ArmesVues.AfficherArmes();
		this.env.nbMortsProperty().addListener((obse, old, nouv) -> this.labelNbMorts.setText(nouv.toString()));
		this.env.nbpieceProperty().addListener((obse, old, nouv) -> this.nbpieceOr.setText(nouv.toString()));
		this.env.discussionProperty().addListener((obse, old, nouv) -> this.labelDiscussion.setText(nouv.toString()));
		// d√©marre l'animation
		initAnimation();
		gameLoop.play();
	}
}