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
public class FekoFiles {
    private File fekFile, bofFile, pfsFile;
    /**
     * the main feko file to execute, must be one of the above files
     */
    private File mainFekoFile;

    public File getFekFile() {
        return fekFile;
    }

    public void setFekFile(File fekFile) {
        this.fekFile = fekFile;
    }

    public File getBofFile() {
        return bofFile;
    }

    public void setBofFile(File bofFile) {
        this.bofFile = bofFile;
    }

    public File getPfsFile() {
        return pfsFile;
    }

    public void setPfsFile(File pfsFile) {
        this.pfsFile = pfsFile;
    }

    public File getMainFekoFile() {
        return mainFekoFile;
    }

    public void setMainFekoFile(File mainFekoFile) {
        this.mainFekoFile = mainFekoFile;
    }
    
    public void reset(){
        this.fekFile=null;
        this.bofFile=null;
        this.pfsFile=null;
    }
}
