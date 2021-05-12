package src.modele;

public class Loup extends Acteur{

	public Loup(String nom, String arme, int ptA, int ptv,int x , int y) {
		super(nom, arme, ptA, ptv,x,y);
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
		int nposX=this.getX()+1;
		int nposY=this.getY()+1;	
		this.setX(nposX);
		this.setY(nposY);
		
		
	}

}
