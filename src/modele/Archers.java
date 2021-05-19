package src.modele;

public class Archers extends Acteur{

	public Archers(String nom, String arme, int ptA, int ptv,int x,int y,Environnement env) {
		super(nom, arme, ptA, ptv,x,y, env);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean attaque() {
		return false;
		// TODO Auto-generated method stub
		
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
