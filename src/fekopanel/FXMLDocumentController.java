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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private void handleOpenFileAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("fek File", "*.fek"));
        fileChooser.setInitialDirectory(new File("."));
        File selectedFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (selectedFile != null) {
            this.selectedFile = selectedFile;
        }
    }

    @FXML
    private void handleOpenAllGraphsAction(ActionEvent event) {
        try {
            Session session = DefaultSessionFactory.fromJsonFile(new File("fake_multiplefile.json"));
            session.run(this.selectedFile);
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
