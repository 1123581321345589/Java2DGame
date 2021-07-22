package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;




public class gameController implements Initializable{
	
		
	protected MainPageController game;

	public void setGame(MainPageController game) {
		
		this.game = game;
		
	}
	
	protected enemyCollection enemy;

	public void getEnemy(enemyCollection enemy) {
		
		this.enemy = enemy;
		
	}
	
	public int bulletInc = 0;
	
	@FXML
	
	private Button playerShoot; // keyboard input for shooting
	
	 
	@FXML
	
	protected AnchorPane pane; // Window
	
	@FXML
	
	protected Label scoreTracker;
	
	
	@FXML
	
	public Rectangle player;  //User Controlled
	
	@FXML
	
	public Rectangle topBorder;

	@FXML

	public Rectangle bottomBorder;
	

	@FXML
	// Player movement Button cast
	private Button keyboard;  //keyboard input
	
	
	@FXML
	protected Rectangle spawner; // when crossed, spawns another Enemy
	
	@FXML
	protected Rectangle spawnBox; // spawn location
	
	public List<Shape> targets = createEnemys();
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//playerShoot.requestFocus();
	
		
		
		pane.getChildren().addAll(targets);
		
		
		//pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
		//	@Override
		//	public void handle(KeyEvent event) {
		//	if(event.getCode() == KeyCode.SPACE) {
				
		//		projectile(player, pane, targets);
		//	}
	        
	    //}
	//});	
		
				
			
		
			
		}
	
	
	
	
	
	/*@FXML
	protected void checkCollisions() {
	   
		StringBuilder em = new StringBuilder();
		StringBuilder bu = new StringBuilder();
		
		for(int i = 0; i < 100; ++i) {
			em.append(i);
				//pane.lookup(em.toString());
			
				//pane.getChildren().get(pane.getChildren().size() - (i + 1)).getBoundsInParent();
				
				for(int x = 1; x <= 101 +bulletInc; ++x) {
					//bu.append(x);
					
					if(pane.getChildren().remove(pane.getChildren().size() - (i + 1)).getBoundsInParent().contains(pane.getChildren().remove(pane.getChildren().size() - (x - 1)).getBoundsInParent())){      
							
							
							
						pane.getChildren().remove(pane.getChildren().size() - (i + 1));
							
						pane.getChildren().remove(pane.getChildren().size() - (x));
							
						//((pane.lookup(em.toString()).intersects(pane.lookup(bu.toString()).getBoundsInParent())))
							
						}
					
					}
		
		
		}
	}
	
	*/
	
	
	
	
		
	
	 @FXML
	 public void playerMovement(KeyEvent event) {
		 
		 playerShoot.requestFocus();
		 keyboard.requestFocus();
		 
		 if(event.getCode() == KeyCode.W) {
			 if(player.getLayoutY() - 10 > topBorder.getHeight() )
			 player.setLayoutY(player.getLayoutY() - 10);
			 
		 	}
		 else if(event.getCode() == KeyCode.S) {
			 if(player.getLayoutY() + 10 < bottomBorder.getLayoutY() - player.getHeight())
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
			 	
				++bulletInc;

		  	}
		
		 else if (event.getCode() == KeyCode.E) {
			 
			 
			 
			 
			 
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
	  
	  
	  public List<Shape> createEnemys() {
			
			List<Shape> enemys = new ArrayList<>();
			
			double startX = 1863;
			double startY = 120;
			
			double xInc = 45;
			double yInc = 45;
			double gruntId = 1;
			
			StringBuilder sb = new StringBuilder();
			
			for(int x = 0; x < 5; ++x) {
				
				startX = startX + xInc;
				
				
				for(int i = 0 ; i < 19; ++i) {
				
					Rectangle grunt = new Rectangle();
					
					grunt.setHeight(30);
					grunt.setWidth(30);
					grunt.setFill(javafx.scene.paint.Color.RED);
					grunt.setLayoutX(startX);
					grunt.setLayoutY(startY);
					enemys.add(grunt);
					
					sb.append(gruntId);
					grunt.setId(sb.toString());
					sb.delete(0, 100);
				
					startY = startY + yInc;
				
					final Timeline timeline = new Timeline();
					timeline.setCycleCount(1);
					timeline.setAutoReverse(false);
					final KeyValue kv = new KeyValue(grunt.xProperty(), -1920);
					final KeyFrame kf = new KeyFrame(Duration.seconds(45), kv);
				
					
					timeline.getKeyFrames().add(kf);
					timeline.play();
					
					
					
					
					}
				
				startY = 120;
			
			}
			
			return enemys ;
			

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
																	//Creates base Grunt Unit
			
		/*	Rectangle grunt = new Rectangle();
			grunt.setHeight(30);
			grunt.setWidth(30);
			grunt.setFill(javafx.scene.paint.Color.RED);
			grunt.setLayoutX(1863);
			grunt.setLayoutY(33);
			
																	//Code of the generic Path
			Path path = new Path();
		
			path.getElements().add(new MoveTo(1863,33));	    
		    
		    
		    														//Start Coordinates
		    double startX = -15;
		    double endX = -115;
		    														//Loop's rest of enemy path
		    
		   
		    
		    
		    
		    for(int i = 0; i <= 6 ; ++i) {
		    	
		    	path.getElements().add(new LineTo(startX, 10));
		    	path.getElements().add(new LineTo(startX, 1000));
		    	path.getElements().add(new LineTo(endX, 1000));
		    	path.getElements().add(new LineTo(endX, 10));
		    	path.getElements().add(new LineTo(endX - 100, 10));
		    	
		    	startX = endX - 200;
		    	endX = endX - 300;
		    	
		 
		    	
		    	
		    }
		   													//Adds path to grunt unit
		    PathTransition pathT = new PathTransition();
		      
		    pathT.setDuration(Duration.seconds(45));
		    pathT.setPath(path);
		    pathT.setNode(grunt);
		    pathT.setCycleCount(1);
		    pathT.setAutoReverse(false);
		    pathT.play();
		    x = grunt.getTranslateX();
		    y = grunt.getTranslateY(); 
		   
		    
		   
		    pane.getChildren().add(grunt);
		
		  	
			*/
		}
		

		public void projectile(Rectangle player, AnchorPane pane, final List<Shape> enemys ){
			
			
			
			Rectangle bullet = new Rectangle();
			bullet.setHeight(8);
			bullet.setWidth(20);
			bullet.setFill(javafx.scene.paint.Color.BLACK);
			pane.getChildren().add(bullet);
			
			//bullet.setLayoutX(player.getLayoutX() + (player.getWidth() / 2));
			//bullet.setLayoutY(player.getLayoutY() + (player.getHeight() / 2));
			
			final TranslateTransition bulletPath =  new TranslateTransition(Duration.seconds(1), bullet);
			bulletPath.setFromX(player.getLayoutX() + (player.getWidth() / 2));
			bulletPath.setFromY(player.getLayoutY() + (player.getHeight() / 2));
			
			bulletPath.setToX(1920);
			bulletPath.setToY(player.getLayoutY() + (player.getHeight() / 2));
			//final Timeline timeline = new Timeline();
			//timeline.setCycleCount(1);
			//timeline.setAutoReverse(false);
			//final KeyValue kv = new KeyValue(bullet.xProperty(), 1920);
			//final KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);
			
			//timeline.getKeyFrames().add(kf);
			
			
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
		
	

		
			
			
		
			


		
		
		
		
		
		


	  
	  
	  
	  
	  
	  
	  
	  

