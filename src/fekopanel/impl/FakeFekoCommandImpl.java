/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import fekopanel.FekoCommand;
import fekopanel.FekoCommandConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lendle
 */
public class FakeFekoCommandImpl implements FekoCommand{
    protected File workDir=null;
    protected Map<String, String> args=new HashMap<>();
    
    @Override
    public void init(File workDir, FekoCommandConfig config) throws Exception {
        this.workDir=workDir;
        Map properties=config.getProperties();
        Map<String, String> _args=(Map) properties.get("args");
        for(String key : _args.keySet()){
            String value=_args.get(key);
            if("${FEKO_FILE_NAME}".equals(value)){
                args.put(key, "file");
            }else{
                args.put(key, value);
            }
        }
    }

    @Override
    public void run(Callback callback) throws Exception {
        //System.out.println("run~");
        callback.onCompleted();
    }
    
}
