/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author lendle
 */
public class FekoPanel extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox root=new HBox();
        ComboBox list1=new ComboBox();
        list1.getItems().addAll("Three_Spheres_VPol_MoM.pfs", "B", "C");
        
        ComboBox list2=new ComboBox();
        ComboBox list3=new ComboBox();
        
        list1.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String item1=(String) list1.getSelectionModel().getSelectedItem();
                list2.getItems().clear();
                list2.getItems().addAll("RCS_XY_v0", item1+"1", item1+"2");
            }
        });
        
        list3.getItems().addAll("CartesianGraphs");
        Button goButton=new Button("GO");
        goButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ProcessBuilder processBuilder = new ProcessBuilder();
                processBuilder.command("postfeko", "Three_Spheres_VPol_MoM.pfs", "--run-script", "test.lua", "--non-interactive");
                processBuilder.directory(new File("C:\\Users\\lendle\\Downloads\\POSTFEKO"));
                try {
                    Process process=processBuilder.start();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String str=reader.readLine();
                    while(str!=null){
                        System.out.println(str);
                        str=reader.readLine();
                    }
                    Desktop.getDesktop().open(new File("C:\\Users\\lendle\\Downloads\\POSTFEKO\\temp_FarFieldGraph.png"));
                } catch (IOException ex) {
                    Logger.getLogger(FekoPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        root.getChildren().addAll(list1, list2, list3, goButton);
        
        Scene scene = new Scene(root, 550, 100);
        
        primaryStage.setTitle("Hello World!");
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
