package src.modele.acteur;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import src.application.vue.VueTerrain;
import src.modele.Environnement;
import src.modele.Terrain;

public abstract class Acteur  {
	
	private String nom;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private IntegerProperty pointsVIE;
	private String nomArme;
	private String nom_map;
	private boolean transitionMap2;
	private int pointsATT;
	private String id;
	
	protected Environnement env;
	
	public static int compteur = 0;
	
	public Acteur(String nom, String arme, int ptA, int ptv, int x, int y, Environnement env) {
		this.nom = nom;
		this.env = env;
		this.transitionMap2 = false;
		this.xProperty = new SimpleIntegerProperty(x);
		this.yProperty = new SimpleIntegerProperty(y);
		this.nomArme = arme;
		this.pointsATT = ptA;
		this.nom_map = null;
		this.pointsVIE = new SimpleIntegerProperty(ptv);
		this.id = "A" + compteur;
		compteur++;
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
		this.nom = nom;
		this.env.getMap();
	}

	public void setArme(String arme) {
		this.nomArme = arme;
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

		return nomArme;
	}

	public int getPointsATT() {
		return pointsATT;
	}

	public void decrementerPv(int n) {
		if (this.getPtv() <= 0) {// exception
			this.env.getActeurs().remove(this);
			this.env.nbpieceProperty().setValue(this.env.nbpieceProperty().getValue() + 1);
			this.env.nbMortsProperty().setValue(this.env.nbMortsProperty().getValue() + 1);
		} else {
			this.pointsVIE.setValue(this.pointsVIE.getValue() - n);
		}
	}

	public boolean collisionsEntreActeurs(Terrain t) {
		for (Acteur m : this.env.getActeurs()) {
			if (m instanceof Gobelin || m instanceof Loup || m instanceof Archers || m instanceof Dragon
					|| m instanceof Princesse) {
				if (m.getX() / 16 == this.getX() / 16 && m.getY() / 16 == this.getY() / 16) {
					return true;
				}
			}
		}
		return false;
	}

	public void deplacerRight() {
		if (VueTerrain.collisions(this.env.getMap().lireFichier(this.getNom_map())[this.getY() / 16][(this.getX() / 16 + 1)])
				|| this.collisionsEntreActeurs(this.env.getMap()) == true) {
			this.setX(this.getX() - 16);
		} else {
			this.setX(this.getX() + 1);
			this.env.setDirection(1);
			this.env.trouverBalleDePistolet().setX(this.getX());
			this.env.trouverBalleDePistolet().setY(this.getY());
		}
		System.out.println("x" + getX());
		System.out.println("y" + getY());
	}

	public void deplacerLeft() {
		if (VueTerrain.collisions(this.env.getMap().lireFichier(this.getNom_map())[this.getY() / 16][(this.getX() / 16)])
				|| this.collisionsEntreActeurs(this.env.getMap()) == true) {
			this.setX(this.getX() + 16);
		} else {
			this.setX(this.getX() - 1);
			this.env.setDirection(3);
			this.env.trouverBalleDePistolet().setX(this.getX());
			this.env.trouverBalleDePistolet().setY(this.getY());
		}
		System.out.println("x" + getX());
		System.out.println("y" + getY());
	}

	public void deplacerUp() {
		if (VueTerrain.collisions(this.env.getMap().lireFichier(this.getNom_map())[this.getY() / 16][(this.getX() / 16)])
				|| this.collisionsEntreActeurs(this.env.getMap()) == true) {
			this.setY(this.getY() + 16);
		} else {
			this.setY(this.getY() - 1);
			this.env.setDirection(4);
			System.out.println("x" + getX());
			System.out.println("y" + getY());
			this.env.trouverBalleDePistolet().setX(this.getX());
			this.env.trouverBalleDePistolet().setY(this.getY());

		}

	}

	public void deplacerDown() {
		if (VueTerrain.collisions(this.env.getMap().lireFichier(this.getNom_map())[this.getY() / 16 + 1][(this.getX() / 16)])
				|| this.collisionsEntreActeurs(this.env.getMap()) == true) {
			this.setY(this.getY() - 16);
		} else {
			this.setY(this.getY() + 1);
			this.env.setDirection(2);
			this.env.trouverBalleDePistolet().setX(this.getX());
			this.env.trouverBalleDePistolet().setY(this.getY());
			if (this.getY() == 600) {
				this.transitionMap2 = true;
				this.setY(-1);
				this.setX(283);
			}
			System.out.println("x" + getX());
			System.out.println("y" + getY());
		}
	}

	public void setTransitionMap2(boolean chargerLaDeuxiemeMap) {
		this.transitionMap2 = chargerLaDeuxiemeMap;
	}

	public boolean isTransitionMap2() {
		return transitionMap2;
	}

	public void collisions_Right() {
		for (Acteur m : this.env.getActeurs()) {
			if ((m instanceof Gobelin || m instanceof Loup) && VueTerrain
					.collisions(this.env.getMap().lireFichier(this.getNom_map())[m.getY() / 16][(m.getX() / 16 + 1)])) {
				m.setX(m.getX() - 1);
			} else {
				m.setX(m.getX());
			}
		}
	}

	public void coliisions_Left() {
		for (Acteur m : this.env.getActeurs()) {
			if ((m instanceof Gobelin || m instanceof Loup) && VueTerrain
					.collisions(this.env.getMap().lireFichier(this.getNom_map())[m.getY() / 16][(m.getX() / 16)])) {
				m.setX(m.getX() + 1);
			} else {
				m.setX(m.getX());
			}
		}
	}

	public abstract void attaque();

	@Override
	public String toString() {
		return "Acteur [nom=" + nom + ", xProperty=" + xProperty + ", yProperty=" + yProperty + ", arme=" + nomArme
				+ ", pointsATT=" + pointsATT + ", pointsVIE=" + pointsVIE + ", id=" + id + "]";
	}
}