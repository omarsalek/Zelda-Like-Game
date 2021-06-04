package src.controleur;

import javax.swing.JOptionPane;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import src.application.vue.ActeursVue;
import src.modele.Environnement;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.Dragon;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Loup;

public class MonObservateurActeurs implements ListChangeListener<Acteur> {
	private Pane pane;
	private ActeursVue VueActeur;
	private Environnement env;

	public MonObservateurActeurs(Pane pane, Environnement env) {
		this.pane = pane;
		this.VueActeur = new ActeursVue(pane);
		this.env = env;

	}

	private void enleverEnnemi(Acteur mort) {
		// System.out.println("enlever ennemi");
		this.pane.getChildren().remove(this.pane.lookup("#" + mort.getId()));

	}

	public void AfficherActeurs() {
		for (Acteur m : this.env.getActeurs()) {
			if (m instanceof Loup) {
				this.VueActeur.afficherLoup(m);
			}
			if (m instanceof Gobelin) {
				this.VueActeur.afficherGobelin(m);

			}
			if (m instanceof Archers) {
				this.VueActeur.afficherArcher(m);
			}
//			if (m instanceof Dragon) {
//				this.VueActeur.afficherDragon(m);
//			}
		}
	}

	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends Acteur> c) {
		while (c.next()) {
			for (Acteur mort : c.getRemoved()) {
				enleverEnnemi(mort);

			}

		}

	}
}
