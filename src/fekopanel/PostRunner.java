/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel;

import java.io.File;
import java.util.Map;

/**
 *
 * @author lendle
 */
public interface PostRunner {
    public void init(File workDir, Map properties) throws Exception;
    public void run() throws Exception;
}
