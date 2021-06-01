package src.application.vue;

import javafx.scene.layout.Pane;
import src.modele.Acteur;
import src.modele.Archers;
import src.modele.Environnement;
import src.modele.Gobelin;
import src.modele.Loup;

public class VueEnnemi {
	private Pane pane;
	protected Environnement env;

	public VueEnnemi(Pane pane, Environnement env) {
		this.pane = pane;
		this.env = env;
	}

	public boolean collisionsActeurs(Acteur acteur) {

		Boolean blocage = false;
		for (Acteur m : this.env.getActeurs()) {

			if (m instanceof Gobelin || m instanceof Loup || m instanceof Archers) {
				blocage = true;
			} 
		}
		return blocage;
	}
}
