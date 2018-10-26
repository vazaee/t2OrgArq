/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.t2OrgArq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Gabriel
 */
public class App extends Application {

    private Canvas canvas;
    private GraphicsContext gc; 	
    private static final int imglarg = 350; 	
    private static final int imgAlt = 350; 	
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane raiz = new BorderPane();
        
        MenuBar menuBar = new MenuBar();
        
        Menu arquivo = new Menu("Arquivo");
        MenuItem open = new MenuItem("Open");
        MenuItem exit = new MenuItem("Exit");
        
        Menu help = new Menu("Help");
        MenuItem about = new MenuItem("About Us");
        
        arquivo.getItems().addAll(open,exit);
        help.getItems().add(about);
        
        
        menuBar.getMenus().addAll(arquivo,help);
      
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        canvas = new Canvas(imglarg, imgAlt);
        gc = canvas.getGraphicsContext2D();                 
        grid.add(canvas, 6, 1, 1, 11);
        
        Text scenetitle = new Text("Bem-vindo ao simulador do MIPS! ");
        scenetitle.setId("bemvindo-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
        grid.add(scenetitle, 6, 0);
        
        Label mensagem_inicial = new Label("Para começar, selecione um arquivo .mips em OPEN na barra de tarefas.");
        mensagem_inicial.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(mensagem_inicial, 6, 3);

        
        open.setOnAction((e) -> {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Abrir Arquivo");
            File arq = fileChooser.showOpenDialog(stage);
        });
        
        /*
        Label pos = new Label("Posição:");
        grid.add(pos, 1, 2);
        TextField posTextField = new TextField();
        grid.add(posTextField, 2, 2);
        posTextField.setEditable(false);

        Label sqbase = new Label("Seqbase:");
        grid.add(sqbase, 1, 3);

        Label sentido = new Label("Sentido:");
        grid.add(sentido, 1, 4);
        TextField sentidoTextField = new TextField();
        grid.add(sentidoTextField, 2, 4);
        sentidoTextField.setEditable(false);

        Label agrup = new Label("Agrupamento:");
        grid.add(agrup, 1, 5);
        TextArea agrupTextField = new TextArea();
        agrupTextField.setMaxSize(300,0);
        grid.add(agrupTextField, 1, 6, 2, 1);
        agrupTextField.setEditable(false);

        Label seqamin = new Label("Seq de amino:");
        grid.add(seqamin, 1, 7);
        TextArea seqaminTextField = new TextArea();
        seqaminTextField.setMaxSize(300,0);
        grid.add(seqaminTextField, 1, 8, 2, 1);
        seqaminTextField.setEditable(false);

        Label sqcor = new Label("Seq correta:");
        grid.add(sqcor, 1, 9);
        TextArea sqcorTextField = new TextArea();
        sqcorTextField.setMaxSize(300,0);
        grid.add(sqcorTextField, 1, 10, 2, 1);
        sqcorTextField.setEditable(false);

        Button btn = new Button("Carregar");
        grid.add(btn, 1, 11);

        ListView<String> ls = new ListView<>();
        ls.setEditable(false);

        grid.add(ls, 0, 1, 1, 11);*/
        raiz.setTop(menuBar);
        raiz.setCenter(grid);
        Scene scene = new Scene(raiz, 1100, 650);
        
        primaryStage.setTitle("Simulador MIPS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
