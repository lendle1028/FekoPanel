/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel;

import java.io.File;

/**
 *
 * @author lendle
 */
public class SessionConfig {
    private File [] presetFiles=null;//resource files (feko model file is not included)
    private File fekoFile=null;//the feko model file which is chosen by user at run time
    private FekoCommandConfig fekoCommandConfig=null;
    private PostRunnerConfig postRunnerConfig=null;

    public File getFekoFile() {
        return fekoFile;
    }

    public void setFekoFile(File fekoFile) {
        this.fekoFile = fekoFile;
    }
    
    public FekoCommandConfig getFekoCommandConfig() {
        return fekoCommandConfig;
    }

    public void setFekoCommandConfig(FekoCommandConfig fekoCommandConfig) {
        this.fekoCommandConfig = fekoCommandConfig;
    }

    public PostRunnerConfig getPostRunnerConfig() {
        return postRunnerConfig;
    }

    public void setPostRunnerConfig(PostRunnerConfig postRunnerConfig) {
        this.postRunnerConfig = postRunnerConfig;
    }

    public File[] getPresetFiles() {
        return presetFiles;
    }

    public void setPresetFiles(File[] presetFiles) {
        this.presetFiles = presetFiles;
    }
}
