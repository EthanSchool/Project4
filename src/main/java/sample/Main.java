package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * The entry point for the JavaFX application
	 *
	 * @param primaryStage
	 *
	 * @throws Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));// Loads fxml resource
		primaryStage.setTitle("Regex Example");//Sets title to "Regex Example"
		primaryStage.setScene(new Scene(root, 500, 500));// Creates new scene of the size 500x500
		primaryStage.show();// Shows Scene visually
	}

	/**
	 * The initial method called when executing a java program
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);// Launches the standalone application
	}
}
