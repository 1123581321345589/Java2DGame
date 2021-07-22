package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;




public class gameController implements Initializable{
	
		
	protected MainPageController game;

	public void setGame(MainPageController game) {
		
		this.game = game;
		
	}
	
	@FXML
	private Button keyboard;  // Player movement Button cast
	
	@FXML
	private Button exitGame; // returns to main menu
	
	@FXML
	private Button playerShoot; // keyboard input for shooting
	
	@FXML
	private Button pauseButton; // keyboard input for pause
	
	@FXML
	protected Label scoreTracker; //HighScore tracker
	
	@FXML
	public Rectangle player;  //User Controlled
	
	@FXML
	public Rectangle topBorder; //Top Border of Playable Window

	@FXML
	public Rectangle bottomBorder;// Bottom Border of Playable Window
	
	@FXML
	protected Rectangle spawner; // when crossed, spawns another Enemy
	
	@FXML
	protected Rectangle spawnBox; // spawn location
	
	@FXML
	protected Pane pauseMenu; // pause menu
	
	@FXML
	protected AnchorPane pane; // Window
	
	public List<Shape> targets = createEnemys(); // list of created Enemies
	
	@FXML
	public Timeline pause;
	
	
	
	
	
	
	@Override //Actions on Open
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
		//Spawns Target List
		
		pane.getChildren().addAll(targets);
		
		

			
		}
	@FXML
	//Pause Menu
	public void pauseGame(KeyEvent event) {
		
		exitGame.requestFocus();
		
		if(event.getCode() == KeyCode.ESCAPE) {
			
			pauseMenu.setVisible(true);
			
			
				
			}
			
		}
		
		
		
		
	 @FXML
	 private void loadMainPage(ActionEvent event) throws IOException {
		 
		 	Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
			Scene main = new Scene(root);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(main);
			window.show();
	    }
	
	
	
	 @FXML	
	 //basic player movement
	 public void playerMovement(KeyEvent event) {
		 
		 playerShoot.requestFocus();
		 keyboard.requestFocus();
		 
		 if(event.getCode() == KeyCode.W) {
			 if(player.getLayoutY() - 20 > topBorder.getHeight() )
			 player.setLayoutY(player.getLayoutY() - 20);
			 
		 	}
		 else if(event.getCode() == KeyCode.S) {
			 if(player.getLayoutY() + 20 < bottomBorder.getLayoutY() - player.getHeight())
			 player.setLayoutY(player.getLayoutY() + 20);
			 
		 	}
		 else if(event.getCode() == KeyCode.A) {
			 if(player.getLayoutX() - 20 > 0)
			 player.setLayoutX(player.getLayoutX() - 20);
			 
		 	}
		 else if(event.getCode() == KeyCode.D) {
			 if(player.getLayoutX() + 20 < 442)
			 player.setLayoutX(player.getLayoutX() + 20);
			 
		 	}
		 else if(event.getCode() == KeyCode.SPACE) {
				 
			 	playerShooting(event);
			 	
		  	}
		 else if(event.getCode() == KeyCode.ESCAPE) {
			 
			 pauseGame(event);
			 
		 }
	    }
	 
	 
	 
	  @FXML
	  public void playerShooting(KeyEvent event) {
		 ;
		  
		  playerShoot.requestFocus();
		  
		 
		  
		  if(event.getCode() == KeyCode.SPACE) {
			  
			 	projectile(player, pane, targets);
				
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
	  
	  //Enemy List, creates instances of Enemies, returns said List
	  
	  public List<Shape> createEnemys() {
			
		  
		  	//ArrayList of Enemy units to be tracked
		  
			List<Shape> enemys = new ArrayList<>();
			
			
			double startX = 1863;	//Start X and Y of Enemy Unit
			double startY = 120;
			
			double xInc = 45;      //Values at which both X and Y are incremented
			double yInc = 45;
			
			
			StringBuilder sb = new StringBuilder();
		
			for(int x = 0; x < 5; ++x) { // Loop in which Columns of enemy units are created
				
				startX = startX + xInc;
				
				
				for(int i = 0 ; i < 19; ++i) { // Loop in which Rows of enemy units are created
				
					Rectangle grunt = new Rectangle();
					grunt.setHeight(30);
					grunt.setWidth(30);
					grunt.setFill(javafx.scene.paint.Color.RED); //Base Enemy Unit
					
					
					grunt.setLayoutX(startX); 
					grunt.setLayoutY(startY);
					
					enemys.add(grunt); //adds Enemy to ArrayList
				
					startY = startY + yInc;
				
					Timeline timeline = new Timeline(); //Path in which enemies follow
					timeline.setCycleCount(1);
					timeline.setAutoReverse(false);
					final KeyValue kv = new KeyValue(grunt.xProperty(), -1920);
					final KeyFrame kf = new KeyFrame(Duration.seconds(45), kv);
				
					
					timeline.getKeyFrames().add(kf);
					
					timeline.play();
					
					this.pause = timeline;
					
					
					
					
					}
				
				startY = 120; //resets starting Y value to begin new Column
			
			}
			
			return enemys ;
			

			
		
		}
		
	  	//User Shooting Method
	  	//Parameters: player = User Sprite, pane = Game Window, enemys = List of Enemies
	  	//No Return
	  	
		public void projectile(Rectangle player, AnchorPane pane, final List<Shape> enemys ){
			
			
			
			Rectangle bullet = new Rectangle(); //Creation of User Projectile
			bullet.setHeight(8);
			bullet.setWidth(20);
			bullet.setFill(javafx.scene.paint.Color.BLACK);
			pane.getChildren().add(bullet);
			
			
			final TranslateTransition bulletPath =  new TranslateTransition(Duration.seconds(2), bullet); //Path of user projectile
			bulletPath.setFromX(player.getLayoutX() + (player.getWidth() / 2));
			bulletPath.setFromY(player.getLayoutY() + (player.getHeight() / 2));
			bulletPath.setToX(1920);
			bulletPath.setToY(player.getLayoutY() + (player.getHeight() / 2));
			
			
			//Process in which Bullet collision is detected
			//Results in removal of instance of bullet when it collides with an instance of an Enemy within Enemys List
			 bullet.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
		            @Override
		            public void changed(ObservableValue<? extends Bounds> observable,
		                    Bounds oldValue, Bounds newValue) {
		                for (final Shape target : new ArrayList<Shape>(enemys)) {
		               
		                    if (((Path)Shape.intersect(bullet, target)).getElements().size() > 0) {
		                        
		                        enemys.remove(target);
		                        pane.getChildren().remove(target);
		                        bulletPath.stop();
		                        pane.getChildren().remove(bullet);
		                        
		                    }
		                }
		            }
		        });
			bulletPath.setOnFinished(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
	                pane.getChildren().remove(bullet);
	            }
	        });
				
				bulletPath.play();
				
			}
			
			
			
		

		}
		
	

		
			
			
		
			


		
		
		
		
		
		


	  
	  
	  
	  
	  
	  
	  
	  

