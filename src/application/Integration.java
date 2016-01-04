package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Integration extends Stage {

	
	private Stage primaryStage;
	private Popup poppi;

	public Integration(Stage owner) {

		this.primaryStage = primaryStage;
		
		setResizable(false);
        initModality(Modality.APPLICATION_MODAL);
        initStyle(StageStyle.DECORATED);
 
        Label label = new Label("hello");
        label.setWrapText(true);
        label.setGraphicTextGap(20);
 
        Button button = new Button("OK");
        button.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				Integration.this.close();
			}
		});
 
        BorderPane borderPane = new BorderPane();
//        borderPane.getStylesheets().add(getClass().getResource("alert.css").toExternalForm());        
        borderPane.setTop(label);
 
        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().add(button);
        borderPane.setBottom(hbox2);
 
        // calculate width of string
		final Text text = new Text("hello");
		text.snapshot(null, null);
		// + 20 because there is padding 10 left and right
	    int width = (int) text.getLayoutBounds().getWidth() + 40;
 
        width = 300;
 
        int height = 100;
 
        final Scene scene = new Scene(borderPane, width, height);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
 
        // make sure this stage is centered on top of its owner
		setX(owner.getX() + (owner.getWidth() / 2 - width / 2));
		setY(owner.getY() + (owner.getHeight() / 2 - height / 2));
		
	}
	
	public void runner()
	{
		System.out.println("call from JS");
		this.showAndWait();
	}
}
