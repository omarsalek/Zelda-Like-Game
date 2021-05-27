package src.modele.acteur;

import src.modele.Environnement;

public class Loup extends Acteur{

	public Loup(String nom, String arme, int ptA, int ptv,int x , int y,Environnement env) {
		super(nom, arme, ptA, ptv,x,y, env);
		// TODO Auto-generated consructor stub
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

		
		
	}

}
