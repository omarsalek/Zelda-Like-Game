package src.application.vue;

import javafx.scene.layout.Pane;
import src.modele.Environnement;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Loup;

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
