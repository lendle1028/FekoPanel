/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel;

import fekopanel.impl.DefaultSessionFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 *
 * @author lendle
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane root = null;

    private File selectedFile = null;
    @FXML
    private Label filename_text;
    @FXML
    private Button openFileButton;
    @FXML
    private Button openAllGraphsButton;

    private Map<AppFunctions, Result> appFunctionResults = new HashMap<>();
    private Alert alert = null;

    @FXML
    private void handleOpenFileAction(ActionEvent event) {
        appFunctionResults.clear();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("fek File", "*.fek"));
        fileChooser.setInitialDirectory(new File("."));
        File selectedFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (selectedFile != null) {
            this.selectedFile = selectedFile;
            filename_text.setText(selectedFile.getName());
        }
    }

    @FXML
    private void handleOpenAllGraphsAction(ActionEvent event) {
        try {
            runTask(new File("fake_multiplefile.json"), AppFunctions.FUNCTION_02_D);
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void runTask(File actionFile, AppFunctions functionId) throws Exception {
        if (appFunctionResults.containsKey(functionId)) {
            try {
                appFunctionResults.get(functionId).getPostRunner().resume();
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            new Thread() {
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Please Wait......");
                            alert.setContentText("Plase Wait......");
                            alert.showAndWait();
                        }
                    });
                }
            }.start();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    new Thread() {
                        public void run() {
                            try {
                                Session session = DefaultSessionFactory.fromJsonFile(actionFile);
                                session.run(selectedFile, new Session.Callback() {
                                    @Override
                                    public void onCompleted(Result result) {
                                        try {
                                            alert.close();
                                            appFunctionResults.put(functionId, result);
                                            result.getPostRunner().resume();
                                        } catch (Exception ex) {
                                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                            } catch (Exception ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }.start();

                }
            });

        }
    }
}
