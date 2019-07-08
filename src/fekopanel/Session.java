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
public interface Session {
    public void init(SessionConfig sessionConfig);
    /**
     * 
     * @param mainFekoFile the feko file to be executed; the file will be copied to the target folder
     * @throws Exception 
     */
    public void run(File mainFekoFile, Callback callback) throws Exception;
    public interface Callback{
        public void onCompleted(Result result);
    }
}
