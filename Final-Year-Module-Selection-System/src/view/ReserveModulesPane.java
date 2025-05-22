package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Module;

public class ReserveModulesPane extends GridPane {
	
	private Label rum34l, rsm34l, oom;
	private ListView<Module> rum34lv, rsm34lv;
    private Button btnAdd, btnRemove, btnConfirm;
    private VBox vbox1, vbox2;
    private HBox hbox1;
	
    public ReserveModulesPane() {
        this.setVgap(20);
        this.setHgap(20);
        this.setAlignment(Pos.CENTER);

        ColumnConstraints column0 = new ColumnConstraints();
        column0.setHalignment(HPos.LEFT);
        this.getColumnConstraints().addAll(column0);
	
        rum34l = new Label("Unselected Block 3/4 Modules:");
        rsm34l = new Label("Reserved Block 3/4 Modules:");
        oom = new Label("Reserved one optional modules:");
        
        rum34lv = new ListView<Module>();
        rum34lv.setPrefSize(400, 500);
        rsm34lv = new ListView<Module>();
        rsm34lv.setPrefSize(400, 500);
        
        btnAdd = new Button("Add");
        btnRemove = new Button("Remove");
        btnConfirm = new Button("Confirm");
        
        vbox1 = new VBox(rum34l, rum34lv);
        this.add(vbox1, 0, 0);
        vbox1.setAlignment(Pos.TOP_LEFT);
        vbox1.setSpacing(10);
        GridPane.setHgrow(vbox1, Priority.ALWAYS);
        GridPane.setVgrow(vbox1, Priority.ALWAYS);
        
        vbox2 = new VBox(rsm34l, rsm34lv);
        this.add(vbox2, 1, 0);
        vbox2.setAlignment(Pos.TOP_LEFT);
        vbox2.setSpacing(10);
        GridPane.setHgrow(vbox2, Priority.ALWAYS);
        GridPane.setVgrow(vbox2, Priority.ALWAYS);
        
        hbox1 = new HBox(oom, btnAdd, btnRemove, btnConfirm);
        this.add(hbox1, 0, 1);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(10);
        GridPane.setHgrow(hbox1, Priority.ALWAYS);
        GridPane.setVgrow(hbox1, Priority.ALWAYS);
    }
    
    public void addbtnAdd2Handler(EventHandler<ActionEvent> handler) {
        btnAdd.setOnAction(handler);
    }

        
    public void addRemoveButton2Handler(EventHandler<ActionEvent>handler) {
    	btnRemove.setOnAction(handler);
    }

    public void addConfirmButtonHandler(EventHandler<ActionEvent>handler) {
    	btnConfirm.setOnAction(handler);
    }
    
    public void unselcmodule(ListView<Module> modules) {
    	rum34lv.getItems().clear();
    	rum34lv.getItems().addAll(modules.getItems());
    }
	    public Module getModules3() {
			return rum34lv.selectionModelProperty().get().getSelectedItem();
	    }

	    public void addto2(Module modules) {
	    	if (modules != null) {
	    		rsm34lv.getItems().add(modules);
	    		rum34lv.getItems().remove(modules);
	    
	    	}
	    }
	    public Module getModules4() {
			return rsm34lv.selectionModelProperty().get().getSelectedItem();
		}
	    public void removefrom2(Module modules) {
			if (modules != null) {
				rsm34lv.getItems().remove(modules);
				rum34lv.getItems().add(modules);
			}
	}
	    
}
