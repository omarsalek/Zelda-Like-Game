package src.controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import src.application.vue.VueActeurs;
import src.application.vue.VueItems;
import src.modele.Environnement;
import src.modele.armes.BulletPisolet;
import src.modele.armes.Arme;
import src.modele.armes.Epee;
import src.modele.items.Items;
import src.modele.items.Potion;

public class MonObservateurItems implements ListChangeListener<Items>{
	private Pane pane;
	private VueItems itemsView;
	private Environnement env;

	public MonObservateurItems(Pane pane, Environnement env) {
		this.pane = pane;
		this.itemsView = new VueItems(pane);
		this.env = env;
	}
	
	public void afficherItems() {
		for (Items i : this.env.getItems()) {
			if (i instanceof Potion) {
				this.itemsView.afficherPotion(i);
			}	
		}
	}
	
	public void removeItems(Items item_removed) {
		this.pane.getChildren().remove(this.pane.lookup("#" + item_removed.getId()));
	}
	
	
	
	
	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends Items> c) {
		while (c.next()) {
			for (Items item_removed : c.getRemoved()) {
				removeItems(item_removed);
			}

		}
	}
}
