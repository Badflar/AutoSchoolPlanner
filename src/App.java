import javax.print.attribute.standard.PrinterMakeAndModel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class App extends Application {
    private TableView assignmentTable = new TableView();

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Assignments & Planner");
        primaryStage.setWidth(300);
        primaryStage.setHeight(500);

        final Label label = new Label("Assignment List");
        label.setFont(new Font("Arial", 20));

        assignmentTable.setEditable(false);

        TableColumn assignmentNameCol = new TableColumn("Assignment Name");
        TableColumn assignmentAssignedDateCol = new TableColumn("Assigned Date");
        TableColumn assignmentDueDateCol = new TableColumn("Due Date");
        TableColumn assignmentEstiamtedHoursOfWorkCol = new TableColumn("Total Time");
        TableColumn assignmentTimeSpentCol = new TableColumn("Time Spent");
        TableColumn AssignmentViewedCol = new TableColumn("Started");

        assignmentTable.getColumns().addAll(assignmentNameCol, assignmentAssignedDateCol, assignmentDueDateCol, assignmentEstiamtedHoursOfWorkCol, assignmentTimeSpentCol, AssignmentViewedCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(label, assignmentTable);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
}
