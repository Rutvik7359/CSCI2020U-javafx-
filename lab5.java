/*import javafx.application.Application;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.Group;


public class lab5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private TableView<StudentRecord> table;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab05 Student Record");


        TableColumn SIDCol = new TableColumn("SID");
        SIDCol.setPrefWidth(100);
        SIDCol.setCellValueFactory(new PropertyValueFactory("SID"));

        TableColumn midtermCol = new TableColumn("midterm");
        midtermCol.setPrefWidth(100);
        midtermCol.setCellValueFactory(new PropertyValueFactory<>("midterm"));

        TableColumn assignmentsCol = new TableColumn("assignments");
        assignmentsCol.setPrefWidth(100);
        assignmentsCol.setCellValueFactory(new PropertyValueFactory<>("assignments"));

        TableColumn finalexamCol = new TableColumn("finalexam");
        finalexamCol.setPrefWidth(100);
        finalexamCol.setCellValueFactory(new PropertyValueFactory<>("finalexam"));

        TableColumn finalmarkCol = new TableColumn("finalmark");
        finalmarkCol.setPrefWidth(100);
        finalmarkCol.setCellValueFactory(new PropertyValueFactory<>("finalmark"));

        TableColumn lettergradeCol = new TableColumn("lettergrade");
        lettergradeCol.setPrefWidth(100);
        lettergradeCol.setCellValueFactory(new PropertyValueFactory<>("lettergrade"));


        table.getColumns().add(SIDCol);
        table.getColumns().add(midtermCol);
        table.getColumns().add(assignmentsCol);
        table.getColumns().add(finalexamCol);
        table.getColumns().add(finalmarkCol);
        table.getColumns().add(lettergradeCol);

        table.setItems(DataSource.getAllMarks());

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table);

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public static class StudentRecord {

        private final  double SID;
        private final  float midterm;
        private final  float assignment;
        private final float finalexam;
        private final float finalmark;
        private final char lettergrade;

        private StudentRecord(double sid , float midterm, float assignment, float finalexam) {
            this.SID = new double [sid];
            this.midterm = new float [midterm];
            this.assignment = new float [assignment];
            this.finalexam = new float [finalexam];
        }

        public double getSID() {
            return SID;
        }

        public void setSID(double sid) {
            SID = sid;
        }

        public float getMidterm() {
            return midterm;
        }

        public void setMidterm(float midterm) {
            midterm = midterm;
        }

        public float getAssignment() {
            return assignment;
        }

        public void setAssignment(float assignment) {
            assignment = assignment;
        }

        public float getFinalexam() {
            return finalexam;
        }

    }
    public class DataSource {
        public static ObservableList<StudentRecord> getAllMarks() {
            ObservableList<StudentRecord> marks =
                    FXCollections.observableArrayList();

            // Student ID, Assignments, Midterm, Final exam
            marks.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
            marks.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
            marks.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
            marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
            marks.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
            marks.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
            marks.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
            marks.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
            marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
            marks.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));
            return marks;
        }
    }

}

import javafx.application.Application;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableView;


public class lab5 extends Application {

    private TableView<StudentRecord> students;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab05 Student Record");

        BorderPane bp = new BorderPane();

        TableColumn<StudentRecord, String> SIDCol = new TableColumn<>("SID");
        SIDCol.setPrefWidth(100);
        SIDCol.setCellValueFactory(new PropertyValueFactory<>("SID"));

        TableColumn<StudentRecord, String> midtermCol = new TableColumn<>("midterm");
        midtermCol.setPrefWidth(200);
        midtermCol.setCellValueFactory(new PropertyValueFactory<>("midterm"));

        TableColumn<StudentRecord, String> assignmentsCol = new TableColumn<>("assignments");
        assignmentsCol.setPrefWidth(200);
        assignmentsCol.setCellValueFactory(new PropertyValueFactory<>("assignments"));

        TableColumn<StudentRecord, String> finalexamCol = new TableColumn<>("finalexam");
        finalexamCol.setPrefWidth(200);
        finalexamCol.setCellValueFactory(new PropertyValueFactory<>("finalexam"));

        TableColumn<StudentRecord, String> finalmarkCol = new TableColumn<>("finalmark");
        finalmarkCol.setPrefWidth(200);
        finalmarkCol.setCellValueFactory(new PropertyValueFactory<>("finalmark"));

        TableColumn<StudentRecord, String> lettergradeCol = new TableColumn<>("lettergrade");
        lettergradeCol.setPrefWidth(200);
        lettergradeCol.setCellValueFactory(new PropertyValueFactory<>("lettergrade"));


        this.students = new TableView<>();
        this.students.getColumns().add(SIDCol);
        this.students.getColumns().add(midtermCol);
        this.students.getColumns().add(assignmentsCol);
        this.students.getColumns().add(finalexamCol);
        this.students.getColumns().add(finalmarkCol);
        this.students.getColumns().add(lettergradeCol);



        bp.setCenter(this.students);
        Scene scene = new Scene(bp, 1100, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        this.students.setItems(DataSource.getAllMarks());

    }
}
*/