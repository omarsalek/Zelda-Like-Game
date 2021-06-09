package src.modele;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Map {
	// LE METTRE DANS LE TERRAIN(MAP) ET LES DEUX CLASSES MAP DOIVENT DISPARAÎTRE

	private int [][] map;
	
	public int[][] lireFichier() {
		Path path = Paths.get("map.csv");
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