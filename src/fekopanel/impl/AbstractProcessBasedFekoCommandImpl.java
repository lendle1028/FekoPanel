/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import fekopanel.FekoCommand;
import java.io.File;
import java.util.Map;
import javafx.application.Application;

/**
 *
 * @author lendle
 */
public abstract class AbstractProcessBasedFekoCommandImpl implements FekoCommand{
    protected File workDir=null;
    @Override
    public void init(File workDir, Map properties) throws Exception {
       this.workDir=workDir;
       this.init(properties);
    }
    
    protected abstract void init(Map properties) throws Exception;

    @Override
    public void run() throws Exception {
        ProcessBuilder pb=new ProcessBuilder(this.composeCommand());
        pb.directory(workDir);
        Process process=pb.start();
        process.waitFor();
    }
    
    protected abstract String[] composeCommand();
}
