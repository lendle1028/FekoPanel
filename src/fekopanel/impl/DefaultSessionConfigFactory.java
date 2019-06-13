/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import com.google.gson.Gson;
import fekopanel.SessionConfig;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author lendle
 */
public class DefaultSessionConfigFactory {
    public SessionConfig fromJsonFile(File file) throws IOException{
        Gson gson=new Gson();
        Map map=gson.fromJson(FileUtils.readFileToString(file, "utf-8"), Map.class);
        SessionConfig sessionConfig=new SessionConfig();
        sessionConfig.setImplementationClass((String) map.get("implementationClass"));
        
        return sessionConfig;
    }
}
