package application;




import java.util.Timer;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;



public class enemyCollection extends gameController{

	@FXML
	private Rectangle grunte;
	
	public Status status;
	
	public double x;
	
	public double y;
	
	public Timer cTime;

	public enemyCollection(Rectangle grunt, Rectangle spawnBox, AnchorPane pane) {
																//Creates base Grunt Unit
		Rectangle grunte = new Rectangle();
		grunte.setHeight(30);
		grunte.setWidth(30);
		grunte.setFill(javafx.scene.paint.Color.RED);
		grunte.setLayoutX(1863);
		grunte.setLayoutY(33);
		
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
	    	
	 // path.addEventHandler(eventType, eventHandler); //may be useful
	    	
	    	
	    }
	   													//Adds path to grunt unit
	    PathTransition pathT = new PathTransition();
	      
	    pathT.setDuration(Duration.seconds(15));
	    pathT.setPath(path);
	    pathT.setNode(grunte);
	    pathT.setCycleCount(Animation.INDEFINITE);
	    pathT.setAutoReverse(false);
	    pathT.play();
	    status = pathT.getStatus();
	    cTime = new Timer();
	    x = grunte.getTranslateX();
	    y = grunte.getTranslateY(); 
	   
	   
	    pane.getChildren().add(grunte);
	  /*  
	  if(cTime.toSeconds() % 3 == 0) {
		  enemyMovement(this);
	  }
		*/
		
		
	}
	public enemyCollection(Rectangle grunt, AnchorPane pane, Rectangle spawner) {
		if(spawner.getBoundsInParent().contains(grunte.getTranslateX(), grunte.getTranslateY())) {
			
			new enemyCollection(grunt, spawnBox, pane);
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
}
