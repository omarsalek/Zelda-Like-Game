package src.controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import src.application.vue.ActeursVue;
import src.application.vue.ArmesVue;
import src.modele.Arc;
import src.modele.Arme;
import src.modele.Dragon;
import src.modele.Environnement;
import src.modele.Epee;
import src.modele.Feu;
import src.modele.Money;
import src.modele.Pistolet;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Link;
import src.modele.acteur.Loup;

public class MonObservateurArmes implements ListChangeListener<Arme> {
	private Pane pane;
	private ArmesVue VueArme;
	private Environnement env;

	public MonObservateurArmes(Pane pane, Environnement env) {
		this.pane = pane;
		this.VueArme = new ArmesVue(pane);
		this.env = env;
	}

	public void AfficherArmes() {
		for (Arme m : this.env.getArmes()) {
			if (m instanceof Arc) {
				this.VueArme.afficherArc(m);

			}
			if (m instanceof Epee) {
				this.VueArme.afficherEpee(m);

			}
			if (m instanceof Feu) {
				this.VueArme.afficherfeu(m);
		}
			if (m instanceof Pistolet) {
				this.VueArme.afficherpistolet(m);
			}
			if (m instanceof Money) {
				this.VueArme.afficherArgent(m);
			}
	}
	}

	private void enleverArme(Arme ArmeDisparu) {
		// System.out.println("enlever l'arm de l'ennemi mort");
		this.pane.getChildren().remove(this.pane.lookup("#" + ArmeDisparu.getId()));

	}

	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends Arme> c) {
		while (c.next()) {
			for (Arme ArmeDisparu : c.getRemoved()) {
				enleverArme(ArmeDisparu);

			}

		}
	}

}
