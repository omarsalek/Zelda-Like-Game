package src.application.vue;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import src.modele.Terrain;

public class VueTerrain {
    private Terrain terrain ;
    
    private TilePane tilepane ;

    
    public VueTerrain(Terrain terrain ,TilePane tilepane) {
        this.terrain=terrain;
        this.tilepane=tilepane;
    }


   public void afficherterrain() {

        for (int j = 0; j < terrain.getCarte()[0].length; j++) {
            for (int i1 = 0; i1 < terrain.getCarte().length; i1++) {
                Image Arbre = new Image(getClass().getResourceAsStream("arbre.png"));
                ImageView ArbreView = new ImageView(Arbre);
                Image Arbre2 = new Image(getClass().getResourceAsStream("arbre2.png"));
                ImageView Arbre2View = new ImageView(Arbre2);
                Image Eau = new Image(getClass().getResourceAsStream("eau.png"));
                ImageView EauView = new ImageView(Eau);
                Image Herbe = new Image(getClass().getResourceAsStream("herbe.png"));
                ImageView HerbeView = new ImageView(Herbe);
                Image Pierre = new Image(getClass().getResourceAsStream("pierre.png"));
                ImageView PierreView = new ImageView(Pierre);
                switch (terrain.getCarte()[i1][j]) {
                case 1:
                    tilepane.getChildren().add(PierreView);
                    break;
                case 0:
                    tilepane.getChildren().add(HerbeView);
                    break;
                case 4:
                    tilepane.getChildren().add(EauView);
                    break;
                case 3:
                    tilepane.getChildren().add(Arbre2View);
                    break;
                case 2:
                    tilepane.getChildren().add(ArbreView);
                    break;
                default:
                    System.out.println("Pas de choix !");
                }

            }
        }
    
}

    
    
}