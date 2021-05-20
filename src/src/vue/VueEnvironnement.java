package src.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import src.modele.Acteur;
import src.modele.Environnement;
import src.modele.Gobelin;

public class VueEnvironnement {
	private TilePane tilepane;
	private Environnement env;

	public VueEnvironnement(TilePane tilepane, Environnement env) {
		this.tilepane = tilepane;
		this.env = env;
	}

	public void AfficherGobelin() {
		for (Acteur m : this.env.getActeurs()) {
			if (m instanceof Gobelin) {
				Circle Gobelin = new Circle(8);
				Gobelin.setFill(Color.RED);
				// int nombreAleatoire = -130 + (int)(Math.random() * (130));
		        Gobelin.setId(m.getId());
		        Gobelin.setTranslateX(-300);
				//r.setTranslateY(nombreAleatoire);	
				System.out.println(m.getId());
				Gobelin.setOnMouseClicked(e -> System.out.println("clic sur acteur" + e.getSource()));

				this.tilepane.getChildren().add(Gobelin);

			}
		}
	}
}