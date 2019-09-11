/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import fekopanel.PostRunner;
import fekopanel.PostRunnerConfig;
import java.io.File;

/**
 *
 * @author lendle
 */
public class NoopPostRunnerImpl implements PostRunner{

    @Override
    public void init(File workDir, PostRunnerConfig config) throws Exception {
        
    }

    @Override
    public void run(Callback callback) throws Exception {
        
    }

    @Override
    public void resume() throws Exception {
        
    }
    
}
