package src.application;


import javafx.application.Application;
//import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = FXMLLoader.load(getClass().getResource("vue/Zelda-King.fxml"));
			Scene scene = new Scene(root,1200,680);
			primaryStage.setScene(scene);
			primaryStage.show();
			scene.getRoot().requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
