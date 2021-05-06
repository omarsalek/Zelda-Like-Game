package zeldaking.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;
import zeldaking.model.Terrain;

public class Controleur implements Initializable {

    @FXML
    private TilePane tilepane;
    private Terrain terrain ;
    
    private void afficherterrain() {
    	
 
    	 
    	
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		terrain=new Terrain(32, 32) ;
		this.afficherterrain();
		
	}

}
