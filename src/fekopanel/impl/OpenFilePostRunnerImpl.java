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
import java.util.Map;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author lendle
 */
public class OpenFilePostRunnerImpl implements PostRunner{
    protected File workDir=null;
    protected String fileName=null;
    protected PostRunnerConfig postRunnerConfig=null;
    @Override
    public void init(File workDir, PostRunnerConfig config) throws Exception {
        this.workDir=workDir;
        Map properties=config.getProperties();
        this.fileName=(String) properties.get("fileName");
        this.postRunnerConfig=config;
    }

    @Override
    public void run(Callback callback) throws Exception {
        callback.onCompleted();
    }

    @Override
    public void resume() throws Exception {
        //check file existence, if not exists, move the file from the source feko folder
        //to the workdir
        File targetFile=new File(workDir, this.fileName);
        if(!targetFile.exists()){
            File sourceFile=new File(this.postRunnerConfig.getFekoCommandConfig().getFekoFile().getParentFile(), this.fileName);
            FileUtils.moveToDirectory(sourceFile, workDir, false);
        }
        if(!targetFile.exists()){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("抱歉，執行失敗");
                    alert.showAndWait();
                }
            });
        }
        //////////////////////
        Desktop.getDesktop().open(new File(workDir, fileName));
    }
    
}
