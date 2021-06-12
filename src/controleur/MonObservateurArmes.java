package src.controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import src.application.vue.VueArmes;
import src.modele.Environnement;
import src.modele.armes.BallePistolet;
import src.modele.armes.Fleche;
import src.modele.armes.Arme;
import src.modele.armes.Epee;
import src.modele.armes.BouleDeFeu;

public class MonObservateurArmes implements ListChangeListener<Arme> {
	private Pane pane;
	private VueArmes VueArme;
	private Environnement env;

	public MonObservateurArmes(Pane pane, Environnement env) {
		this.pane = pane;
		this.VueArme = new VueArmes(pane);
		this.env = env;
	}

	public void afficherArmes() {
		for (Arme m : this.env.getArmes()) {
			if (m instanceof BallePistolet) {
				this.VueArme.afficherBalleDePistolet(m);

			}
			if (m instanceof Fleche) {
				this.VueArme.afficherArc(m);

			}
			if (m instanceof Epee) {
				this.VueArme.afficherEpee(m);
			}
		}

	}
	public void afficherNouvellesArmes(Arme m) {
		
		if (m instanceof BallePistolet) {
			this.VueArme.afficherBalleDePistolet(m);

		}
		if (m instanceof Epee) {
			this.VueArme.afficherEpee(m);
		}
		if (m instanceof BouleDeFeu) {
			this.VueArme.afficherFeu(m);
		}
		if (m instanceof Fleche) {
			this.VueArme.afficherArc(m);

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
				afficherNouvellesArmes(nouveau);
			}

		}
	}

}
