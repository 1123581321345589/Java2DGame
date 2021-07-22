package application;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;



public class enemyCollection extends gameController{

	@FXML
	protected Rectangle grunt;

	public double x;
	
	public double y;
	
	
	
	

	private List<Shape> createEnemys(Rectangle spawnBox, AnchorPane pane) {
		
		List<Shape> enemys = new ArrayList<>();
		
		
		
		double startX = 1863;
		double startY = 20;
		
		
		
		
		double xInc = 45;
		double yInc = 45;
		double gruntId = 1;
		
		StringBuilder sb = new StringBuilder();
		
		for(int x = 0; x < 5; ++x) {
			
			startX = startX + xInc;
			
			
			for(int i = 0 ; i < 20; ++i) {
			
				Rectangle grunt = new Rectangle();
				
				grunt.setHeight(30);
				grunt.setWidth(30);
				grunt.setFill(javafx.scene.paint.Color.RED);
				grunt.setLayoutX(startX);
				grunt.setLayoutY(startY);
				
				sb.append(gruntId);
				grunt.setId(sb.toString());
				sb.delete(0, 100);
			
				startY = startY + yInc;
			
				final Timeline timeline = new Timeline();
				timeline.setCycleCount(1);
				timeline.setAutoReverse(false);
				final KeyValue kv = new KeyValue(grunt.xProperty(), -1920);
				final KeyFrame kf = new KeyFrame(Duration.seconds(10), kv);
			
				pane.getChildren().add(grunt);
				timeline.getKeyFrames().add(kf);
				timeline.play();
				
				++gruntId;
				}
			enemys.add(grunt);
			startY = 20;
		
		}
		
		return enemys;
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		
		StringBuilder sb = new StringBuilder();
		int bulletId = 1000;
		
		Rectangle bullet = new Rectangle();
		
		bullet.setHeight(8);
		bullet.setWidth(20);
		bullet.setFill(javafx.scene.paint.Color.BLACK);
		
		sb.append(bulletId);
		bullet.setId(sb.toString());
		sb.delete(0, 10000);
		++bulletId;
		
		bullet.setLayoutX(player.getLayoutX() + (player.getWidth() / 2));
		bullet.setLayoutY(player.getLayoutY() + (player.getHeight() / 2));
		
		
		final Timeline timeline = new Timeline();
		timeline.setCycleCount(1);
		timeline.setAutoReverse(false);
		final KeyValue kv = new KeyValue(bullet.xProperty(), 1920);
		final KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);
		
		pane.getChildren().add(bullet);
		timeline.getKeyFrames().add(kf);
		timeline.play();
		
		 bullet.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
	            @Override
	            public void changed(ObservableValue<? extends Bounds> observable,
	                    Bounds oldValue, Bounds newValue) {
	                for (final Shape target : new ArrayList<Shape>(enemys)) {
	                    if (((Path)Shape.intersect(bullet, target)).getElements().size() > 0) {
	                        System.out.println("Hit!");
	                        enemys.remove(target);
	                        pane.getChildren().remove(grunt);
	                        timeline.stop();
	                        pane.getChildren().remove(bullet);
	                    }
	                }
	            }
	        });
		
		
		
		
	

	}
	
}

	
		
		
	
		


	
	
	
	
	
	

