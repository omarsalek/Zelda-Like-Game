package src.controleur;

import java.util.Map;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import src.application.vue.ActeursVue;
import src.application.vue.VueTerrain;
import src.modele.Environnement;
import src.modele.Terrain;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.DragoN;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Loup;

public class MonobservateurVueMap implements ListChangeListener<Acteur>  {
	private Pane pane;
	private ActeursVue VueActeur;
	private Environnement env;
	private VueTerrain t ;

	public  MonobservateurVueMap(Pane pane, Environnement env) {
		this.pane = pane;
		this.VueActeur = new ActeursVue(pane);
		this.env = env;

	}
public void AfficherMaps() {
		
		for (Terrain m : this.env.getterrains()) {
			if (m instanceof Map) {
				this.t.afficherterrain();
//			}
			}
		}
}
//			if (m instanceof Gobelin) {
//				this.VueActeur.afficherGobelin(m);
//
//			}
//			if (m instanceof Archers) {
//				this.VueActeur.afficherArcher(m);
//			}
////			
////			
//			if (m instanceof DragoN) {
//				this.VueActeur.afficherDragon(m);
//			}



@Override
public void onChanged(Change<? extends Acteur> arg0) {
	// TODO Auto-generated method stub
	
}
		}
