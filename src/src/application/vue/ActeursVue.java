package src.application.vue;

import javafx.scene.image.Image;


import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.acteur.Acteur;


public class ActeursVue {
  private Pane pane;
  //Constructeur
  public ActeursVue(Pane pane) {
      this.pane = pane;
  }

  public void afficherLoup(Acteur m) {
              Image Lop = new Image(getClass().getResourceAsStream("loup.png"));
              ImageView LoupVue = new ImageView(Lop);
              //On lui donne un id
              LoupVue.setId(m.getId());
              LoupVue.translateXProperty().bind(m.xProperty());
              LoupVue.translateYProperty().bind(m.yProperty());
              //Quand on click sur le loup la console affiche ses informations.
              LoupVue.setOnMouseClicked(e -> System.out.println("Attention "+ m.getId() + " est un loup!"));
              pane.getChildren().add(LoupVue);
              
          }

      
      public void afficherGobelin(Acteur m) {
                  //On attribue au gobelin une image.
                  Image Gob = new Image(getClass().getResourceAsStream("gobelin.png"));
                  ImageView GobelinVue = new ImageView(Gob);
                  //On lui donne un id
                  GobelinVue.setId(m.getId());
                  GobelinVue.translateXProperty().bind(m.xProperty());
                  GobelinVue.translateYProperty().bind(m.yProperty());
                  //Quand on click sur le gobelin la console affiche ses informations.
                  GobelinVue.setOnMouseClicked(e -> System.out.println("Attention "+ m.getId() + " est un gobelin !"));
                  pane.getChildren().add(GobelinVue);

      }
      public void afficherArcher(Acteur m) {

                  //On attribue au archer une image.
                  Image Archers= new Image(getClass().getResourceAsStream("archer.gif"));
                  ImageView ArcherVue = new ImageView(Archers);
                  //On lui donne un id
                  ArcherVue.setId(m.getId());
                  ArcherVue.translateXProperty().bind(m.xProperty());
                  ArcherVue.translateYProperty().bind(m.yProperty());
                  //Quand on click sur l'archer la console affiche ses informations.
                  ArcherVue.setOnMouseClicked(e -> System.out.println("Attention "+ m.getId() + " est un archer !"));
                  pane.getChildren().add(ArcherVue);

              }
 
    	  public void afficherDragon(Acteur m) {
    	            Image dragon1 = new Image(getClass().getResourceAsStream("DragoN.gif"));
    	            ImageView dragonvue = new ImageView(dragon1);
    	            //On lui donne un id
    	            dragonvue.setId(m.getId());
    	            dragonvue.translateXProperty().bind(m.xProperty());
    	            dragonvue.translateYProperty().bind(m.yProperty());
    	            //Quand on click sur le gobelin la console affiche ses informations.
    	            dragonvue.setOnMouseClicked(e -> System.out.println("Attention "+ m.getId() + " est un dragon !"));
    	            pane.getChildren().add(dragonvue);
    	        }
    	     }


  


    