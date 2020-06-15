<<<<<<< HEAD
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeBoard extends Application{

    Image x,o;//Images for showing x and o

    ImageView cells[];//cells for the 3*3 grid

    Random random; // for generating random cells

    int cellWidth=100; // width of one cell

    int cellHeight=100; //height of one cell

    @Override

    public void start(Stage primaryStage) {



        x=new Image("file:C:\\Users\\desai\\Downloads\\image\\image\\x.gif");

        o=new Image("file:C:\\Users\\desai\\Downloads\\image\\image\\o.gif");

        cells=new ImageView[9];//3*3 cells

        random=new Random();//initializing random object



        for(int i=0;i<cells.length;i++){



            cells[i]=new ImageView();

            //setting height and width

            cells[i].setFitHeight(cellHeight);

            cells[i].setFitWidth(cellWidth);



            int n=random.nextInt(3);

            if(n==0){

                cells[i].setImage(x);//setting image

            }else if(n==1){

                cells[i].setImage(o);

            }

        }



        GridPane pane=new GridPane();

        //column, row attributes

        int col=0,row=0;

        for(int i=0;i<cells.length;i++){

            

            pane.add(cells[i], col, row);

            //incrementing the column value

            col++;

            

            if(col==3){

                col=0;

                row++;

            }

        }

        

        Scene scene = new Scene(pane);

        primaryStage.setTitle("Tic Tac Toe!");

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }



=======
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeBoard extends Application{

    Image x,o;//Images for showing x and o

    ImageView cells[];//cells for the 3*3 grid

    Random random; // for generating random cells

    int cellWidth=100; // width of one cell

    int cellHeight=100; //height of one cell

    @Override

    public void start(Stage primaryStage) {



        x=new Image("file:C:\\Users\\desai\\Downloads\\image\\image\\x.gif");

        o=new Image("file:C:\\Users\\desai\\Downloads\\image\\image\\o.gif");

        cells=new ImageView[9];//3*3 cells

        random=new Random();//initializing random object



        for(int i=0;i<cells.length;i++){



            cells[i]=new ImageView();

            //setting height and width

            cells[i].setFitHeight(cellHeight);

            cells[i].setFitWidth(cellWidth);



            int n=random.nextInt(3);

            if(n==0){

                cells[i].setImage(x);//setting image

            }else if(n==1){

                cells[i].setImage(o);

            }

        }



        GridPane pane=new GridPane();

        //column, row attributes

        int col=0,row=0;

        for(int i=0;i<cells.length;i++){

            

            pane.add(cells[i], col, row);

            //incrementing the column value

            col++;

            

            if(col==3){

                col=0;

                row++;

            }

        }

        

        Scene scene = new Scene(pane);

        primaryStage.setTitle("Tic Tac Toe!");

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }



>>>>>>> 6e22061cf32aaedcc0260e23f23e85e766b18a94
}