package src.application.model;

public class Joueur {
	
	private String nomJoueur;
	private int pointsATT;
	private int pointsDEF;
	private String arme;
	private int posX;
	private int posY;
	
	public Joueur(String joueur, int ptsA, int ptsD, int x, int y, String arme)
	{
		this.nomJoueur = joueur;
		this.pointsATT = ptsA;
		this.pointsDEF = ptsD;
		this.posX = x;
		this.posY = y;
		this.arme = arme;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public int getPointsATT() {
		return pointsATT;
	}

	public int getPointsDEF() {
		return pointsDEF;
	}

	public String getArme() {
		return arme;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	
}
