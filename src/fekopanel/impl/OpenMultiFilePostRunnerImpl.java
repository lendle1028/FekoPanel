/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import fekopanel.PostRunner;
import fekopanel.PostRunnerConfig;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.SwingUtilities;

/**
 *
 * @author lendle
 */
public class OpenMultiFilePostRunnerImpl implements PostRunner {

    protected File workDir = null;
    protected List<Map<String, String>> files = new ArrayList<>();
    @Override
    public void init(File workDir, PostRunnerConfig config) throws Exception {
        this.workDir = workDir;
        Map properties=config.getProperties();
        List<Map<String, String>> list = (List<Map<String, String>>) properties.get("files");
        files.addAll(list);
    }

    @Override
    public void run() throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Stage dialog = new Stage();
                dialog.setWidth(800);
                dialog.setHeight(300);
                dialog.initStyle(StageStyle.UTILITY);
                GridPane root=new GridPane();
                root.setHgap(30);
                for(int i=0; i<files.size(); i++){
                    int row=i/5;
                    int column=i%5;
                    final Map<String, String> file=files.get(i);
                    Button button=new Button(file.get("label"));
                    root.add(button, column, row);
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            try {
                                System.out.println(new File(workDir, file.get("name")).toURI().toURL().toString());
                                //application.getHostServices().showDocument(new File(workDir, file.get("name")).toURI().toURL().toString());
                                //application.getHostServices().showDocument("http://www.pchome.com.tw");
                                SwingUtilities.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            Desktop.getDesktop().open(new File(workDir, file.get("name")));
                                        } catch (IOException ex) {
                                            Logger.getLogger(OpenMultiFilePostRunnerImpl.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                                //Desktop.getDesktop().open(new File(workDir, file.get("name")));
                            } catch (Exception ex) {
                                Logger.getLogger(OpenMultiFilePostRunnerImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                }
                Scene scene = new Scene(root);
                dialog.setScene(scene);
                dialog.show();
            }
        });
    }

}
