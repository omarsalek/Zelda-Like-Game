package src.controleur;

import javax.swing.JOptionPane;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import src.application.vue.VueActeurs;
import src.modele.Environnement;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.Dragon;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Link;
import src.modele.acteur.Loup;
import src.modele.acteur.Princesse;

public class MonObservateurActeurs implements ListChangeListener<Acteur> {
	private Pane pane;
	private VueActeurs vueActeur;
	private Environnement env;

	public MonObservateurActeurs(Pane pane, Environnement env) {
		this.pane = pane;
		this.vueActeur = new VueActeurs(pane);
		this.env = env;

	}

	private void enleverEnnemi(Acteur mort) {
		// System.out.println("enlever ennemi");
		this.pane.getChildren().remove(this.pane.lookup("#" + mort.getId()));

	}


	public void AfficherActeurs() {
		for (Acteur m : this.env.getActeurs()) {
			if (m instanceof Loup) {
				this.vueActeur.afficherLoup(m);
			}
			if (m instanceof Gobelin) {
				this.vueActeur.afficherGobelin(m);

			}
			if (m instanceof Archers) {
				this.vueActeur.afficherArcher(m);
			}
			if (m instanceof Dragon) {
				this.vueActeur.afficherDragon(m);
			}
			if(m instanceof Princesse) {
				this.vueActeur.afficherZelda(m);
			}
		}
		
		
	}
	public void AfficherNouveauActeur(Acteur m) {
			if (m instanceof Loup) {
				this.vueActeur.afficherLoup(m);
			}
			if (m instanceof Gobelin) {
				this.vueActeur.afficherGobelin(m);

			}
			if (m instanceof Archers) {
				this.vueActeur.afficherArcher(m);
			}
			if (m instanceof Dragon) {
				this.vueActeur.afficherDragon(m);
			}
			if(m instanceof Princesse) {
				this.vueActeur.afficherZelda(m);
			}
		}
		
		



	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends Acteur> c) {
		while (c.next()) {
			for (Acteur mort : c.getRemoved()) {
			    	enleverEnnemi(mort);  	
			}
			for (Acteur nouveau : c.getAddedSubList()) {
				AfficherNouveauActeur(nouveau);
			}
		}

	}
}
