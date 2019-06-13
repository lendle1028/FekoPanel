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
    private FekoCommandConfig fekoCommandConfig=null;
    private PostRunnerConfig postRunnerConfig=null;

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
}
