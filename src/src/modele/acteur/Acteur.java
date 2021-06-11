package src.modele.acteur;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import src.application.vue.VueTerrain;
import src.modele.Environnement;
import src.modele.Terrain;

public abstract class Acteur  {
	
	private String nom;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;;
	private String arme;
	private String nom_map ;
	private boolean chargerLaDeuxiemeMap;
	private int pointsATT;
	private IntegerProperty pointsVIE;
	private String id;
	protected Environnement env;
	public static int compteur = 0;

	public Acteur(String nom, String arme, int ptA, int ptv, int x, int y, Environnement env)  {
		this.nom = nom;
		this.env = env;
		this.chargerLaDeuxiemeMap=false;
		this.xProperty = new SimpleIntegerProperty(x);
		this.yProperty = new SimpleIntegerProperty(y);
		this.arme = arme;
		this.pointsATT = ptA;
		this.nom_map = null;
		this.pointsVIE = new SimpleIntegerProperty(ptv);
		this.id = "A" + compteur;
		compteur++;
	}

	public Acteur() {
		this.nom_map="";
	}

	public final int getX() {
		return xProperty.getValue();
	}

	public final void setX(int x) {
		if (this.env.estDansleTerrainX(x)) {
			this.xProperty.setValue(x);
			
		}
	}

	public final IntegerProperty xProperty() {
		return this.xProperty;
	}

	public final int getY() {
		return yProperty.getValue();
	}

	public final void setY(int y) {
		if (this.env.estDansleTerrainY(y)) {
			yProperty.setValue(y);
		}
	}

	public final IntegerProperty yProperty() {
		return this.yProperty;
	}

	public String getId() {
		return id;
	}

	public int getPtv() {
		return pointsVIE.getValue();
	}

	public final int getTirer() {
		return pointsVIE.getValue();
	}

	public void setPTV(int ptv) {
		this.pointsVIE.setValue(ptv);
	}

	public final IntegerProperty pointsVIE() {
		return this.pointsVIE;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;this.env.getMap();
	}

	public void setArme(String arme) {
		this.arme = arme;
	}
	

	public String getNom_map() {
		return nom_map;
	}

	public void setNom_map(String nom_map) {
		this.nom_map = nom_map;
	}

	
	
	public void setPointsATT(int pointsATT) {
		this.pointsATT = pointsATT;
	}

	public String getArme() {
		
		return arme;
	}

	public int getPointsATT() {
		return pointsATT;
	}


	public void decrementerPv(int n)  {
		this.pointsVIE.setValue(this.pointsVIE.getValue() - n);
	}

	public abstract void attaque();
	public abstract void seFaitAttaquer();
	public boolean collisionEntreLinkEtEnnemis(Terrain t) {
		for (Acteur m : this.env.getActeurs()) {
			if (m instanceof Gobelin || m instanceof Loup || m instanceof Archers) {
				if (m.getX() / 16 == this.getX() / 16 && m.getY() / 16 == this.getY() / 16) {
					return true;
				}
			}
		}
		return false;
	}

	public void DeplacerRight() {
		if (VueTerrain.collisions(this.env.getMap().lireFichier(this.getNom_map())[this.getY() / 16 ][(this.getX() / 16 + 1)])
				|| this.collisionEntreLinkEtEnnemis(this.env.getMap()) == true) {
			this.setX(this.getX() - 16);
		} else {
			this.setX(this.getX() + 1);
			System.out.println("x" + getX());
			System.out.println("y" + getY());
		}
	}

	public void DeplacerLeft() {
		if (VueTerrain.collisions(this.env.getMap().lireFichier(this.getNom_map())[this.getY() / 16 ][(this.getX() / 16 )])
				|| this.collisionEntreLinkEtEnnemis(this.env.getMap()) == true) {
			this.setX(this.getX() + 16);
		} else {
			this.setX(this.getX() - 1);
		}
		System.out.println("x" + getX());
		System.out.println("y" + getY());
	}

	public void DeplacerUP() {
		if (VueTerrain.collisions(this.env.getMap().lireFichier(this.getNom_map())[this.getY() / 16][(this.getX() / 16)])
				|| this.collisionEntreLinkEtEnnemis(this.env.getMap()) == true) {
			this.setY(this.getY() + 16);
		} else {
			this.setY(this.getY() - 1);
			System.out.println("x" + getX());
			System.out.println("y" + getY());
		}

	}

	
	public void DeplacerDown() {		
		if (VueTerrain.collisions(this.env.getMap().lireFichier(this.getNom_map())[this.getY() / 16 +1][(this.getX() / 16)])
				|| this.collisionEntreLinkEtEnnemis(this.env.getMap()) == true) {
			// position dans le terrain
			this.setY(this.getY() - 16);
		} else {
			this.setY(this.getY() + 1);
			if (this.getY()==623) {
				this.chargerLaDeuxiemeMap=true;
				this.setY(-1);
				this.setX(283);
			}
			System.out.println("x" + getX());
			System.out.println("y" + getY());

		}
	}
	
	public void setChargerLaDeuxiemeMap(boolean chargerLaDeuxiemeMap) {
		this.chargerLaDeuxiemeMap = chargerLaDeuxiemeMap;
	}

	public boolean isChargerLaDeuxiemeMap() {
		return chargerLaDeuxiemeMap;
	}
	
	public void CollisionEnnemieRight() {
		for (Acteur m : this.env.getActeurs()) {
			if ((m instanceof Gobelin || m instanceof Loup ) && VueTerrain.collisions(this.env.getMap().lireFichier(this.getNom_map())[m.getY() / 16][(m.getX() / 16 +1)])) {
					m.setX(m.getX() - 16);
				}
			else {
					m.setX(m.getX());
			}
		}
	}
	
	public void CollisionEnnemieLeft() {
		for (Acteur m : this.env.getActeurs()) {
			if ((m instanceof Gobelin || m instanceof Loup ) && VueTerrain.collisions(this.env.getMap().lireFichier(this.getNom_map())[m.getY() / 16][(m.getX() / 16)])) {
					m.setX(m.getX() +16);
				}
			else {
					m.setX(m.getX());
			}
		}
	}

	@Override
	public String toString() {
		return "Acteur [nom=" + nom + ", xProperty=" + xProperty + ", yProperty=" + yProperty + ", arme=" + arme
				+ ", pointsATT=" + pointsATT + ", pointsVIE=" + pointsVIE + ", id=" + id + "]";
	}
}