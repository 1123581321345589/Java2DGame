package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class SettingsController implements Initializable {

	private Main main;

	public void setMain(Main main) {
		
		this.main = main;
		
	}

	  
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	 @FXML
	    void loadMainPage(ActionEvent event) throws IOException {
		 Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
		 Scene MainPage = new Scene(root);
			
		 Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		 window.setScene(MainPage);
		 window.show();
	    }

}
