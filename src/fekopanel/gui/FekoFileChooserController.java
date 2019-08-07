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

/**
 * FXML Controller class
 *
 * @author lendle
 */
public class FekoFileChooserController implements Initializable {
    @FXML
    private TextField fekFileText;
    @FXML
    private TextField bofFileText;
    @FXML
    private TextField pfsFileText;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public File getFekFile(){
        if(fekFileText.getText()==null || fekFileText.getText().isEmpty()){
            return null;
        }
        return new File(fekFileText.getText());
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
        
    }
    
    @FXML
    public void openBofFileAction(ActionEvent event){
        
    }
    
    @FXML
    public void openPfsFileAction(ActionEvent event){
        
    }
    
    @FXML
    public void okAction(ActionEvent event){
        
    }
    
    @FXML
    public void cancelAction(ActionEvent event){
        
    }
}
