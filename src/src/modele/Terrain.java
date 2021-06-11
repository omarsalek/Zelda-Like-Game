package src.modele;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//Ceci est la tuile de notre jeu.
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Terrain {
	private ObservableList<Terrain> maps;
	private String cheminfichier ;
	private int [][] map;
	//private int[][] map2;

		
	public int[][] lireFichier(String chemin) {
		this.maps=FXCollections.observableArrayList();
		Path path = Paths.get(chemin);
		List<String> arr;
		try {
			arr = Files.readAllLines(path);
			String[] arr2;
			String[][] arr3 = new String[40][60];
			for (int i = 0; i < 40; i++) {
				arr2 = arr.get(i).split("\\,");
				for (int j = 0; j < 60; j++) {
					arr3[i][j] = arr2[j];
				}
			}
			this.map = new int[40][60];
			for (int i = 0; i < arr3.length; i++) {
				for (int j = 0; j < arr3[i].length; j++) {
					map[i][j] = Integer.parseInt(arr3[i][j]);	
				}
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			return map;
	}
		
		
}

