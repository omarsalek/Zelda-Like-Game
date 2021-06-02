package src.controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import src.modele.Arme;
import src.modele.acteur.Link;

public class MonObservateurArmes implements ListChangeListener<Arme> {
	private Pane pane;
//	private Link link;

	public MonObservateurArmes(Pane pane) {
		this.pane = pane;
		//this.link = link;

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
