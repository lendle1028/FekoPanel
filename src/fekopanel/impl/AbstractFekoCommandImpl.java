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
public class AbstractFekoCommandImpl implements FekoCommand{
    protected File workDir=null;
    protected Map<String, String> args=new HashMap<>();
    protected Map<String, String> sysEnv=new HashMap<>();
    
    @Override
    public void init(File workDir, FekoCommandConfig config) throws Exception {
        Map properties=config.getProperties();
        this.workDir=workDir;
        Map<String, String> _args=(Map) properties.get("args");
        for(String key : _args.keySet()){
            String value=_args.get(key);
            if("${FEKO_FILE_NAME}".equals(value)){
                args.put(key, config.getFekoFile().getName());
            }else{
                args.put(key, value);
            }
        }
    }

    @Override
    public void run() throws Exception {
        System.out.println("run~");
    }
    
}
