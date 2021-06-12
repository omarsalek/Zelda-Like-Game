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
import src.modele.acteur.Link;
import src.modele.acteur.Vendeur;

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
	
	private Timeline gameLoop;
	private boolean finDuJeu = false;
	private int temps;
	private String reglesDuJeu = "Vous vous sentez perdu ? Voici un petit didactitiel fait par nos soins :) " + "\n" + "Se déplacer : Flèches directionnelles"+ "\n" + "Attaquer : a" + "\n" +"Prendre une épée : p"+ "\n" +"Interagir : i"+ "\n" +"Tirer avec un pistolet : t"+ "\n" +" Bon Jeu ;)";
	
	private VueVendeur vendeurVue;
	private VueTerrain mapVue;
	private Terrain map;
	private VueLink linkVue;
	private Link link;
	private Environnement env;
	private Vendeur vendeur;
	private VueItems itemView;

	@FXML
	void MecaniquesDuJeu(KeyEvent e) {
		if (finDuJeu) {
			e.consume();
			return;
		}

		switch (e.getCode()) {
			case RIGHT:
				System.out.println("Link se deplace a droit ");
				this.link.deplacerRight();
				break;
			case LEFT:
				System.out.println("Link se deplace a gauche ");
				this.link.deplacerLeft();
				break;
			case UP:
				System.out.println("Link se deplace en haut ");
				this.link.deplacerUp();
				break;
			case DOWN:
				System.out.println("Link se deplace en bas ");
				if (this.link.isTransitionMap2() == false) {
					this.link.deplacerDown();
				} else {
					chargerMap2();
					this.link.setTransitionMap2(false);
					this.env.discussionProperty().setValue("Venez acheter un pistolet pour 4PC !");
					this.link.deplacerDown();
				}
				break;
			case P:
				if (this.link.prendreEpee()) {
					this.linkVue.modifierLinkEpee(link);
				} else {
					JOptionPane.showMessageDialog(null, "Il n'y a pas d'arme à proximité.");
				}
				break;
			case A:
				this.link.attaque();
				break;
			case I:
				if (this.link.acheterPistolet()) {
					this.linkVue.modifierLinkPistolet(link);
					this.link.setLinkAchete(true);
				}
				if (this.link.scanInteraction() == 2) {
					JOptionPane.showMessageDialog(null, "Merci de m'avoir sauver Link ! The End.");
				}
				break;
			case B:
				if(this.link.boirePotion()) {
					System.out.println("Link boit la potion !");
					System.out.println("Points de vie de Link :" + this.link.getPtv());
				}
				else {
					JOptionPane.showMessageDialog(null, "Vous devez d'abord trouver une potion !");
				}
				break;
			case T:
				if (this.link.getLinkAchete()) {
					this.env.setLinkTire(true);
				} else {
					JOptionPane.showMessageDialog(null, "Vous devez d'abord acheter un pistolet !");
				}
				break;
			case H:
				JOptionPane.showMessageDialog(null, reglesDuJeu);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Choisissez la bonne touche SVP !");
				break;
		}
	}

	public void chargerMap2() {
		//Ce for supprime tous les elements du tilepane
		for (int i = this.tilepane.getChildren().size() - 1; i >= 0; i--) {
			Node c = this.tilepane.getChildren().get(i);
			this.tilepane.getChildren().remove(c);
		}
		//On intialise les elements propre à la seconde map
		map = new Terrain();
		this.env.initMap2();
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

	// Cette methode est la gameloop de notre jeu.
	private void initAnimation() {
		gameLoop = new Timeline();
		this.temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		//Ce KEyFrame va accelerer notre jeu
		KeyFrame kf = new KeyFrame(Duration.seconds(0.05), (ev -> {
			if (temps == 20000) {
				finDuJeu = true;
				gameLoop.stop();
				JOptionPane.showMessageDialog(null, "Jeu arreté , au revoir !");
			} else {
				this.env.deplacerEnnemis();
				this.env.spawnAleatoireEnnemis();
				if (this.env.archerMort() == false) {
					this.env.getFleche().tirerFleche(link);
				}
				if (this.env.archerMort()) {
					this.env.getArmes().remove(this.env.getFleche());
				}
				if (this.env.isLinkTire()) {
					this.env.trouverBalleDePistolet().tirer(link);
				}
				if (this.env.dragonMort() == false) {
					this.env.getBouleDeFeu().tirerBouleDeFeu(link);
				}

				if (this.env.deplacerEnnemis() == false) {
					this.link.coliisions_Left();
				} else {
					this.link.collisions_Right();
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
		Coeurs.radiusXProperty().bind(this.link.pointsVIE());
		MonObservateurActeurs ActeursVues = new MonObservateurActeurs(pane, env);
		MonObservateurArmes ArmesVues = new MonObservateurArmes(pane, env);
		ActeursVues.afficherActeurs();
		ArmesVues.afficherArmes();
		this.env.nbMortsProperty().addListener((obse, old, nouv) -> this.labelNbMorts.setText(nouv.toString()));
		this.env.nbpieceProperty().addListener((obse, old, nouv) -> this.nbpieceOr.setText(nouv.toString()));
		this.env.discussionProperty().addListener((obse, old, nouv) -> this.labelDiscussion.setText(nouv.toString()));
		//demarre l'animation
		initAnimation();
		gameLoop.play();
	}
}