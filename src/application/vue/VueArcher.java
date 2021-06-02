package src.application.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.Environnement;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.Loup;

public class VueArcher {

  private Pane pane;
  private Environnement env;
  //Constructeur
  public VueArcher(Pane pane, Environnement env) {
      this.pane = pane;
      this.env = env;
  }

  public void afficherArcher(Archers Archer) {
      for (Acteur m : this.env.getActeurs()) {
          if (m instanceof Archers) {
              //On attribue au archer une image.
              Image Archers= new Image(getClass().getResourceAsStream("archer.gif"));
              ImageView ArcherVue = new ImageView(Archers);
              //On lui donne un id
              ArcherVue.setId(m.getId());
              ArcherVue.translateXProperty().bind(Archer.xProperty());
              ArcherVue.translateYProperty().bind(Archer.yProperty());
              //Quand on click sur l'archer la console affiche ses informations.
              ArcherVue.setOnMouseClicked(e -> System.out.println("Attention "+ m.getId() + " est un archer !"));
              pane.getChildren().add(ArcherVue);

          }
      }
  }

}