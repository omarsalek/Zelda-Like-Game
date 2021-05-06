package zeldaking.model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.Line;


public class Terrain {
	private int largeur ;
	private int hauteur ;
	
	public Terrain( int l, int c) {
		this.largeur=l;
		this.hauteur=c ;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}
	public int[][] ChargerTerrain() throws IOException  {
		int tab[][]= new int[32][32];
		File tableau= new File("/home/guest/Images/essaie.CSV");
		FileReader fr = new FileReader(tableau);
        BufferedReader br = new BufferedReader (fr);
        StringBuffer sb = new StringBuffer();
        String line;
        while((line = br.readLine()) != null) {
        	sb.append(line);
            sb.append("\n");
          }
        fr.close();
        System.out.println("Contenu du fichier: ");
        System.out.println(sb.toString());
		return tab;
	}
}
	

	
	
	


