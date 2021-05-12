package src.controleur;

import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import src.modele.Acteur;
import src.modele.Archers;
import src.modele.Gobelin;
import src.modele.Link;
import src.modele.Loup;
import src.modele.Terrain;

public class Controleur implements Initializable {
	// permet de definir l'animation
	private Timeline gameLoop;//timeline

	private int temps;
	@FXML
	private TilePane tilepane;

	@FXML
	private Button CommencerJeu;

	private Terrain terrain;

	private Link link;
	@FXML
	private BorderPane Borderpane;

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
//	public  void  rafraichirPanneauJeu(){
//		for (Acteur a :  this .){
//		Circle  c  = (Circle) 
//		this.panneauJeu.lookup("#"+a.getId());//si  câ€™ est  un nouveau n Ì�e
//		if (c==null){
//			creerSprite(a);
//			}else{
//	c .setTranslateX(a.getX());
//	c.setTranslateY(a.getY());}}// pour enlever  les  morts,  il  faut  parcourir  les   sprites ...for  ( int  i =this.panneauJeu.getChildren().size()âˆ’1; i>=0;iâˆ’âˆ’){Node 
//	c=this.panneauJeu.getChildren().get(i) ;
//	Acteur a = this.env.getActeur(c.getId ());
//	if (a==null){this . panneauJeu.getChildren().remove(c);}}
	public  void  rafraichirPanneauJeu(){
		
		Image link1 = new Image(getClass().getResourceAsStream("link.png"));
		ImageView linkView = new ImageView(link1);
		tilepane.getChildren().remove(linkView);
	
	}
	

	private void initAnimation() {
		gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on dÃƒÂ©finit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017),
				// on dÃƒÂ©finit ce qui se passe ÃƒÂ  chaque frame
				// c'est un eventHandler d'ou le lambda
				(ev -> {
					if (temps == 200) {

						JOptionPane.showMessageDialog(null, "Jeu ArretÃ© recommencÃ© !");
						rafraichirPanneauJeu();
						gameLoop.stop();
						
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
		initAnimation();
		// demarre l'animation
		gameLoop.play();

	}

}
