/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel;

import java.util.Map;

/**
 *
 * @author lendle
 */
public class PostRunnerConfig {
    private String className=null;
    private Map properties=null;
    private FekoCommandConfig fekoCommandConfig=null;

    public FekoCommandConfig getFekoCommandConfig() {
        return fekoCommandConfig;
    }

    public void setFekoCommandConfig(FekoCommandConfig fekoCommandConfig) {
        this.fekoCommandConfig = fekoCommandConfig;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Map getProperties() {
        return properties;
    }

    public void setProperties(Map properties) {
        this.properties = properties;
    }
    
}
