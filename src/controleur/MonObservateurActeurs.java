package src.controleur;

import javafx.collections.ListChangeListener;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.Acteur;
//import src.modele.Environnement;
//import src.modele.Gobelin;
//import src.modele.Link;

public class MonObservateurActeurs implements ListChangeListener<Acteur> {
	private Pane pane;
	//private Link link;

	public MonObservateurActeurs(Pane pane) {
		this.pane = pane;
		//this.link = link;
		
	}

	private void enleverEnnemi(Acteur mort) {
		// System.out.println("enlever ennemi");
		this.pane.getChildren().remove(this.pane.lookup("#" + mort.getId()));

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
