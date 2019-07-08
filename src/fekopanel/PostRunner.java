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
public interface PostRunner {
    public void init(File workDir, PostRunnerConfig config) throws Exception;
    public void run(Callback callback) throws Exception;
    public void resume() throws Exception;
    public interface Callback{
        public void onCompleted();
    }
}
