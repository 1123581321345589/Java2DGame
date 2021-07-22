package application;

import javafx.animation.Animation;

import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;

import javax.swing.Timer;

import com.sun.glass.events.WindowEvent;


import javafx.scene.shape.Rectangle;

import javafx.fxml.Initializable;

public class gameController implements Initializable{
	
	
	protected MainPageController game;

	public void setGame(MainPageController game) {
		
		this.game = game;
		
	}
	
	private Main start;

	public void setMain(Main start) {
		
		this.start = start;
		
	}
	
   @FXML 
	
	Rectangle grunt;  // Base enemy class
	
	protected enemyCollection grunte;

	public void setGrunte(enemyCollection grunte) {
		
		this.grunte = grunte;
		
	}
	
	protected enemyCollection pathT;

	public void setPath(enemyCollection pathT) {
		
		this.pathT = pathT;
		
	}
	
	@FXML
	
	private Button playerShoot; // keyboard input for shooting
	
	 
	@FXML
	
	protected AnchorPane pane; // Window
	
	@FXML
	
	public Rectangle player;  //User Controlled 
	

	@FXML
	// Player movement Button cast
	private Button keyboard;  //keyboard input
	
	
	/* @FXML 
	
	Rectangle grunt;  // Base enemy class */

	
	@FXML
	
	private Rectangle spawner; // when crossed, spawns another Enemy
	
	@FXML
	protected Rectangle spawnBox; // spawn location
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		new enemyCollection(grunt, spawnBox, pane);
		
	}

	
	
//calling this in initalize causes screen to not open. Where should call?
	 public void enemyMovement(enemyCollection cTime) {
		 
		 enemyCollection em = new enemyCollection(grunt, pane, grunt);
		 
		 
		

			
	//	new enemyCollection(grunt, spawnBox, pane);
		 	
	}
	
	
	
	 @FXML
	 public void playerMovement(KeyEvent event) {
		 
		 playerShoot.requestFocus();
		 keyboard.requestFocus();
		 
		 if(event.getCode() == KeyCode.W) {
			 if(player.getLayoutY() - 10 > 0)
			 player.setLayoutY(player.getLayoutY() - 10);
			 
		 	}
		 else if(event.getCode() == KeyCode.S) {
			 if(player.getLayoutY() + 10 < 1080 - player.getHeight())
			 player.setLayoutY(player.getLayoutY() + 10);
			 
		 	}
		 else if(event.getCode() == KeyCode.A) {
			 if(player.getLayoutX() - 10 > 0)
			 player.setLayoutX(player.getLayoutX() - 10);
			 
		 	}
		 else if(event.getCode() == KeyCode.D) {
			 if(player.getLayoutX() + 10 < 442)
			 player.setLayoutX(player.getLayoutX() + 10);
			 
		 	}
		 else if(event.getCode() == KeyCode.SPACE) {
				 
			 	
			 	playerShooting(event);
				

		  	}
		
		 else if (event.getCode() == KeyCode.E) {
			 
			 
			 new enemyCollection(grunt, spawnBox, pane);
			 
			 
		 }
		 
		 
		 
	    }
	 
	 
	 
	  @FXML
	  public void playerShooting(KeyEvent event) {
		 ;
		  
		  playerShoot.requestFocus();
		  
		 
		  
		  if(event.getCode() == KeyCode.SPACE) {
				 
			 	
			 	new projectile(player, pane);
				

		  	}
		  else if(event.getCode() == KeyCode.W) {
				 playerMovement(event);
			 	}
		  else if(event.getCode() == KeyCode.S) {
			  playerMovement(event);
				 
			 	}
		  else if(event.getCode() == KeyCode.A) {
			  playerMovement(event);
				 
			 	}
		  else if(event.getCode() == KeyCode.D) {
			  playerMovement(event);
			 	}
				  

	
	
	}
	  
	  
	  
	  
	  
	  
}
