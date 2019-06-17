/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import fekopanel.PostRunner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author lendle
 */
public class OpenMultiFilePostRunnerImpl implements PostRunner {

    protected File workDir = null;
    protected List<Map<String, String>> files = new ArrayList<>();

    @Override
    public void init(File workDir, Map properties) throws Exception {
        this.workDir = workDir;
        List<Map<String, String>> list = (List<Map<String, String>>) properties.get("files");
        files.addAll(list);
    }

    @Override
    public void run() throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Stage dialog = new Stage();
                dialog.setWidth(300);
                dialog.setHeight(300);
                dialog.initStyle(StageStyle.UTILITY);
                GridPane root=new GridPane();
                for(int i=0; i<files.size(); i++){
                    int row=i/5;
                    int column=i%5;
                    Map<String, String> file=files.get(i);
                    Button button=new Button(file.get("label"));
                    root.add(button, column, row);
                }
                Scene scene = new Scene(root);
                dialog.setScene(scene);
                dialog.show();
            }
        });
    }

}
