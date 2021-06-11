package src.controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import src.application.vue.VueActeurs;
import src.application.vue.VueArmes;
import src.modele.Environnement;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Link;
import src.modele.acteur.Loup;
import src.modele.armes.Arc;
import src.modele.armes.Arme;
import src.modele.armes.Epee;
import src.modele.armes.Feu;

public class MonObservateurArmes implements ListChangeListener<Arme> {
	private Pane pane;
	private VueArmes VueArme;
	private Environnement env;

	public MonObservateurArmes(Pane pane, Environnement env) {
		this.pane = pane;
		this.VueArme = new VueArmes(pane);
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
		}

	}
	public void AfficherNouveauArme(Arme m) {
		
		if (m instanceof Arc) {
			this.VueArme.afficherArc(m);

		}
		if (m instanceof Epee) {
			this.VueArme.afficherEpee(m);
		}
		if (m instanceof Feu) {
			this.VueArme.afficherFeu(m);
		}
	}

	private void enleverArme(Arme ArmeDisparu) {
		this.pane.getChildren().remove(this.pane.lookup("#" + ArmeDisparu.getId()));
	}

	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends Arme> c) {
		while (c.next()) {
			for (Arme ArmeDisparu : c.getRemoved()) {
				enleverArme(ArmeDisparu);
			}
			for (Arme nouveau : c.getAddedSubList()) {
				AfficherNouveauArme(nouveau);
			}

		}
	}

}
