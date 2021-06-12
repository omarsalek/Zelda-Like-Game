package src.controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import src.application.vue.VueItems;
import src.modele.Environnement;
import src.modele.items.Item;
import src.modele.items.Potion;

public class MonObservateurItems implements ListChangeListener<Item>{
	private Pane pane;
	private VueItems itemsView;
	private Environnement env;

	public MonObservateurItems(Pane pane, Environnement env) {
		this.pane = pane;
		this.itemsView = new VueItems(pane);
		this.env = env;
	}
	
	public void afficherItems() {
		for (Item i : this.env.getItems()) {
			if (i instanceof Potion) {
				this.itemsView.afficherPotion(i);
			}	
		}
	}
	
	public void removeItems(Item item_removed) {
		this.pane.getChildren().remove(this.pane.lookup("#" + item_removed.getId()));
	}
	
	
	
	
	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends Item> c) {
		while (c.next()) {
			for (Item item_removed : c.getRemoved()) {
				removeItems(item_removed);
			}

		}
	}
}
