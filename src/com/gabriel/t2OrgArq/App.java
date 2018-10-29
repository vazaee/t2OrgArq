/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.t2OrgArq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Gabriel
 */
public class App extends Application {

    private static Stage mainstage;
    private BorderPane root;
    private Scene scene;
    private GridPane grid;
    private Text scenetitle;    
    private Label messageini;
    private ImageView imageini;

    //Janela depois de carregar o arquivo
    private Label steps;
    private Button nextStep;
    //Draw
    private Rectangle rect;
    
    @Override
    public void start(Stage primaryStage){
        this.mainstage = primaryStage;
        root = new BorderPane();
        MenuBar menuBar = new MenuBar();
        
        Menu file = new Menu("File");
        MenuItem open = new MenuItem("Open");
        MenuItem exit = new MenuItem("Exit");
        
        Menu help = new Menu("Help");
        MenuItem about = new MenuItem("About Us");
        
        file.getItems().addAll(open,exit);
        help.getItems().add(about);
        
        
        menuBar.getMenus().addAll(file,help);
      
        
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        scenetitle = new Text("Welcome to MIPS simulator!");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
        grid.add(scenetitle, 6, 0);
        
        messageini = new Label("To start, choose a .mips file in toolbar.");
        messageini.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(messageini, 6, 3);

        Image image = new Image("Open.png");
        imageini = new ImageView();
        imageini.setImage(image);
        imageini.setFitHeight(230);
        imageini.setFitWidth(500);
        grid.add(imageini,6,5);
        
        
        open.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                
                FileChooser fileChooser = new FileChooser();

                // Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("MIPS files (*.asm)", "*.asm");
                fileChooser.getExtensionFilters().add(extFilter);

                // Show open file dialog
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    grid.getChildren().clear();
                    ReadFile rf = ReadFile.getInstance();
                    try {
                        rf.inicia(file);
                        
                        newWindow();                    
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Platform.exit();
            }
        });
        
        root.setTop(menuBar);
        root.setCenter(grid);
        scene = new Scene(root, 1100, 650);
        
        primaryStage.setTitle("MIPS simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void newWindow(){
        
        steps = new Label("Next step:");
        steps.setTranslateX(50.0f);
        steps.setTranslateY(30.0f);
        steps.setFont(new Font("Arial", 12));
        
        nextStep = new Button("icon");
        nextStep.setTranslateX(110.0f); 
        nextStep.setTranslateY(25.0f);
        
        Rectangle rect1 = new Rectangle(150.0f,150.0f);
        rect1.setStroke(Color.BLACK);
        rect1.setFill(Color.FLORALWHITE);
        rect1.setX(300.0f); 
        rect1.setY(220.0f); 
        
        rect1.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("Clicou no retangulo 1");;
            }
        });
        
        Line line1 = new Line(451, 250, 649, 250);
        line1.setStrokeWidth(4);
        
        line1.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("Passou o mouse na linha");;
            }
        });
        
        Rectangle rect2 = new Rectangle(150.0f,150.0f);
        rect2.setStroke(Color.BLACK);
        rect2.setFill(Color.FLORALWHITE);
        rect2.setX(650.0f); 
        rect2.setY(220.0f); 
        
        rect2.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("Clicou no retangulo 2");;
            }
        });
        
        Group group = new Group(rect1,rect2); 
        group.getChildren().addAll(steps,nextStep,line1);
        
        Scene simulator = new Scene(group, 1100,650);       
        mainstage.setScene(simulator); 
    }
    
}
