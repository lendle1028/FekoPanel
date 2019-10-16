/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author lendle
 */
public class FekoFileChooserController implements Initializable {
    @FXML
    private TextField fekFileTextField;
    @FXML
    private TextField bofFileText;
    @FXML
    private TextField pfsFileText;
    @FXML
    private Pane root;
    
    private boolean ok=false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public File getFekFile(){
        if(fekFileTextField.getText()==null || fekFileTextField.getText().isEmpty()){
            return null;
        }
        return new File(fekFileTextField.getText());
    }
    
    public File getBofFile(){
        if(bofFileText.getText()==null || bofFileText.getText().isEmpty()){
            return null;
        }
        return new File(bofFileText.getText());
    }
    
    public File getPfsFile(){
        if(pfsFileText.getText()==null || pfsFileText.getText().isEmpty()){
            return null;
        }
        return new File(pfsFileText.getText());
    }
    
    @FXML
    public void openFekFileAction(ActionEvent event){
        openFileChooser("fek", fekFileTextField);
    }
    
    @FXML
    public void openBofFileAction(ActionEvent event){
        openFileChooser("bof", bofFileText);
    }
    
    @FXML
    public void openPfsFileAction(ActionEvent event){
        openFileChooser("pfs", pfsFileText);
    }
    
    @FXML
    public void okAction(ActionEvent event){
        this.ok=true;
        root.getScene().getWindow().hide();
    }
    
    @FXML
    public void cancelAction(ActionEvent event){
        this.ok=false;
        root.getScene().getWindow().hide();
    }
    
    private void openFileChooser(String extension, TextField container){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(extension+" File", "*."+extension));
        if(this.getFekFile()==null){
            fileChooser.setInitialDirectory(new File("."));
        }else{
            fileChooser.setInitialDirectory(this.getFekFile().getParentFile());
        }
        File selectedFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (selectedFile != null) {
            container.setText(selectedFile.getAbsolutePath());
        }
    }
    
    public boolean isOk(){
        return ok;
    }
}
