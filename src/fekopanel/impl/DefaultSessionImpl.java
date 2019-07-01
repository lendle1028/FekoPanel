/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import fekopanel.FekoCommand;
import fekopanel.PostRunner;
import fekopanel.Session;
import fekopanel.SessionConfig;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author lendle
 */
public class DefaultSessionImpl implements Session{
    private String sessionId=null;
    private File sessionFolder=null;
    private SessionConfig sessionConfig=null;
    @Override
    public void init(SessionConfig sessionConfig) {
        this.sessionConfig=sessionConfig;
        File tempFolder=new File(System.getProperty("user.home"));
        File sessionsFolder=new File(tempFolder, ".fekoPanelSession");
        if(!sessionsFolder.exists()){
            sessionsFolder.mkdirs();
        }
        File [] dirs=sessionsFolder.listFiles();
        for(File dir : dirs){
            //clean previous old sessions
            if((System.currentTimeMillis()-dir.lastModified())>60*60*1000){
                try {
                    FileUtils.deleteDirectory(dir);
                } catch (IOException ex) {
                    Logger.getLogger(DefaultSessionImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //create a new session
        sessionId="session_"+System.currentTimeMillis();
        sessionFolder=new File(sessionsFolder, sessionId);
        //copy preset files to the session folder
        for(File presetFile : sessionConfig.getPresetFiles()){
            try {
                FileUtils.copyFileToDirectory(presetFile, sessionFolder);
            } catch (IOException ex) {
                Logger.getLogger(DefaultSessionImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void run(File mainFekoFile) throws Exception {
        File fekoFileCopy=new File(sessionFolder, mainFekoFile.getName());
        FileUtils.copyFileToDirectory(mainFekoFile, sessionFolder);
        sessionConfig.getFekoCommandConfig().setFekoFile(fekoFileCopy);
        
        FekoCommand fekoCommand=(FekoCommand) Class.forName(sessionConfig.getFekoCommandConfig().getClassName()).newInstance();
        fekoCommand.init(sessionFolder, sessionConfig.getFekoCommandConfig());
        
        PostRunner postRunner=(PostRunner) Class.forName(sessionConfig.getPostRunnerConfig().getClassName()).newInstance();
        postRunner.init(sessionFolder, sessionConfig.getPostRunnerConfig());
        
        fekoCommand.run();
        postRunner.run();
    }
    
}
