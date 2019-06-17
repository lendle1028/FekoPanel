/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel;

import fekopanel.impl.DefaultSessionFactory;
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
public class FekoPanel1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();

        Button goButton = new Button("GO");
        goButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Session session = DefaultSessionFactory.fromJsonFile(new File("fake_multiplefile.json"));
                    session.run();
                } catch (Exception ex) {
                    Logger.getLogger(FekoPanel1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        root.getChildren().addAll(goButton);

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
