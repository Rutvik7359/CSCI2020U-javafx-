<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;


public class CharacterHistogram extends Application {

    private Scanner input;
    private HashMap<Character, Integer> hashMap;


    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        this.hashMap = new HashMap<Character, Integer>();
    }


    public int getCountFor(char character) {
        return this.hashMap.get(character);
    }

    private void increaseCountFor(char character) {
        if (this.hashMap.containsKey(character)) {
            this.hashMap.put(character, this.hashMap.get(character) + 1);
        } else {
            this.hashMap.put(character, 1);
        }
    }


    public void load(File textFile) throws FileNotFoundException, IOException {
        if (textFile == null) {
            throw new IllegalArgumentException("The input file cannot be null");
        }
        this.input = new Scanner(textFile);
        if (!this.input.hasNext()) {
            return;
        }
        do {
            String value = this.input.next();
            value = value.toUpperCase();
            for (int i = 0; i < value.length(); i++) {
                if (Character.isLetter(value.charAt(i))) {
                    this.increaseCountFor(value.charAt(i));
                }
            }
        } while (this.input.hasNext());
        this.input.close();
    }


    public ObservableList<PieChart.Data> dataProperty() {
        ObservableList<PieChart.Data> data =
                FXCollections.observableArrayList();
        for (Map.Entry<Character, Integer> entry : this.hashMap.entrySet()) {
            data.add(new PieChart.Data(entry.getKey().toString(), entry.getValue()));
        }
        return data;
    }
    public static void main(String[] args) {

        launch(args);

    }
}



import java.util.ArrayList;
import javafx.scene.AmbientLight;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.DrawMode;

/**
 *
 * @author Sean
 */
public class Histogram extends Group {

    private ArrayList<Double> xAxisData = new ArrayList<>();
    private ArrayList<Double> yAxisData = new ArrayList<>();
    private ArrayList<Double> zAxisData = new ArrayList<>();
    public Group histogramDataGroup = new Group();
    public AmbientLight selfLight = new AmbientLight(Color.WHITE);
    public double nodeRadius = 1;
    private double axesSize = 1000;
    private boolean normalized = false;
    public boolean selfLightEnabled = true;

    public enum NodeType {

        CYLINDER, CUBE
    };
    private NodeType defaultNodeType = NodeType.CUBE;

    public  Histogram(boolean selfLit) {
        selfLightEnabled = selfLit;
        init();
    }

    public  Histogram(double axesSize, double nodeRadius, boolean selfLit) {
        selfLightEnabled = selfLit;
        this.axesSize = axesSize;
        this.nodeRadius = nodeRadius;
        init();
    }

    private  void init() {
        getChildren().add(histogramDataGroup);
        if (selfLightEnabled) {
            getChildren().add(selfLight);
        }
        setDepthTest(DepthTest.ENABLE);
    }

    public  void setHeightData(float[][] arrayY, int barSize, int spacing,
            Color color, boolean ambient, boolean fill) {
        histogramDataGroup.getChildren().clear();
        PhongMaterial phong = new PhongMaterial();
        phong.setSpecularColor(color);
        phong.setDiffuseColor(color);

        float min = arrayY[0][0], max = arrayY[0][0];
        // Find min and max's for color gradient
        for (int x = 0; x < arrayY.length; x++) {
            for (int z = 0; z < arrayY[0].length; z++) {
                if (arrayY[x][z] < min) {
                    min = arrayY[x][z];
                }
                if (arrayY[x][z] > max) {
                    max = arrayY[x][z];
                }
            }
        }
        float range = max - min; //

        // Generate Bars 
        for (int x = 0; x < arrayY.length; x++) {
            for (int z = 0; z < arrayY[0].length; z++) {
                double ySize = arrayY[x][z];
                if (ySize < 0) {
                    ySize *= -1;
                }
                Node bar = createDefaultNode(barSize, ySize);
                bar.setTranslateX(x * spacing);
                bar.setTranslateY(-arrayY[x][z]);
                bar.setTranslateZ(z * spacing);
                //Apply normalized color scale
                double normalizedColor = (arrayY[x][z] - min) / range;
                if (arrayY[x][z] < range / 2) //if it is in the lower half of the range
                {
                    phong = new PhongMaterial(new Color(0.25, 0, normalizedColor, 1));
                } else //if it is in the upper half of the range
                {
                    phong = new PhongMaterial(new Color(normalizedColor, 0, 0.25, 1));
                }
                switch (getDefaultNodeType()) {
                    case CYLINDER: {
                        ((Cylinder) bar).setMaterial(phong);
                        ((Cylinder) bar).setCullFace(CullFace.BACK);
                        if (fill) {
                            ((Cylinder) bar).setDrawMode(DrawMode.FILL);
                        } else {
                            ((Cylinder) bar).setDrawMode(DrawMode.LINE); //show lines only by default
                        }
                        break;
                    }
                    case CUBE:
                    default: {
                        ((Box) bar).setMaterial(phong);
                        ((Box) bar).setCullFace(CullFace.BACK);
                        if (fill) {
                            ((Box) bar).setDrawMode(DrawMode.FILL);
                        } else {
                            ((Box) bar).setDrawMode(DrawMode.LINE); //show lines only by default
                        }
                    }
                }

                if (ambient) {
                    AmbientLight light = new AmbientLight(color);
                    light.getScope().add(bar);
                    histogramDataGroup.getChildren().add(light);
                }
                histogramDataGroup.getChildren().add(bar);
            }
        }
    }

    private  Node createDefaultNode(double barWidth, double barHeight) {
        switch (defaultNodeType) {
            case CYLINDER:
                return new Cylinder(barWidth / 2, barHeight);
            case CUBE:
                return new Box(barWidth, barHeight, barWidth);
            default:
                return new Box(barWidth, barHeight, barWidth);
        }
    }

    /**
     * @return the defaultNodeType
     */
    public  Histogram.NodeType getDefaultNodeType() {
        return defaultNodeType;
    }

    /**
     * @param defaultNodeType the defaultNodeType to set
     */
    public  void setDefaultNodeType(Histogram.NodeType defaultNodeType) {
        this.defaultNodeType = defaultNodeType;
    }
=======
import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;


public class CharacterHistogram extends Application {

    private Scanner input;
    private HashMap<Character, Integer> hashMap;


    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        this.hashMap = new HashMap<Character, Integer>();
    }


    public int getCountFor(char character) {
        return this.hashMap.get(character);
    }

    private void increaseCountFor(char character) {
        if (this.hashMap.containsKey(character)) {
            this.hashMap.put(character, this.hashMap.get(character) + 1);
        } else {
            this.hashMap.put(character, 1);
        }
    }


    public void load(File textFile) throws FileNotFoundException, IOException {
        if (textFile == null) {
            throw new IllegalArgumentException("The input file cannot be null");
        }
        this.input = new Scanner(textFile);
        if (!this.input.hasNext()) {
            return;
        }
        do {
            String value = this.input.next();
            value = value.toUpperCase();
            for (int i = 0; i < value.length(); i++) {
                if (Character.isLetter(value.charAt(i))) {
                    this.increaseCountFor(value.charAt(i));
                }
            }
        } while (this.input.hasNext());
        this.input.close();
    }


    public ObservableList<PieChart.Data> dataProperty() {
        ObservableList<PieChart.Data> data =
                FXCollections.observableArrayList();
        for (Map.Entry<Character, Integer> entry : this.hashMap.entrySet()) {
            data.add(new PieChart.Data(entry.getKey().toString(), entry.getValue()));
        }
        return data;
    }
    public static void main(String[] args) {

        launch(args);

    }
}



import java.util.ArrayList;
import javafx.scene.AmbientLight;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.DrawMode;

/**
 *
 * @author Sean
 */
public class Histogram extends Group {

    private ArrayList<Double> xAxisData = new ArrayList<>();
    private ArrayList<Double> yAxisData = new ArrayList<>();
    private ArrayList<Double> zAxisData = new ArrayList<>();
    public Group histogramDataGroup = new Group();
    public AmbientLight selfLight = new AmbientLight(Color.WHITE);
    public double nodeRadius = 1;
    private double axesSize = 1000;
    private boolean normalized = false;
    public boolean selfLightEnabled = true;

    public enum NodeType {

        CYLINDER, CUBE
    };
    private NodeType defaultNodeType = NodeType.CUBE;

    public  Histogram(boolean selfLit) {
        selfLightEnabled = selfLit;
        init();
    }

    public  Histogram(double axesSize, double nodeRadius, boolean selfLit) {
        selfLightEnabled = selfLit;
        this.axesSize = axesSize;
        this.nodeRadius = nodeRadius;
        init();
    }

    private  void init() {
        getChildren().add(histogramDataGroup);
        if (selfLightEnabled) {
            getChildren().add(selfLight);
        }
        setDepthTest(DepthTest.ENABLE);
    }

    public  void setHeightData(float[][] arrayY, int barSize, int spacing,
            Color color, boolean ambient, boolean fill) {
        histogramDataGroup.getChildren().clear();
        PhongMaterial phong = new PhongMaterial();
        phong.setSpecularColor(color);
        phong.setDiffuseColor(color);

        float min = arrayY[0][0], max = arrayY[0][0];
        // Find min and max's for color gradient
        for (int x = 0; x < arrayY.length; x++) {
            for (int z = 0; z < arrayY[0].length; z++) {
                if (arrayY[x][z] < min) {
                    min = arrayY[x][z];
                }
                if (arrayY[x][z] > max) {
                    max = arrayY[x][z];
                }
            }
        }
        float range = max - min; //

        // Generate Bars 
        for (int x = 0; x < arrayY.length; x++) {
            for (int z = 0; z < arrayY[0].length; z++) {
                double ySize = arrayY[x][z];
                if (ySize < 0) {
                    ySize *= -1;
                }
                Node bar = createDefaultNode(barSize, ySize);
                bar.setTranslateX(x * spacing);
                bar.setTranslateY(-arrayY[x][z]);
                bar.setTranslateZ(z * spacing);
                //Apply normalized color scale
                double normalizedColor = (arrayY[x][z] - min) / range;
                if (arrayY[x][z] < range / 2) //if it is in the lower half of the range
                {
                    phong = new PhongMaterial(new Color(0.25, 0, normalizedColor, 1));
                } else //if it is in the upper half of the range
                {
                    phong = new PhongMaterial(new Color(normalizedColor, 0, 0.25, 1));
                }
                switch (getDefaultNodeType()) {
                    case CYLINDER: {
                        ((Cylinder) bar).setMaterial(phong);
                        ((Cylinder) bar).setCullFace(CullFace.BACK);
                        if (fill) {
                            ((Cylinder) bar).setDrawMode(DrawMode.FILL);
                        } else {
                            ((Cylinder) bar).setDrawMode(DrawMode.LINE); //show lines only by default
                        }
                        break;
                    }
                    case CUBE:
                    default: {
                        ((Box) bar).setMaterial(phong);
                        ((Box) bar).setCullFace(CullFace.BACK);
                        if (fill) {
                            ((Box) bar).setDrawMode(DrawMode.FILL);
                        } else {
                            ((Box) bar).setDrawMode(DrawMode.LINE); //show lines only by default
                        }
                    }
                }

                if (ambient) {
                    AmbientLight light = new AmbientLight(color);
                    light.getScope().add(bar);
                    histogramDataGroup.getChildren().add(light);
                }
                histogramDataGroup.getChildren().add(bar);
            }
        }
    }

    private  Node createDefaultNode(double barWidth, double barHeight) {
        switch (defaultNodeType) {
            case CYLINDER:
                return new Cylinder(barWidth / 2, barHeight);
            case CUBE:
                return new Box(barWidth, barHeight, barWidth);
            default:
                return new Box(barWidth, barHeight, barWidth);
        }
    }

    /**
     * @return the defaultNodeType
     */
    public  Histogram.NodeType getDefaultNodeType() {
        return defaultNodeType;
    }

    /**
     * @param defaultNodeType the defaultNodeType to set
     */
    public  void setDefaultNodeType(Histogram.NodeType defaultNodeType) {
        this.defaultNodeType = defaultNodeType;
    }
>>>>>>> 6e22061cf32aaedcc0260e23f23e85e766b18a94
}