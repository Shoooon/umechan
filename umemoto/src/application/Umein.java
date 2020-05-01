package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Umein extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		try {
	        // FXMLのレイアウトをロード
	        Parent root = FXMLLoader.load(getClass().getResource(getClass().getSimpleName() + ".fxml"));

	        // タイトルセット
	        primaryStage.setTitle("ウメモト");

			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
