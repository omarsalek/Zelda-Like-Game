package src.modele;

public class Gobelin extends Acteur {

	public Gobelin(Environnement env) {
		super("Gobelin","poignard", 2, 16,615,377, env);
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
	if (Math.random()<0.5) {
	int val = -1+ (int)(Math.random() * (4));
		this.setX(this.getX()-val);
		this.setY(this.getY()+val);
	}
	else {
		int val2 = -1+ (int)(Math.random() * (4));
		this.setX(this.getX()+val2);
		this.setY(this.getY()-val2);
		
	}

}}

