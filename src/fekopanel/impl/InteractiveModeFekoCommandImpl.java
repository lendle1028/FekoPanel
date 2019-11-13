/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lendle
 */
public class InteractiveModeFekoCommandImpl extends AbstractFekoCommandImpl{

    @Override
    public String[] getCommand() {
        try {
            return new String[]{
                "postfeko",
                this.fekoCommandConfig.getFekoFile().getName(),
                "--run-script",
                "\""+new File(this.workDir, this.fekoCommandConfig.getMainLuaFile()).getCanonicalPath()+"\""
            };
        } catch (IOException ex) {
            return null;
        }
    }
    
    @Override
    public void run(Callback callback) throws Exception {
        assignValueToParametersInLua();
        ProcessBuilder pb = new ProcessBuilder(this.getCommand());
        Logger.getLogger(this.getClass().getName()).info("executing command: "+Arrays.deepToString(this.getCommand())+" in "+getWorkingDir());
        pb.directory(getWorkingDir());
        pb.redirectErrorStream();
        final Process [] process = new Process[1];
        final File monitoredFile=new File(this.workDir, (String) fekoCommandConfig.getProperties().get("monitorForFile"));
        new Thread(){
            public void run(){
                while(true){
                    if(monitoredFile.exists()){
                        Logger.getLogger(InteractiveModeFekoCommandImpl.class.getName()).info("the monitored file "+monitoredFile+" is ready");
                        process[0].destroyForcibly();
                        callback.onCompleted();
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(InteractiveModeFekoCommandImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
        process[0]=pb.start();
//        process.waitFor();
//        callback.onCompleted();
//        process.destroyForcibly();
    }
}
