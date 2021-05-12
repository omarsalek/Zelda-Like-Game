package src.controleur;


import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.layout.TilePane;

import javafx.util.Duration;
import src.modele.Acteur;
import src.modele.Archers;
import src.modele.Gobelin;
import src.modele.Link;
import src.modele.Loup;
import src.modele.Terrain;

public class Controleur implements Initializable {
	// permet de definir l'animation
	private Timeline gameLoop;
	private Boolean enterPressed = false;

	private int temps;
	@FXML
	private TilePane tilepane;

	@FXML
	private Button CommencerJeu;

	private Terrain terrain;

	private Link link;
	@FXML
	//private BorderPane Borderpane;

	private void afficherterrain() {

		for (int i1 = 0; i1 < terrain.getCarte().length; i1++) {
			for (int j = 0; j < terrain.getCarte()[i1].length; j++) {
				Image Herbe = new Image(getClass().getResourceAsStream("herbe.png"));
				ImageView HerbeView = new ImageView(Herbe);
				Image Pierres = new Image(getClass().getResourceAsStream("pierres.png"));
				ImageView PierresView = new ImageView(Pierres);
				Image Terre = new Image(getClass().getResourceAsStream("terre.png"));
				ImageView TerreView = new ImageView(Terre);
				Image Feu = new Image(getClass().getResourceAsStream("feu.png"));
				ImageView FeuView = new ImageView(Feu);
				switch (terrain.getCarte()[i1][j]) {
				case 2:
					tilepane.getChildren().add(HerbeView);
					break;
				case 3:
					tilepane.getChildren().add(TerreView);
					break;
				case 4:
					tilepane.getChildren().add(PierresView);
					break;
				case 1:
					tilepane.getChildren().add(FeuView);
					break;
				default:
					System.out.println("Pas de choix !");
				}

			}
		}
	}

	@FXML
	void DeplacerLink(KeyEvent e) {
		if(enterPressed){
            e.consume();//L'evenement est consommée
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

		default:
			JOptionPane.showMessageDialog(null, "Choisissez la bonne touche SVP !");
			break;
		}

	}

	private void creerLink(Link link) {
		Image link1 = new Image(getClass().getResourceAsStream("link.png"));
		ImageView linkView = new ImageView(link1);
		tilepane.getChildren().add(linkView);
		linkView.translateXProperty().bind(link.xProperty());
		linkView.translateYProperty().bind(link.yProperty());
		linkView.setOnMouseClicked(e -> JOptionPane.showMessageDialog(null, "Hi je m'appelle Link !"));

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
					if (temps == 1000) {
						//System.out.println("Jeu Arreté !");						
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

		terrain = new Terrain();
		this.afficherterrain();
		tilepane.setPadding(new Insets(121));
		tilepane.setMaxHeight(570);
		tilepane.setMaxWidth(570);
		
		this.link = new Link();
		this.creerLink(link);
		// demarre l'animation
		initAnimation();
		gameLoop.play();
		
		
		 
		
	}

}
