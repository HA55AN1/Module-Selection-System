package controller;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Block;
import model.Course;
import model.Module;
import model.StudentProfile;
import view.CreateStudentProfilePane;
import view.FinalYearOptionsMenuBar;
import view.FinalYearOptionsRootPane;
import view.OverviewSelectionPane;
import view.ReserveModulesPane;
import view.SelectModulesPane;



public class FinalYearOptionsController {

	//fields to be used throughout class
	private FinalYearOptionsRootPane view;
	private StudentProfile model;
	
	private CreateStudentProfilePane cspp;
	private FinalYearOptionsMenuBar mstmb;
	private SelectModulesPane smp;
	private ReserveModulesPane rmp;
	private OverviewSelectionPane osp;
	
	public FinalYearOptionsController(FinalYearOptionsRootPane view, StudentProfile model) {
		//initialise view and model fields
		this.view = view;
		this.model = model;
		
		//initialise view subcontainer fields
		cspp = view.getCreateStudentProfilePane();
		mstmb = view.getModuleSelectionToolMenuBar();
		smp = view.getSelectModulesPane();
		rmp = view.getReserveModulesPane();
		osp = view.getOverviewSelectionPane();
		
		//add courses to combobox in create student profile pane using the buildModulesAndCourses helper method below
		cspp.addCourseDataToComboBox(buildModulesAndCourses());

		//attach event handlers to view using private helper method
		this.attachEventHandlers();
	}

	
	//helper method - used to attach event handlers
	private void attachEventHandlers() {
		//attach an event handler to the create student profile pane
		cspp.addCreateStudentProfileHandler(new CreateStudentProfileHandler());
		smp.addAddHandler(new addbtnAddHandler());
		smp.addRemoveButtonHandler(new addRemoveButtonHandler());
		smp.addResetButtonHandler(new addResetButtonHandler());
		smp.addSubmitButtonHandler(new addSubmitButtonHandler());
		rmp.addbtnAdd2Handler(new addbtnAdd2Handler());
		rmp.addRemoveButton2Handler(new addRemoveButton2Handler());
		rmp.addConfirmButtonHandler(new addConfirmButtonHandler());
		osp.addSaveOverviewHandler(new addSaveOverviewHandler());
		//attach an event handler to the menu bar that closes the application
		mstmb.addExitHandler(e -> System.exit(0));
	//	mstmb.addLoadHandler(new addLoadHandler());
	//	mstmb.addSaveHandler(new addSaveHandler());
		mstmb.addAboutHandler(e -> this.alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", null, "Student Profile app"));
	}
	
	//event handler (currently empty), which can be used for creating a profile
	private class CreateStudentProfileHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			
			model.setStudentPnumber(view.getCreateStudentProfilePane().getStudentPnumber());
	        model.setStudentCourse(cspp.getSelectedCourse());
	        model.setStudentName(cspp.getStudentName());
	        model.setStudentEmail(cspp.getStudentEmail());
	        model.setSubmissionDate(cspp.getStudentDate());

	        for (Module m : model.getStudentCourse().getAllModulesOnCourse()) {
	        	System.out.println(m);
	        	smp.addModules(m);
	        	
	        	view.changeTab(1);
	        }
		}
	}
	
	private class addResetButtonHandler implements EventHandler<ActionEvent> {
	    
	    public void handle(ActionEvent e) {
	    	smp.setReset();
	    	model.setStudentPnumber(cspp.getStudentPnumber());
	        model.setStudentCourse(cspp.getSelectedCourse());
	        model.setStudentName(cspp.getStudentName());
	        model.setStudentEmail(cspp.getStudentEmail());
	        model.setSubmissionDate(cspp.getStudentDate());

	        for (Module mm : model.getStudentCourse().getAllModulesOnCourse()) {
	        	System.out.println(mm);
	        	smp.addModules(mm);
	        	
	        	view.changeTab(1);
	        }
	    }
	}   
	 private class addRemoveButtonHandler implements EventHandler<ActionEvent> {
		 public void handle(ActionEvent e) {	
		 Module selemod = smp.getModules2();

			if(selemod != null) {
				smp.removefrom(selemod);
				
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("ERROR");
				alert.setContentText("No Modules Selected");
				alert.showAndWait();
			}
		}
	}
	 private class addRemoveButton2Handler implements EventHandler<ActionEvent> {
		 public void handle(ActionEvent e) {	
		 Module selemod = rmp.getModules4();

			if(selemod != null) {
				rmp.removefrom2(selemod);
				
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("ERROR");
				alert.setContentText("No Modules Selected");
				alert.showAndWait();
			}
		}
	}
	private class addbtnAddHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {	
			Module selemod = smp.getModules();

			if(selemod != null) {
				smp.addto(selemod);
				
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("ERROR");
				alert.setContentText("No Modules Selected");
				alert.showAndWait();
			}
		}
	}
	
	private class addbtnAdd2Handler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {	
			Module selemod3 = rmp.getModules3();

			if(selemod3 != null) {
				rmp.addto2(selemod3);
				
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("ERROR");
				alert.setContentText("No Modules Selected");
				alert.showAndWait();
			}
		}
	}
	

	private class addSubmitButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			rmp.unselcmodule(smp.getum34lv());
	        view.changeTab(2);
		}
	}
	
	private class addConfirmButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			
	        view.changeTab(3);
		}
	}

	private void alertDialogBuilder(AlertType type, String title, String header, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	 private class addSaveOverviewHandler implements EventHandler<ActionEvent> {
	        public void handle(ActionEvent e) {
	        	  Platform.exit();
	        }
	 }

	//helper method - builds modules and course data and returns courses within an array
	private Course[] buildModulesAndCourses() {
		Module ctec3701 = new Module("CTEC3701", "Software Development: Methods & Standards", 30, true, Block.BLOCK_1);

		Module ctec3702 = new Module("CTEC3702", "Big Data and Machine Learning", 30, true, Block.BLOCK_2);
		Module ctec3703 = new Module("CTEC3703", "Mobile App Development and Big Data", 30, true, Block.BLOCK_2);

		Module ctec3451 = new Module("CTEC3451", "Development Project", 30, true, Block.BLOCK_3_4);

		Module ctec3704 = new Module("CTEC3704", "Functional Programming", 30, false, Block.BLOCK_3_4);
		Module ctec3705 = new Module("CTEC3705", "Advanced Web Development", 30, false, Block.BLOCK_3_4);

		Module imat3711 = new Module("IMAT3711", "Privacy and Data Protection", 30, false, Block.BLOCK_3_4);
		Module imat3722 = new Module("IMAT3722", "Fuzzy Logic and Inference Systems", 30, false, Block.BLOCK_3_4);

		Module ctec3706 = new Module("CTEC3706", "Embedded Systems and IoT", 30, false, Block.BLOCK_3_4);


		Course compSci = new Course("Computer Science");
		compSci.addModule(ctec3701);
		compSci.addModule(ctec3702);
		compSci.addModule(ctec3451);
		compSci.addModule(ctec3704);
		compSci.addModule(ctec3705);
		compSci.addModule(imat3711);
		compSci.addModule(imat3722);

		Course softEng = new Course("Software Engineering");
		softEng.addModule(ctec3701);
		softEng.addModule(ctec3703);
		softEng.addModule(ctec3451);
		softEng.addModule(ctec3704);
		softEng.addModule(ctec3705);
		softEng.addModule(ctec3706);

		Course[] courses = new Course[2];
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}

}
