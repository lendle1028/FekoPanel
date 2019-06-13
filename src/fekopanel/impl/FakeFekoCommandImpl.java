/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import fekopanel.FekoCommand;
import java.io.File;
import java.util.Map;

/**
 *
 * @author lendle
 */
public class FakeFekoCommandImpl implements FekoCommand{
    protected File workDir=null;
    @Override
    public void init(File workDir, Map properties) throws Exception {
        this.workDir=workDir;
    }

    @Override
    public void run() throws Exception {
        System.out.println("run~");
    }
    
}
