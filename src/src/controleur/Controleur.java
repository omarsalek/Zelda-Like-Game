package src.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javafx.animation.KeyFrame; 
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;
import src.application.vue.VueLink;
import src.application.vue.VueTerrain;
import src.application.vue.VueMap2;
import src.modele.Dragon;
import src.modele.Environnement;
import src.modele.Terrain;
import src.modele.Map2;
import src.modele.Pistolet;
import src.modele.acteur.Acteur;
import src.modele.acteur.Link;

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

	
	private Timeline gameLoop;
	private Boolean finDuJeu = false;
	private int temps;
	private VueTerrain mapVue;
	private Terrain map;
//	private VueMap2 mapVue;
//	private Map2 map;
	private VueLink linkVue;
	private Link link;
	
	private Environnement env;
	private Dragon drag ;
	private Pistolet pistolet ;
	private Acteur a ;
	private Terrain t ;

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
			this.link.DeplacerRight();
			break;
		case LEFT:
			System.out.println("Link se deplace a gauche ");
			this.link.DeplacerLeft();

			break;
		case UP:
			System.out.println("Link se deplace en haut ");
			this.link.DeplacerUP();

			break;
		case DOWN:
			System.out.println("Link se deplace en bas ");
			this.link.DeplacerDown();
			

			break;
		case P:
			if (this.link.prendreArme()){
			this.linkVue.modifierLink(link);
//			break ;
			}
			else {
				System.out.println("Pas d'arme d'arme a cot�");
			}
			break;
		case A:// Ce cas "A" va gérer l'attaque de Link : lorsque l'utilisateur appuie sur a,
			// Link attque l'ennemi et aussi le gobelin attaque au meme temps.
			this.link.attaque();
			break;
		case T:
			if (this.link.prendrepistolet()){
			this.linkVue.modifierLinkarme(link);
		
			}
			else {
				System.out.println("Pas d'arme d'arme a cot�");
			}
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
			if (temps == 20000) {
				finDuJeu = true;
				gameLoop.stop();
				JOptionPane.showMessageDialog(null, "Jeu arreté ,Au revoir !");
			}else {
	            this.env.SeDeplacerTousLesActeurs();				
				if (this.env.ArcherEstMort()==false) {
					
					this.env.arc().TirerDepuisArc(link);
				
				}
				 if(this.env.DragonEstMort()==false) {
					this.env.drag().TirerDepuisdragon(link) ;
//					this.env.pistolet().TirerDepuispistolet(link);
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
		this.env  = new Environnement(960, 639,map);
		this.link = new Link(env);
		this.env.ajouterActeur(link);
		this.linkVue = new VueLink(pane);
		this.linkVue.creerLink(link);
		
//		map = new Map2();
//		this.mapVue = new VueMap2(map, tilepane);
		this.link.setNom_map("map.csv");
		System.out.println(this.link.getNom_map());
		
//		map = new Terrain();
		this.mapVue = new VueTerrain(map, tilepane);
	
		this.mapVue.afficherterrain();
		this.env.init();
		this.env.getArmes().addListener(new MonObservateurArmes(this.pane,env));
		this.env.getActeurs().addListener(new MonObservateurActeurs(this.pane,env));
		
		Coeurs.radiusXProperty().bind(this.link.pointsVIE().multiply(1));
		MonObservateurActeurs ActeursVues = new MonObservateurActeurs(pane,env);
		MonObservateurArmes ArmesVues = new MonObservateurArmes(pane,env);
		ActeursVues.AfficherActeurs();
		ArmesVues.AfficherArmes();
		this.env.nbMortsProperty().addListener((obse, old, nouv) -> this.labelNbMorts.setText(nouv.toString()));
		this.env.nbpieceProperty().addListener((obse, old, nouv) -> this.nbpieceOr.setText(nouv.toString()));
		// démarre l'animation
		initAnimation();
		gameLoop.play();
	}
}