package view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Block;
import model.Course;
import model.Module;

public class SelectModulesPane extends GridPane {

	private Label  m1l, m2l, um34l, m34l, b34l, cl;
	private ListView<Module> m1lv, m2lv, um34lv, m34lv;
	private Button btnAdd, btnRemove, btnReset, btnSubmit;
	private TextField counter;
	private VBox vbox1, vbox2;
	private HBox hbox1, hbox2, hbox3;
	
	 
    public SelectModulesPane() {
    	
        this.setVgap(15);
        this.setHgap(20);
        this.setAlignment(Pos.CENTER);

        ColumnConstraints column0 = new ColumnConstraints();
        column0.setHalignment(HPos.LEFT);
        this.getColumnConstraints().addAll(column0);
	
        m1l = new Label(" Selected Block 1 Modules:");
        m2l = new Label(" Selected Block 2 Modules:");
        m34l = new Label(" Selected Block 3/4 Modules:");
        um34l = new Label(" Unselected Block 3/4 Modules:");
        b34l = new Label("Block 3/4:");
        cl = new Label("Current Counter:");
	
        m1lv = new ListView<Module>();
        m1lv.setPrefSize(100, 300);
        m2lv = new ListView<Module>();
        m2lv.setPrefSize(100, 300);
        m34lv = new ListView<Module>();
        m34lv.setPrefSize(100, 300);
        um34lv = new ListView<Module>();
        um34lv.setPrefSize(100, 300);
        
        counter = new TextField("90");
        counter.setEditable(false);
        
        btnAdd = new Button("Add");
        btnRemove = new Button("Remove");
        btnReset = new Button("Reset");
        btnSubmit = new Button("Submit");
        
        
        
        vbox1 = new VBox(m1l, m1lv, m2l, m2lv);
        this.add(vbox1, 0, 0);
        vbox1.setAlignment(Pos.TOP_LEFT);
        vbox1.setSpacing(10);
        GridPane.setHgrow(vbox1, Priority.ALWAYS);
        GridPane.setVgrow(vbox1, Priority.ALWAYS);
        
        hbox1 = new HBox(b34l, btnAdd, btnRemove);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(10);
        GridPane.setHgrow(hbox1, Priority.ALWAYS);
        GridPane.setVgrow(hbox1, Priority.ALWAYS);
        
        vbox2 = new VBox(um34l, um34lv, hbox1, m34l, m34lv);
        this.add(vbox2, 1, 0);
        vbox2.setAlignment(Pos.TOP_LEFT);
        vbox2.setSpacing(10);
        GridPane.setHgrow(vbox2, Priority.ALWAYS);
        GridPane.setVgrow(vbox2, Priority.ALWAYS);
        
        hbox2 = new HBox(cl, counter);
        this.add(hbox2, 0, 2);
        hbox2.setAlignment(Pos.TOP_RIGHT);
        hbox2.setSpacing(10);
        GridPane.setHgrow(hbox2, Priority.ALWAYS);
        GridPane.setVgrow(hbox2, Priority.ALWAYS);
       
        hbox3 = new HBox(btnReset, btnSubmit);
        this.add(hbox3, 0, 4);
        hbox3.setAlignment(Pos.TOP_RIGHT);
        hbox3.setSpacing(10);
        GridPane.setHgrow(hbox3, Priority.ALWAYS);
        GridPane.setVgrow(hbox3, Priority.ALWAYS);
        }
    
   
   

    public void addAddHandler(EventHandler<ActionEvent> handler) {
        btnAdd.setOnAction(handler);
    }

        public void addResetButtonHandler(EventHandler<ActionEvent>handler) {
        	btnReset.setOnAction(handler);
	    }
        public void addRemoveButtonHandler(EventHandler<ActionEvent>handler) {
        	btnRemove.setOnAction(handler);
	    }
        public void addSubmitButtonHandler(EventHandler<ActionEvent>handler) {
        	btnSubmit.setOnAction(handler);
	    }
        public Module getm34lv() {
    		return m34lv.getSelectionModel().getSelectedItem();
    	}
        public ListView<Module> getum34lv() {
    		return um34lv;
    	}
        
        public void addModules(Module modules) {
        	if(modules.isMandatory() && modules.getRunPlan() == Block.BLOCK_1){
        		m1lv.getItems().add(modules);
        	} else if (modules.isMandatory()&& modules.getRunPlan() == Block.BLOCK_2) {
        		m2lv.getItems().add(modules);
        		} else if (!modules.isMandatory() && modules.getRunPlan() == Block.BLOCK_3_4) {
        			um34lv.getItems().add(modules);
        			} else m34lv.getItems().add(modules);
        }
        
        private Course sl;
        public void setCourse(Course course) {
        	sl = course;	
        	m1lv.getItems().clear();
        	m2lv.getItems().clear();
        	um34lv.getItems().clear();
        	m34lv.getItems().clear();
        }
        
        

		public void addto(Module modules) {
if (modules != null) {
	m34lv.getItems().add(modules);
	um34lv.getItems().remove(modules);
}
		}

		public Module getModules() {
			return um34lv.selectionModelProperty().get().getSelectedItem();
		}
		public Module getModules2() {
			return m34lv.selectionModelProperty().get().getSelectedItem();
		}
		public void removefrom(Module modules) {
			if (modules != null) {
				m34lv.getItems().remove(modules);
				um34lv.getItems().add(modules);
			}
		}
		
		 public void clearBlockM34lv() {
		        int selectedCount = m34lv.getSelectionModel().getSelectedItems().size();

		        if (selectedCount > 1) {
		            ObservableList<Module> selectedItems = m34lv.getSelectionModel().getSelectedItems();
		            Module fstmodule = selectedItems.get(0);

		            m34lv.getItems().clear();
		            m34lv.getItems().add(fstmodule);
		        }
		    }
		
		public void setReset() {
			setCourse(sl);
		}
		
}   

