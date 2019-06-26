/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import fekopanel.FekoCommand;
import fekopanel.FekoCommandConfig;
import java.io.File;
import java.util.Map;

/**
 *
 * @author lendle
 */
public abstract class AbstractProcessBasedFekoCommandImpl implements FekoCommand{
    protected File workDir=null;
    @Override
    public void init(File workDir, FekoCommandConfig config) throws Exception {
       this.workDir=workDir;
       this.init(config);
    }
    
    protected abstract void init(FekoCommandConfig config) throws Exception;

    @Override
    public void run() throws Exception {
        ProcessBuilder pb=new ProcessBuilder(this.composeCommand());
        pb.directory(workDir);
        Process process=pb.start();
        process.waitFor();
    }
    
    protected abstract String[] composeCommand();
}
