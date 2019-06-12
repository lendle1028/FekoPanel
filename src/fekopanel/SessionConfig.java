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
    private String implementationClass=null;
    private File [] presetFiles=null;
    private FekoCommand fekoCommand=null;
    private PostRunner postRunner=null;

    public String getImplementationClass() {
        return implementationClass;
    }

    public void setImplementationClass(String implementationClass) {
        this.implementationClass = implementationClass;
    }

    public File[] getPresetFiles() {
        return presetFiles;
    }

    public void setPresetFiles(File[] presetFiles) {
        this.presetFiles = presetFiles;
    }

    public FekoCommand getFekoCommand() {
        return fekoCommand;
    }

    public void setFekoCommand(FekoCommand fekoCommand) {
        this.fekoCommand = fekoCommand;
    }

    public PostRunner getPostRunner() {
        return postRunner;
    }

    public void setPostRunner(PostRunner postRunner) {
        this.postRunner = postRunner;
    }
    
    
}
