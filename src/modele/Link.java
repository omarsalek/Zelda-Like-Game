package src.modele;


public class Link extends Acteur {
	public Link(Environnement env) {
		super("Link", "poignard", 4, 16, -400,400,env);
	}
	
	public void DeplacerLinkRight() {
		int nposX = this.getX() + 5;
		this.setX(nposX);
	}

	public void DeplacerLinkLeft() {
		int nposX = this.getX() - 5;
		this.setX(nposX);
	}

	public void DeplacerLinkUP() {
		int nposY = this.getY() - 5;
		this.setY(nposY);
	}

	public void DeplacerLinkDown() {
		int nposY = this.getY() + 5;
		this.setY(nposY);
	}

	@Override
	public boolean attaque() {
		boolean mort = false;
		Acteur m = this.TrouverEnnemi();
		
		if(m!=null ){
			System.out.println("Link attaque un Gobelin");
			m.decrementerPv(this.getPointsATT());
			
			this.decrementerPv(m.getPointsATT());
			System.out.println("Points de vie de Link est : " + this.getPtv());
			if (m.getPtv()==0) {
		        System.out.println("Gobelin mort");
		        this.env.getActeurs().remove(m);
		        mort=true;
			}
	
		}
		else{
			System.out.println("il n'ya pas de gobelin à coté ");
		}
		
		
		return mort;
	}

	private Acteur TrouverEnnemi() {
		
		// on regarde s'il y a un Gobelin a moins de 4 pixels de lui.
		for (Acteur m : this.env.getActeurs()) {
			if (m instanceof Gobelin) {
				if ((this.getY() -5<= m.getY() && m.getY() <= this.getY() +5)
					||(this.getX() -5<= m.getX() && m.getX() <= this.getX() +5)) {
					return m;
				}
			}					
		}
		return null;
	}

	@Override
	public void seDeplace() {

	}

	@Override
	public void seFaitAttaquer() {
		// this.getPtv() = this.getPTV() - ennemis.getPointsATT;
	}

	@Override
	public String toString() {
		return "Link [" + super.toString() + "]";
	}

}
