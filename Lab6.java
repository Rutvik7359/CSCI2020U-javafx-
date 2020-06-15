import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Lab6 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        double paneHeight = 500;
        ValuestoScale();
//    int startX = 10;
//    for(int i = 1; i<=16; i++)
//    {
//
//    	if(i % 2 ==0)
//    	{
//    		Rectangle rectangle = new Rectangle(startX,paneHeight - avgCommercialPricesByYear[i] - 20, 20, avgCommercialPricesByYear[i]);
//    		rectangle.setFill(Color.BLUE);
//    		pane.getChildren().add(rectangle);
//    	}else
//    	{
//    		Rectangle rectangle = new Rectangle(startX,paneHeight - avgHousingPricesByYear[i] - 20, 20, avgHousingPricesByYear[i]);
//    		rectangle.setFill(Color.RED);
//    		startX+=20;
//    		pane.getChildren().add(rectangle);
//    	}
//
//    }
//
        Rectangle r1 = new Rectangle(10, paneHeight - avgHousingPricesByYear[0] - 20, 20, avgHousingPricesByYear[0]);
        r1.setFill(Color.RED);
        Rectangle b1 = new Rectangle(30, paneHeight - avgCommercialPricesByYear[0] - 20,20, avgCommercialPricesByYear[0]);
        b1.setFill(Color.BLUE);

        Rectangle r2 = new Rectangle(60, paneHeight - avgHousingPricesByYear[1] - 20, 20, avgHousingPricesByYear[1]);
        r2.setFill(Color.RED);
        Rectangle b2 = new Rectangle(80, paneHeight - avgCommercialPricesByYear[1] - 20, 20, avgCommercialPricesByYear[1]);
        b2.setFill(Color.BLUE);

        Rectangle r3 = new Rectangle(110, paneHeight - avgHousingPricesByYear[2] -20 , 20, avgHousingPricesByYear[2]);
        r3.setFill(Color.RED);
        Rectangle b3 = new Rectangle(130, paneHeight - avgCommercialPricesByYear[2] -20 ,20, avgCommercialPricesByYear[2]);
        b3.setFill(Color.BLUE);

        Rectangle r4 = new Rectangle(160, paneHeight - avgHousingPricesByYear[3] -20 , 20, avgHousingPricesByYear[3]);
        r4.setFill(Color.RED);
        Rectangle b4 = new Rectangle(180, paneHeight - avgCommercialPricesByYear[3] -20 , 20, avgCommercialPricesByYear[3]);
        b4.setFill(Color.BLUE);

        Rectangle r5 = new Rectangle(210, paneHeight - avgHousingPricesByYear[4] - 20, 20, avgHousingPricesByYear[4]);
        r5.setFill(Color.RED);
        Rectangle b5 = new Rectangle(230, paneHeight - avgCommercialPricesByYear[4] - 20,20, avgCommercialPricesByYear[4]);
        b5.setFill(Color.BLUE);

        Rectangle r6 = new Rectangle(260, paneHeight - avgHousingPricesByYear[5] - 20, 20, avgHousingPricesByYear[5]);
        r6.setFill(Color.RED);
        Rectangle b6 = new Rectangle(280, paneHeight - avgCommercialPricesByYear[5] - 20, 20, avgCommercialPricesByYear[5]);
        b6.setFill(Color.BLUE);

        Rectangle r7 = new Rectangle(310, paneHeight - avgHousingPricesByYear[6] -20 , 20, avgHousingPricesByYear[6]);
        r7.setFill(Color.RED);
        Rectangle b7 = new Rectangle(330, paneHeight - avgCommercialPricesByYear[6] -20 ,20, avgCommercialPricesByYear[6]);
        b7.setFill(Color.BLUE);

        Rectangle r8 = new Rectangle(360, paneHeight - avgHousingPricesByYear[7] -20 , 20, avgHousingPricesByYear[7]);
        r8.setFill(Color.RED);
        Rectangle b8 = new Rectangle(380, paneHeight - avgCommercialPricesByYear[7] -20 , 20, avgCommercialPricesByYear[7]);
        b8.setFill(Color.BLUE);

        pane.getChildren().addAll(r1, b1, r2, b2,r3,b3,r4,b4,r5,b5,r6,b6,r7,b7,r8,b8);

        double totstartAng = 0;
        for(int i=0;i<=5;i++) {
            totstartAng = totstartAng + purchasesByAgeGroup[i];
        }
        double startAng = 0;

        Arc arc1 = new Arc(750, paneHeight/2, 200, 200, 0, purchasesByAgeGroup[0]/totstartAng*360); // Create an arc
        arc1.setFill(pieColours[0]); // Set fill color
        arc1.setType(ArcType.ROUND); // Set arc type
        pane.getChildren().add(arc1); // Add arc to pane
        startAng += ((purchasesByAgeGroup[0]/totstartAng)*360);


        Arc arc2 = new Arc(750, paneHeight/2, 200, 200, 0 + startAng , purchasesByAgeGroup[1]/totstartAng*360); // Create an arc
        arc2.setFill(pieColours[1]); // Set fill color
        arc2.setType(ArcType.ROUND); // Set arc type
        pane.getChildren().add(arc2); // Add arc to pane
        startAng += ((purchasesByAgeGroup[1]/totstartAng)*360);

        Arc arc3 = new Arc(750, paneHeight/2, 200, 200,startAng , purchasesByAgeGroup[2]/totstartAng*360); // Create an arc
        arc3.setFill(pieColours[2]); // Set fill color
        arc3.setType(ArcType.ROUND); // Set arc type
        pane.getChildren().add(arc3); // Add arc to pane
        startAng += ((purchasesByAgeGroup[2]/totstartAng)*360);

        Arc arc4 = new Arc(750, paneHeight/2, 200, 200,startAng , purchasesByAgeGroup[3]/totstartAng*360); // Create an arc
        arc4.setFill(pieColours[3]); // Set fill color
        arc4.setType(ArcType.ROUND); // Set arc type
        pane.getChildren().add(arc4); // Add arc to pane
        startAng += ((purchasesByAgeGroup[3]/totstartAng)*360);

        Arc arc5 = new Arc(750, paneHeight/2, 200, 200,startAng , purchasesByAgeGroup[4]/totstartAng*360); // Create an arc
        arc5.setFill(pieColours[4]); // Set fill color
        arc5.setType(ArcType.ROUND); // Set arc type
        pane.getChildren().add(arc5); // Add arc to pane
        startAng += ((purchasesByAgeGroup[4]/totstartAng)*360);

        Arc arc6 = new Arc(750, paneHeight/2, 200, 200,startAng , purchasesByAgeGroup[5]/totstartAng*360); // Create an arc
        arc6.setFill(pieColours[5]); // Set fill color
        arc6.setType(ArcType.ROUND); // Set arc type
        pane.getChildren().add(arc6); // Add arc to pane
        startAng += ((purchasesByAgeGroup[5]/totstartAng)*360);



        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 1000, paneHeight);
        primaryStage.setTitle("Lab06"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void ValuestoScale()
    {
        // Sets the values to a proper scale that fits into the pane, divide all values by 3600
        // This allows for the maxiumum value to fit into our pane
        for(int i =0; i<7;i++)
        {
            avgHousingPricesByYear[i] = avgHousingPricesByYear[i]/3600;
        }

        for(int j=0;j<7;j++)
        {
            avgCommercialPricesByYear[j] = avgCommercialPricesByYear[j]/3600;
        }
    }
    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    private static double[] purchasesByAgeGroup = {
            648,1021,2453,3173,1868,2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };


    public static void main(String[] args) {
        launch(args);
    }
}
