package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.Environnement;
import src.modele.acteur.Acteur;
import src.modele.acteur.Loup;

public class VueLoup {

  private Pane pane;
  private Environnement env;
  //Constructeur
  public VueLoup(Pane pane, Environnement env) {
      this.pane = pane;
      this.env = env;
  }

  public void afficherLoup(Loup Loup) {
      for (Acteur m : this.env.getActeurs()) {
          if (m instanceof Loup) {
              //On attribue au gobelin une image.
              Image Lop = new Image(getClass().getResourceAsStream("loup.png"));
              ImageView LoupVue = new ImageView(Lop);
              //On lui donne un id
              LoupVue.setId(m.getId());
              LoupVue.translateXProperty().bind(Loup.xProperty());
              LoupVue.translateYProperty().bind(Loup.yProperty());
              //Quand on click sur le gobelin la console affiche ses informations.
              LoupVue.setOnMouseClicked(e -> System.out.println("Attention "+ m.getId() + " est un gobelin !"));
              pane.getChildren().add(LoupVue);

          }
      }
  }

}