package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.shape.Rectangle;

import javafx.fxml.Initializable;
import javafx.scene.Node;

public class projectile extends gameController {
	
	
	public projectile(Rectangle player, AnchorPane pane){
		
		
		Rectangle bullet = new Rectangle();
		bullet.setHeight(8);
		bullet.setWidth(20);
		bullet.setFill(javafx.scene.paint.Color.BLACK);
		
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
