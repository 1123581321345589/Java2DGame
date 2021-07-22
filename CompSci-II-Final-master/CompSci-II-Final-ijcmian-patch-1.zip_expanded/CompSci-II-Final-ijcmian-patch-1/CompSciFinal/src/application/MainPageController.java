package application;

import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Timer;

import javafx.fxml.Initializable;
import javafx.scene.Node;

public class MainPageController implements Initializable{

	public ActionListener ac;
	
	private Main main;

	public void setMain(Main main) {
		
		this.main = main;
		
	}
	  
	Timer timer;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		}
	
	
	 @FXML
	 private void loadHighScore(ActionEvent event) throws IOException {
		 
		Parent root = FXMLLoader.load(getClass().getResource("HighScoreTesting.fxml"));
		Scene highScore = new Scene(root);
				
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(highScore);
		window.show();
			
			
	    }
	 
	 
	  
	 @FXML
	 private void loadSettings(ActionEvent event) throws IOException {
		 
		 	Parent root = FXMLLoader.load(getClass().getResource("SettingsTest.fxml"));
			Scene settings = new Scene(root);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(settings);
			window.show();
	    }
	 
	 
	 
	 
	  @FXML
	  void startGameButton(ActionEvent event) throws IOException {
		  	Parent root = FXMLLoader.load(getClass().getResource("gametesting.fxml"));
			Scene game = new Scene(root);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(game);
			window.show();
			timer = new Timer(10, ac);
			timer.start();

	    }

}
