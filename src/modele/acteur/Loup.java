package src.modele.acteur;

import src.modele.Environnement;

public class Loup extends Acteur{

	public Loup(Environnement env) {
		super("Loup","mordre", 	4, 12,351, 250, env);
		// TODO Auto-generated consructor stub 
	} 
	



	@Override
	public void attaque() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seFaitAttaquer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seDeplace() {
	if (Math.random()<0.5) {
	int val = -1+ (int)(Math.random() * (8));
		this.setX(this.getX()-val);
//		this.setY(this.getY()+val);
	}
	else {
		int val2 = -1+ (int)(Math.random() * (8));
		this.setX(this.getX()+val2);
//		this.setY(this.getY()-val2);
		
	}

}




	@Override
	public void prendreArme() {
		// TODO Auto-generated method stub
		
	}

}
