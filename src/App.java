import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class App extends Application {
    private UIAssemblyHelper uiAssemblyHelper = new UIAssemblyHelper();
    private TableView assignmentTable = new TableView();
    private TableView todayTable = new TableView();

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Assignments & Planner");
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);

        VBox assigmentTableVBox = uiAssemblyHelper.assignmentTableMaker(assignmentTable);
        VBox todayTableVBox = uiAssemblyHelper.todayTableMaker(todayTable);

        final HBox elements = new HBox();
        elements.setSpacing(5);
        elements.setPadding(new Insets(20,0,0,20));
        elements.getChildren().addAll(assigmentTableVBox, todayTableVBox);

        ((Group) scene.getRoot()).getChildren().addAll(elements);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
}
