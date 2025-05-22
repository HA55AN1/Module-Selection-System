package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class OverviewSelectionPane extends GridPane {

	private TextArea spta, smta, rmta;
	private Button btnSaveOverview;
	private VBox vbox1, vbox2;
	private HBox hbox1;
	
	  public OverviewSelectionPane() {
	        this.setVgap(20);
	        this.setHgap(20);
	        this.setAlignment(Pos.CENTER);

	        ColumnConstraints column0 = new ColumnConstraints();
	        column0.setHalignment(HPos.LEFT);
	        this.getColumnConstraints().addAll(column0);
		
	        spta = new TextArea("Profile will appear here");
	        spta.setPrefSize(500, 200);
	        spta.setEditable(false);
	        smta = new TextArea("Selected Modules will appear here");
	        smta.setPrefSize(800, 300);
	        smta.setEditable(false);
	        rmta = new TextArea("Reserved Modules will appear here");
	        rmta.setPrefSize(800, 300);
	        rmta.setEditable(false);
	        
	        btnSaveOverview = new Button("Save Overview");
	
	        vbox1 = new VBox(spta);
	        this.add(vbox1, 0, 0);
	        vbox1.setAlignment(Pos.CENTER);
	        vbox1.setSpacing(20);
	        GridPane.setHgrow(vbox1, Priority.ALWAYS);
	        GridPane.setVgrow(vbox1, Priority.ALWAYS);
	
	        hbox1 = new HBox(smta, rmta);
	        this.add(hbox1, 0, 2);
	        hbox1.setAlignment(Pos.CENTER);
	        hbox1.setSpacing(10);
	        GridPane.setHgrow(hbox1, Priority.ALWAYS);
	        GridPane.setVgrow(hbox1, Priority.ALWAYS);
	
	        vbox2 = new VBox(btnSaveOverview);
	        this.add(vbox2, 0, 3);
	        vbox2.setAlignment(Pos.CENTER);
	        vbox2.setSpacing(20);
	        GridPane.setHgrow(vbox2, Priority.ALWAYS);
	        GridPane.setVgrow(vbox2, Priority.ALWAYS);
	
 }
	  public void addSaveOverviewHandler(EventHandler<ActionEvent>handler) {
		  btnSaveOverview.setOnAction(handler);
	    }
}
