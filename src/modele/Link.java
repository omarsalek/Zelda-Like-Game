package src.modele;

public class Link extends Acteur{
	public Link() {
		super("Link","poignard", 4, 16,-130,2);
	}
	
	
	public void DeplacerLinkRight() {
		int nposX=this.getX()+5;
		this.setX(nposX);
	}
	public void DeplacerLinkLeft() {
		int nposX=this.getX()-5;
		this.setX(nposX);
	}
	public void DeplacerLinkUP() {
		int nposY=this.getY()-5;
		this.setY(nposY);
	}
	public void DeplacerLinkDown() {
		int nposY=this.getY()+5;
		this.setY(nposY);
	}
	
	public void ArreterLeJeu() {
		int nposY=this.getY();
		int nposX=this.getX();
		this.setX(nposX);
		this.setY(nposY);
		
	}
	
	
	
	
	
	
	

	@Override
	public void attaque() {
		// TODO Auto-generated method stub

	}

	@Override
	public void seDeplace() {
		
	}

	@Override
	public void seFaitAttaquer() {
		//this.getPtv() = this.getPTV() - ennemis.getPointsATT;
	}
	@Override
	public String toString() {
		return "Link [" + super.toString() + "]";
	}

}
		
		