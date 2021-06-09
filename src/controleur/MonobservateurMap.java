package src.controleur;

import java.util.Map;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import src.application.vue.VueActeurs;
import src.application.vue.VueTerrain;
import src.modele.Environnement;
import src.modele.Terrain;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.Dragon;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Loup;

public class MonobservateurMap implements ListChangeListener<Acteur>  {
	private Pane pane;
	private VueActeurs VueActeur;
	private Environnement env;
	private VueTerrain t ;

	public  MonobservateurMap(Pane pane, Environnement env) {
		this.pane = pane;
		this.VueActeur = new VueActeurs(pane);
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



@Override
public void onChanged(Change<? extends Acteur> arg0) {
	// TODO Auto-generated method stub
	
}
		}