package application;
	
import java.io.File;

import netscape.javascript.JSObject;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.fxml.FXMLLoader;




public class Main extends Application {
	public void start(final Stage primaryStage) {
		try {
//			BorderPane root = new BorderPane();

			WebView webView = new WebView();
//			webView.getEngine().load("C:\\Users\\seb\\Documents\\html5\\myWebsite\\index.html");
//			String path = "C:"+File.separator+"Users"+File.separator+"seb"+File.separator+"Documents"+File.separator+"html5"+File.separator+"myWebsite"+File.separator+"index.html";
			String path = "F:\\users\\seb\\Documents\\html5\\myWebsite\\index.html";
//			String path = "F:\\users\\seb\\Documents\\html5\\myPresentation\\index.html";
			File f = new File(path);
			
			
			final WebEngine engine = webView.getEngine();
			
			engine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {

				public void changed(ObservableValue observable, State oldValue,
						State newValue) {
					if(newValue == State.SUCCEEDED)
					{
						//call stuff on the webpage.
//						engine.executeScript("document.body.style.background='RED';");
						JSObject window = (JSObject) engine.executeScript("window");
						window.setMember("javaIntegration", new Integration(primaryStage));
						
					}
					
				}
			});
			
			
			webView.getEngine().load(f.toURI().toString());
//			webView.getEngine().load("file:"+path);
//			webView.getEngine().load("http://www.google.se");
			
			Scene scene = new Scene(webView,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
