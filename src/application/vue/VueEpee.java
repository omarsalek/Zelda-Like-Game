package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import src.modele.Arme;
import src.modele.Environnement;
import src.modele.Epee;

public class VueEpee {

  private Pane pane;
  private Environnement env;
  //Constructeur
  public VueEpee(Pane pane, Environnement env) {
      this.pane = pane;
      this.env = env;
  }

  public void afficherEpee(Arme epee) {
      for (Arme m : this.env.getArmes()) {
          if (m instanceof Epee) {
              //On attribue au gobelin une image.
              Image Epee = new Image(getClass().getResourceAsStream("epee.png"));
              ImageView EpeeVue = new ImageView(Epee);
              //On lui donne un id
              EpeeVue.setId(m.getId());
              EpeeVue.translateXProperty().bind(epee.getxProperty());
              EpeeVue.translateYProperty().bind(epee.getyProperty());
              //Quand on click sur le gobelin la console affiche ses informations.
              EpeeVue.setOnMouseClicked(e -> System.out.println("Attention "+ m.getId() + " est un epee !"));
              pane.getChildren().add(EpeeVue);

          }
      }
  }

}