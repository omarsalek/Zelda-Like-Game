package src.application.vue;

//Cette classe va nous permettre  de gérer Link dans la vue.
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.modele.Environnement;
import src.modele.acteur.Acteur;
import src.modele.acteur.Gobelin;

public class VueGobelin {

    private Pane pane;
    private Environnement env;
    //Constructeur
    public VueGobelin(Pane pane, Environnement env) {
        this.pane = pane;
        this.env = env;
    }

    public void afficherGobelin(Gobelin Gobelin) {
        for (Acteur m : this.env.getActeurs()) {
            if (m instanceof Gobelin) {
                //On attribue au gobelin une image.
                Image Gob = new Image(getClass().getResourceAsStream("Gobelin.png"));
                ImageView GobelinVue = new ImageView(Gob);
                //On lui donne un id
                GobelinVue.setId(m.getId());

                GobelinVue.translateXProperty().bind(Gobelin.xProperty());
                GobelinVue.translateYProperty().bind(Gobelin.yProperty());
                //Quand on click sur le gobelin la console affiche ses informations.
                GobelinVue.setOnMouseClicked(e -> System.out.println("Attention "+ m.getId() + " est un gobelin !"));
                pane.getChildren().add(GobelinVue);

            }
        }
    }

}