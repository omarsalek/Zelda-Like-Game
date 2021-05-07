package src.application.model;

public class Ennemis {

	private String nom;
	private int posX;
	private int posY;
	private String arme;
	private int pointsATT;
	private int pointsDEF;
	
	private Ennemis (String nom, int x, int y, String arme, int ptA, int ptD)
	{
		this.nom = nom;
		this.posX = x;
		this.posY = y;
		this.arme = arme;
		this.pointsATT = ptA;
		this.pointsDEF = ptD;
	}

	public String getNom() {
		return nom;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public String getArme() {
		return arme;
	}

	public int getPointsATT() {
		return pointsATT;
	}

	public int getPointsDEF() {
		return pointsDEF;
	}
	
	
}
