/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lendle
 */
public class OpenFekoApplicationFekoCommandImpl extends AbstractFekoCommandImpl{

    @Override
    public String[] getCommand() {
        try {
            return new String[]{
                "postfeko",
                "\""+this.fekoCommandConfig.getFekoFile().getCanonicalPath()+"\"",
                "--run-script",
                "\""+new File(this.workDir, this.fekoCommandConfig.getMainLuaFile()).getCanonicalPath()+"\"",
            };
        } catch (IOException ex) {
            Logger.getLogger(OpenFekoApplicationFekoCommandImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
