package src.modele;

public class Gobelin extends Acteur {

	public Gobelin(Environnement env) {
		super("Gobelin","poignard", 2, 16,-300,20, env);
	}

	@Override
	public boolean attaque() {
		return false;
		//TODO Auto-generated method stub
		
	}

	@Override
	public void seFaitAttaquer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seDeplace() {
		// TODO Auto-generated method stub
		
	}

}
