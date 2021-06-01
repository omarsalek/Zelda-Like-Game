package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.Arc;
import src.modele.Arme;
import src.modele.Environnement;

public class VueArc {

  private Pane pane;
  private Environnement env;
  //Constructeur
  public VueArc(Pane pane, Environnement env) {
      this.pane = pane;
      this.env = env;
  }

  public void afficherArc(Arme ArcTire) {
      for (Arme m : this.env.getArmes()) {
          if (m instanceof Arc) {
              //On attribue au gobelin une image.
              Image Arc = new Image(getClass().getResourceAsStream("flecheArc.png"));
              ImageView ArcVue = new ImageView(Arc);
              //On lui donne un id
              ArcVue.setId(m.getId());
              ArcVue.translateXProperty().bind(ArcTire.getxProperty());
              ArcVue.translateYProperty().bind(ArcTire.getyProperty());
              //Quand on click sur le gobelin la console affiche ses informations.
              ArcVue.setOnMouseClicked(e -> System.out.println("Attention "+ m.getId() + " est un arc !"));
              pane.getChildren().add(ArcVue);

          }
      }
  }

}