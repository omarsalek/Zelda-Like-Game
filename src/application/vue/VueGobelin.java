package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import src.modele.Acteur;
import src.modele.Environnement;
import src.modele.Gobelin;

public class VueGobelin {
	private TilePane tilepane;
	private Environnement env;

	public VueGobelin(TilePane tilepane, Environnement env) {
		this.tilepane = tilepane;
		this.env = env;
	}

	public void AfficherGobelin(Gobelin Gobelin) {
		for (Acteur m : this.env.getActeurs()) {
			if (m instanceof Gobelin) {
//				Circle GobelinVue = new Circle(8);
//				GobelinVue.setFill(Color.RED);
				 Image Gob = new Image(getClass().getResourceAsStream("Gobelin.png"));
			        ImageView GobelinVue = new ImageView(Gob);
				//int DepalcementAleatoire = -130 + (int)(Math.random() * (1300));
		        GobelinVue.setId(m.getId());
		        //GobelinVue.setTranslateX(DepalcementAleatoire);
		        GobelinVue.translateXProperty().bind(Gobelin.xProperty());
		        GobelinVue.translateYProperty().bind(Gobelin.yProperty());
		        //GobelinVue.setTranslateX(DepalcementAleatoire);
				//r.setTranslateY(nombreAleatoire);	
				System.out.println(m.getId());
				GobelinVue.setOnMouseClicked(e -> System.out.println("clic sur acteur" + e.getSource()));
				this.tilepane.getChildren().add(GobelinVue);
				
			}
		}
	}
}