/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel;

import java.io.File;
import java.util.Map;

/**
 *
 * @author lendle
 */
public class FekoCommandConfig {
    private String className=null;
    private Map properties=null;
    private File fekoFile=null;

    public File getFekoFile() {
        return fekoFile;
    }

    public void setFekoFile(File fekoFile) {
        this.fekoFile = fekoFile;
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
