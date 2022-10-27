import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class UIAssemblyHelper {
    

    public VBox assignmentTableMaker(TableView assignmentTable) {
        final Label labelAssignments = new Label("Assignment List");
        labelAssignments.setFont(new Font("Arial", 20));

        assignmentTable.setEditable(false);


        TableColumn assignmentNameCol = new TableColumn("Assignment Name");
        TableColumn assignmentAssignedDateCol = new TableColumn("Assigned Date");
        TableColumn assignmentDueDateCol = new TableColumn("Due Date");
        TableColumn assignmentEstiamtedHoursOfWorkCol = new TableColumn("Total Time");
        TableColumn assignmentTimeSpentCol = new TableColumn("Time Spent");
        TableColumn assignmentViewedCol = new TableColumn("Started");

        assignmentTable.getColumns().addAll(assignmentNameCol, assignmentAssignedDateCol, assignmentDueDateCol, assignmentEstiamtedHoursOfWorkCol, assignmentTimeSpentCol, assignmentViewedCol);
        
        autoResizeColumns(assignmentTable);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(labelAssignments, assignmentTable);

        return vbox;
    }

    public VBox todayTableMaker(TableView todayTable) {
        final Label labelToday = new Label("Today's Planner");
        labelToday.setFont(new Font("Arial", 20));

        todayTable.setEditable(false);

        TableColumn assignmentNameCol = new TableColumn("Assignment Name");
        TableColumn hoursToDoCol = new TableColumn("Work Time Today");
        TableColumn dueDateCol = new TableColumn("Due Date");
        TableColumn workedOnCCol = new TableColumn("Worked On");

        todayTable.getColumns().addAll(assignmentNameCol, hoursToDoCol, dueDateCol, workedOnCCol);

        autoResizeColumns(todayTable);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(labelToday, todayTable);

        return vbox;

    }

    private static void autoResizeColumns( TableView<?> table )
    {
        //Set the right policy
        table.setColumnResizePolicy( TableView.UNCONSTRAINED_RESIZE_POLICY);
        table.getColumns().stream().forEach( (column) ->
        {
            //Minimal width = columnheader
            Text t = new Text( column.getText() );
            double max = t.getLayoutBounds().getWidth();
            for ( int i = 0; i < table.getItems().size(); i++ )
            {
                //cell must not be empty
                if ( column.getCellData( i ) != null )
                {
                    t = new Text( column.getCellData( i ).toString() );
                    double calcwidth = t.getLayoutBounds().getWidth();
                    //remember new max-width
                    if ( calcwidth > max )
                    {
                        max = calcwidth;
                    }
                }
            }
            //set the new max-widht with some extra space
            column.setPrefWidth( max + 10.0d );
        } );
    }

}
