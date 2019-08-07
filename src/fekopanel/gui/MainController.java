/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.gui;

import fekopanel.AppFunctions;
import fekopanel.FekoFiles;
import fekopanel.Result;
import fekopanel.Session;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author lendle
 */
public class MainController implements Initializable {

    @FXML
    private Pane root = null;

    private File fekFile = null;
    private FekoFiles fekoFiles = null;
    @FXML
    private Label filename_text;
    @FXML
    private Button openFileButton;
    @FXML
    private Button openAllGraphsButton;

    private Map<AppFunctions, Result> appFunctionResults = new HashMap<>();
    private Stage loadingDialog = null;
    private Stage fileSelectionDialog = null;
    private FekoFileChooserController fekoFileChooserController = null;

    @FXML
    private void handleOpenFileAction(ActionEvent event) {
        /*appFunctionResults.clear();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("fek File", "*.fek"));
        fileChooser.setInitialDirectory(new File("."));
        File selectedFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (selectedFile != null) {
            this.selectedFile = selectedFile;
            filename_text.setText(selectedFile.getName());
        }*/
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    if (fileSelectionDialog == null) {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FekoFileChooser.fxml"));
                        Parent parent = fxmlLoader.load();
                        fekoFileChooserController = fxmlLoader.getController();
                        Scene scene = new Scene(parent);
                        fileSelectionDialog = new Stage();
                        fileSelectionDialog.initModality(Modality.APPLICATION_MODAL);
                        fileSelectionDialog.setScene(scene);
                    }
                    fileSelectionDialog.showAndWait();
                    if (fekoFileChooserController.isOk()) {
                        File selectedFile = fekoFileChooserController.getFekFile();
                        if (selectedFile != null && selectedFile.equals(fekFile) == false) {
                            //if the selected fek file is different,
                            //app function results cache must be cleared
                            appFunctionResults.clear();
                        }
                        fekFile=fekoFileChooserController.getFekFile();
                        fekoFiles = new FekoFiles();
                        fekoFiles.setFekFile(fekoFileChooserController.getFekFile());
                        fekoFiles.setBofFile(fekoFileChooserController.getBofFile());
                        fekoFiles.setPfsFile(fekoFileChooserController.getPfsFile());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @FXML
    private void handle02DAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/02D/action.json"), AppFunctions.FUNCTION_02_D);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle01AAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/01A/action.json"), AppFunctions.FUNCTION_01_A);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle01BAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/01B/action.json"), AppFunctions.FUNCTION_01_B);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle01CAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/01C/action.json"), AppFunctions.FUNCTION_01_C);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle01DAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/01D/action.json"), AppFunctions.FUNCTION_01_D);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle01EAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/01E/action.json"), AppFunctions.FUNCTION_01_E);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle01FAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/01F/action.json"), AppFunctions.FUNCTION_01_F);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle03AAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/03A/action.json"), AppFunctions.FUNCTION_03_A);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle03BAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/03B/action.json"), AppFunctions.FUNCTION_03_B);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle03CAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/03C/action.json"), AppFunctions.FUNCTION_03_C);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void runTask(File actionFile, AppFunctions functionId) throws Exception {
        //check whether the fek file is selected or not
        if (fekFile == null) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("請先選取檔案");
                    alert.showAndWait();
                }
            });
            return;
        }
        //if previous results exist, simply show the result
        if (appFunctionResults.containsKey(functionId)) {
            try {
                appFunctionResults.get(functionId).getPostRunner().resume();
            } catch (Exception ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //otherwise, we have to execute the corresponding feko commands
            new Thread() {
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loading.fxml"));
                                Parent parent = fxmlLoader.load();
                                Scene scene = new Scene(parent, 300, 200);
                                scene.setFill(Color.TRANSPARENT);
                                loadingDialog = new Stage();
                                loadingDialog.initModality(Modality.APPLICATION_MODAL);
                                loadingDialog.setScene(scene);
                                loadingDialog.initStyle(StageStyle.TRANSPARENT);
                                loadingDialog.showAndWait();
                            } catch (IOException ex) {
                                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                            }
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
                                session.run(fekoFiles, new Session.Callback() {
                                    @Override
                                    public void onCompleted(Result result) {
                                        try {
                                            Platform.runLater(new Runnable() {
                                                @Override
                                                public void run() {
                                                    loadingDialog.close();
                                                }
                                            });
                                            appFunctionResults.put(functionId, result);
                                            result.getPostRunner().resume();
                                        } catch (Exception ex) {
                                            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                            } catch (Exception ex) {
                                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }.start();

                }
            });

        }
    }
}
