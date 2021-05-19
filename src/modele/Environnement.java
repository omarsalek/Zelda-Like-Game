package src.modele;


import java.util.ArrayList;


public class Environnement {
	
	private int width,height;
	private ArrayList<Acteur> acteurs;
	public Environnement(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.acteurs= new ArrayList<>();

	
	}
	
	public void ajouter(Acteur a){
		acteurs.add(a);
	}
	

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public ArrayList<Acteur> getActeurs() {
		return acteurs;
	}


	public Acteur getActeur(String id) {
		for(Acteur a:this.acteurs){
			if(a.getId().equals(id)){
				return a;
			}
		}
		return null;
	}

	public void init(){
		for(int i=0; i<1;i++){
			this.ajouter(new Gobelin(this));
		}
		
	}


}

