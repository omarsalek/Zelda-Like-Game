package src.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.DragoN;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Loup;

public class Environnement {
	private ObservableList<Acteur> acteurs;
	private ObservableList<Arme> armes;
	private int height;
	private int width;
	private IntegerProperty nbMortsProperty;
	private IntegerProperty piecedor ;

	public Environnement(int width, int height) {
		this.acteurs = FXCollections.observableArrayList();
		this.armes = FXCollections.observableArrayList();
		this.nbMortsProperty = new SimpleIntegerProperty(0);
		this.piecedor=new SimpleIntegerProperty(0);
		this.height = height;
		this.width = width;
	}

	public final int getnbMorts() {
		return this.nbMortsProperty.getValue();
	}
	public final int getnbpiècedor() {
		return this.piecedor.getValue();
	}
	public final void setnbpiece(int estmort) {
		this.piecedor.setValue(estmort);
	}
	public final IntegerProperty nbpieceProperty() {
		return this.piecedor;
	}
	public final IntegerProperty nbMortsProperty() {
		return this.nbMortsProperty;
	}

	public final void setnbMortsProperty(int estmort) {
		this.nbMortsProperty.setValue(estmort);
	}

	public void ajouterActeur(Acteur a) {
		acteurs.add(a);
	}

	public void ajouterArm(Arme a) {
		armes.add(a);
	}

	public ObservableList<Acteur> getActeurs() {
		return acteurs;
	}

	public ObservableList<Arme> getArmes() {
		return armes;
	}


	public Acteur getActeur(String id) {
		for (Acteur a : this.acteurs) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}

	public Arme getArm(String id) {
		for (Arme a : this.armes) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}

	public boolean estDansleTerrainX(int x) {

		return (-1 <= x && x < this.width);

	}

	public boolean estDansleTerrainY(int y) {

		return (-1 <= y && y < this.height);

	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public boolean ArcherEstMort() {
		for (Acteur m : this.getActeurs()) {
			if (m instanceof Archers) {
				if (m != null) {
					return false;
				}
			
			}
		}
		return true;
	}
	public boolean DragonEstMort() {
		for (Acteur m : this.getActeurs()) {
			if (m instanceof DragoN) {
				if (m != null) {
					return false;
				}
			
			}
		}
		return true;
	}

	public void SeDeplacerTousLesActeurs() {
		for (Acteur a : this.acteurs) {
			if (a instanceof Gobelin || a instanceof Loup) {
				if (Math.random() < 0.5) {
					int val = -1 + (int) (Math.random() * (8));
					a.setX(a.getX() - val);

				} else {
					int val2 = -1 + (int) (Math.random() * (8));
					a.setX(a.getX() + val2);
				}
			}
		}
	}
	public Arc arc() {
		for (Arme m : this.getArmes()) {
				if (m instanceof Arc) {
					return (Arc) m;
				}
		}
		return null;
	}
	public Feu drag() {
		for (Arme m : this.getArmes()) {
				if (m instanceof Feu) {
					return (Feu) m;
				}
				
				
		}
		return null;
	}
	public Pistolet pistolet() {
		for (Arme m : this.getArmes()) {
				if (m instanceof Pistolet) {
					return (Pistolet) m;
				}
				
				
		}
		return null;
	}
	public void init() {
		this.ajouterActeur(new Archers(this));
		this.ajouterActeur(new Gobelin(this,615,377));
		this.ajouterActeur(new Loup(this));
		this.ajouterActeur(new Gobelin(this,490,200));
		this.ajouterActeur(new DragoN(this));
		
		this.ajouterArm(new Epee(this));
		this.ajouterArm(new Pistolet(this));
		this.ajouterArm(new Arc(this));
		this.ajouterArm(new Feu(this));
		this.ajouterArm(new Money(this));
		
	}
}
