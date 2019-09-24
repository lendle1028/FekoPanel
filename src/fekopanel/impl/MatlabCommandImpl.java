/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import java.io.File;

/**
 *
 * @author lendle
 */
public class MatlabCommandImpl extends AbstractFekoCommandImpl{

    @Override
    protected File getWorkingDir() {
        return new File("matlab");
    }
    
    @Override
    public String[] getCommand() {
        String mscript=(String) this.fekoCommandConfig.getProperties().get("mscript");
        return new String[]{
            "matlab",
            "-nodisplay",
            "-nosplash",
            "-nodesktop",
            "-r",
            "\"run('"+mscript+"');\""
        };
    }
    
}
