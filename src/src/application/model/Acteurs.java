package src.application.model;

	public abstract class Acteurs {

		private String nom;
		private int posX;
		private int posY;
		private String arme;
		private int pointsATT;
		private int pointsVIE;
		
		public Acteurs(String nom, String arme, int ptA, int ptv)
		{
			this.nom = nom;
			this.posX = 0;
			this.posY = 0;
			this.arme = arme;
			this.pointsATT = ptA;
			this.pointsVIE = ptv;
		}

		public int getPtv() {
			return pointsVIE;
		}
		
		public void setPTV (int ptv)
		{
			this.pointsVIE = ptv;
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

		public void setNom(String nom) {
			this.nom = nom;
		}

		public void setPosX(int posX) {
			this.posX = posX;
		}

		public void setPosY(int posY) {
			this.posY = posY;
		}

		public void setArme(String arme) {
			this.arme = arme;
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

		
		public boolean estVivant()
		{
			if(this.pointsVIE>0)
				return false;
			else
				return true;
		}
		
		public abstract void attaque();
		public abstract void seFaitAttaquer();
		public abstract void seDeplace();
	}
