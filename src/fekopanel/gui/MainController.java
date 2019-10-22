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
import fekopanel.impl.OpenMultiFilePostRunnerImpl;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.SwingUtilities;
import org.controlsfx.control.ToggleSwitch;

/**
 *
 * @author lendle
 */
public class MainController implements Initializable {

    @FXML
    private Pane root = null;
    @FXML
    private Label filename_text;
    @FXML
    private Button button01A;
    @FXML
    private Button button01B;
    @FXML
    private Button button01C;
    @FXML
    private Button button01D;
    @FXML
    private Button button01E;
    @FXML
    private Button button01F;
    @FXML
    private Button button01G;
    @FXML
    private Button button01H;
    @FXML
    private Button button02A;
    @FXML
    private Button button02B;
    @FXML
    private Button button02C;
    @FXML
    private Button button02D;
    @FXML
    private Button button03A;
    @FXML
    private Button button03B;
    @FXML
    private Button button03C;
    @FXML
    private Button button03D;
    @FXML
    private Button button04A;
    @FXML
    private Button button04B;
    @FXML
    private Button button04C;
    @FXML
    private Button button04D;
    @FXML
    private ToggleSwitch buttonToggleSingleDouble;

    private Map<AppFunctions, Result> appFunctionResults = new HashMap<>();
    private Stage loadingDialog = null;
    private Stage fileSelectionDialog = null;
    private FekoFileChooserController fekoFileChooserController = null;
    private FunctionDisableStateManager functionDisableStateManager = null;
    private File fekFile = null;
    private FekoFiles fekoFiles = new FekoFiles(), faFekoFiles=new FekoFiles();

    @FXML
    private void handleOpenFileAction(ActionEvent event) {
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
                        if (selectedFile != null) {
                            filename_text.setText(selectedFile.getName());
                            if (selectedFile.equals(fekFile) == false) {
                                //if the selected fek file is different,
                                //app function results cache must be cleared
                                appFunctionResults.clear();
                            }
                        }
                        fekFile = fekoFileChooserController.getFekFile();
                        fekoFiles.reset();
                        fekoFiles.setFekFile(fekoFileChooserController.getFekFile());
                        fekoFiles.setBofFile(fekoFileChooserController.getBofFile());
                        fekoFiles.setPfsFile(fekoFileChooserController.getPfsFile());
                        functionDisableStateManager.invalidatae();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @FXML
    private void handle02CAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            if(buttonToggleSingleDouble.isSelected()==false){
                runTask(new File("actions/02C/action.json"), AppFunctions.FUNCTION_02_C);
            }else{
                runTask(new File("actions/bi_site/02C/action.json"), AppFunctions.FUNCTION_02_C_BI);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle02DAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            if(buttonToggleSingleDouble.isSelected()==false){
                runTask(new File("actions/02D/action.json"), AppFunctions.FUNCTION_02_D);
            }else{
                runTask(new File("actions/bi_site/02D/action.json"), AppFunctions.FUNCTION_02_D_BI);
            }
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
    private void handle01GAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/01G/action.json"), AppFunctions.FUNCTION_01_G, true, true);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle01HAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            runTask(new File("actions/01H/action.json"), AppFunctions.FUNCTION_01_H, false, true);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle03AAction(ActionEvent event) {
        try {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Stage dialog = new Stage();
                    dialog.setWidth(200);
                    dialog.setHeight(300);
                    dialog.initStyle(StageStyle.UTILITY);
                    dialog.setAlwaysOnTop(true);
                    VBox root = new VBox();
                    root.setPadding(new Insets(10));
                    root.setSpacing(10);
                    root.setFillWidth(true);
                    Button button_1 = new Button("顯示x座標軸的RCS");
                    Button button_2 = new Button("顯示y座標軸的RCS");
                    root.getChildren().add(button_1);
                    root.getChildren().add(button_2);

                    button_1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            try {
                                if(buttonToggleSingleDouble.isSelected()==false){
                                    runTask(new File("actions/03A_1/action.json"), AppFunctions.FUNCTION_03_A_1, false, false);
                                }else{
                                    runTask(new File("actions/bi_site/03A_1/action.json"), AppFunctions.FUNCTION_03_A_1_BI, false, false);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });

                    button_2.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            try {
                                if(buttonToggleSingleDouble.isSelected()==false){
                                    runTask(new File("actions/03A_2/action.json"), AppFunctions.FUNCTION_03_A_2, false, false);
                                }else{
                                    runTask(new File("actions/bi_site/03A_2/action.json"), AppFunctions.FUNCTION_03_A_2_BI, false, false);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });

                    Scene scene = new Scene(root);
                    dialog.setScene(scene);
                    dialog.show();
                }
            });
//            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
//            runTask(new File("actions/03B/action.json"), AppFunctions.FUNCTION_03_B);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle03BAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            if(buttonToggleSingleDouble.isSelected()==false){
                runTask(new File("actions/03B/action.json"), AppFunctions.FUNCTION_03_B);
            }else{
                runTask(new File("actions/bi_site/03B/action.json"), AppFunctions.FUNCTION_03_B_BI);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle03CAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            if(buttonToggleSingleDouble.isSelected()==false){
                runTask(new File("actions/03C/action.json"), AppFunctions.FUNCTION_03_C);
            }else{
                runTask(new File("actions/bi_site/03C/action.json"), AppFunctions.FUNCTION_03_C_BI);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle03DAction(ActionEvent event) {
        try {
            fekoFiles.setMainFekoFile(fekoFiles.getFekFile());
            if(buttonToggleSingleDouble.isSelected()==false){
                runTask(new File("actions/03D/action.json"), AppFunctions.FUNCTION_03_D);
            }else{
                runTask(new File("actions/bi_site/03D/action.json"), AppFunctions.FUNCTION_03_D_BI);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle04AAction(ActionEvent event) {
        try {
            if(buttonToggleSingleDouble.isSelected()==false){
                runTask(new File("actions/04A/action.json"), AppFunctions.FUNCTION_04_A, false, false);
            }else{
                runTask(new File("actions/bi_site/04A/action.json"), AppFunctions.FUNCTION_04_A_BI, false, false);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle04BAction(ActionEvent event) {
        try {
            if(buttonToggleSingleDouble.isSelected()==false){
                runTask(new File("actions/04B/action.json"), AppFunctions.FUNCTION_04_B, false, false);
            }else{
                runTask(new File("actions/bi_site/04B/action.json"), AppFunctions.FUNCTION_04_B_BI, false, false);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle04CAction(ActionEvent event) {
        try {
            if(buttonToggleSingleDouble.isSelected()==false){
                runTask(new File("actions/04C/action.json"), AppFunctions.FUNCTION_04_C, false, false);
            }else{
                runTask(new File("actions/bi_site/04C/action.json"), AppFunctions.FUNCTION_04_C_BI, false, false);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handle04DAction(ActionEvent event) {
        try {
            if(buttonToggleSingleDouble.isSelected()==false){
                runTask(new File("actions/04D/action.json"), AppFunctions.FUNCTION_04_D, false, false);
            }else{
                runTask(new File("actions/bi_site/04D/action.json"), AppFunctions.FUNCTION_04_D_BI, false, false);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleToggleSingleDouble(MouseEvent event) {
        try {
            buttonToggleSingleDouble.setText(buttonToggleSingleDouble.isSelected()?"雙站":"單站");
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        functionDisableStateManager = new FunctionDisableStateManager(fekoFiles);
        functionDisableStateManager.addBinding("button01A", button01A, new String[]{"fek", "bof"});
        functionDisableStateManager.addBinding("button01B", button01B, new String[]{"fek", "bof"});
        functionDisableStateManager.addBinding("button01C", button01C, new String[]{"fek", "bof"});
        functionDisableStateManager.addBinding("button01D", button01D, new String[]{"fek", "bof"});
        functionDisableStateManager.addBinding("button01E", button01E, new String[]{"fek", "bof"});
        functionDisableStateManager.addBinding("button01F", button01F, new String[]{"fek", "bof"});
        functionDisableStateManager.addBinding("button01G", button01G, new String[]{"fek", "bof"});
        functionDisableStateManager.addBinding("button01H", button01H, new String[]{"fek"});

        /*functionDisableStateManager.addBinding("button02A", button02A, new String[]{"fek", "bof", "pfs"});
        functionDisableStateManager.addBinding("button02B", button02B, new String[]{"fek", "bof", "pfs"});*/
        functionDisableStateManager.addBinding("button02C", button02C, new String[]{"fek", "bof"});
        functionDisableStateManager.addBinding("button02D", button02D, new String[]{"fek", "bof"});

        functionDisableStateManager.addBinding("button03B", button03B, new String[]{"fek", "bof"});
        functionDisableStateManager.addBinding("button03C", button03C, new String[]{"fek", "bof"});
        functionDisableStateManager.addBinding("button03D", button03D, new String[]{"fek", "bof"});
        
        this.faFekoFiles.useFakeFekoFiles();
    }

    private void runTask(File actionFile, AppFunctions functionId) throws Exception {
        this.runTask(actionFile, functionId, true, true);
    }

    private void runTask(File actionFile, AppFunctions functionId, boolean showLoading, boolean requireFekoFile) throws Exception {
        //System.out.println("actionFile="+actionFile);
        //check whether the fek file is selected or not
        if (requireFekoFile && fekFile == null) {
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
            if (showLoading) {
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
            }
            //System.out.println(1);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    new Thread() {
                        public void run() {
                            try {
                                //System.out.println(2);
                                Session session = DefaultSessionFactory.fromJsonFile(actionFile);
                                //System.out.println(3);
                                session.run(requireFekoFile?fekoFiles:faFekoFiles, new Session.Callback() {
                                    @Override
                                    public void onCompleted(Result result) {
                                        try {
                                            if (showLoading) {
                                                Platform.runLater(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        loadingDialog.close();
                                                    }
                                                });
                                            }
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
