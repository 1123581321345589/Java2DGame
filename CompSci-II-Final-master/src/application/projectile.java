package application;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;

public class projectile extends gameController {
	
	
	
	protected enemyCollection enemy;

	public void setGame(enemyCollection enemy) {
		
		this.enemy = enemy;
		
	}
	
	
	public projectile(Rectangle player, AnchorPane pane){
		
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
		
		
		
	

	}
	
}


	
