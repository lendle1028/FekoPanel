/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import fekopanel.PostRunner;
import java.awt.Desktop;
import java.io.File;
import java.util.Map;

/**
 *
 * @author lendle
 */
public class OpenFilePostRunnerImpl implements PostRunner{
    protected File workDir=null;
    protected String fileName=null;
    @Override
    public void init(File workDir, Map properties) throws Exception {
        this.workDir=workDir;
        this.fileName=(String) properties.get("fileName");
    }

    @Override
    public void run() throws Exception {
        Desktop.getDesktop().open(new File(workDir, fileName));
    }
    
}
