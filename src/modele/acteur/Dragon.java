package src.modele.acteur;
import src.modele.Environnement;


public class Dragon extends Acteur {
	public Dragon(Environnement env) {
		super("Dragon", "feu", 2, 14, 550, 250, env);
	}

	@Override
	public void attaque() {

	}

	@Override
	public void seFaitAttaquer() {

	}

}
