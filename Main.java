package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;



public class Main extends Application {
	@Override
	public void start(Stage primarystage) {
		
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			Image icon = new Image("icon.png");
			primarystage.getIcons().add(icon);
			primarystage.setTitle("KURT AIRLINES");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primarystage.setScene(scene);
			primarystage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
