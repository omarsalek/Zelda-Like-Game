package src.modele;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectureCSV {

	public void lireFichier() {
		String chemim_fichier = "map.csv";
		File file = new File(chemim_fichier);
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext())
			{
				String data = sc.next();
				System.out.println(data);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}