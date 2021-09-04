package main;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	
	public Parent root;

    @Override
    public void start(Stage primaryStage) throws IOException {
    	root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/register.fxml"));
    	Scene scene = new Scene(root);
    	primaryStage.setResizable(false);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Register");
    	primaryStage.getIcons().add(new Image("/images/icon.png"));
    	primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}