package main;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public Parent root;
	
    @Override
    public void start(Stage primaryStage) throws IOException {       
    	//first view that opens is the register view
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
    	root=(Parent)loader.load();
    	
    	Scene scene = new Scene(root);
    	primaryStage.setResizable(false);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Register");
    	primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}