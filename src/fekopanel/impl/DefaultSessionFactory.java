/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import com.google.gson.Gson;
import fekopanel.FekoCommandConfig;
import fekopanel.PostRunnerConfig;
import fekopanel.Session;
import fekopanel.SessionConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author lendle
 */
public class DefaultSessionFactory {
    public static Session fromJsonFile(File file) throws IOException{
        Gson gson=new Gson();
        Map map=gson.fromJson(FileUtils.readFileToString(file, "utf-8"), Map.class);
        SessionConfig sessionConfig=new SessionConfig();
        
        List<String> presetFileStrings=(List<String>) map.get("presetFiles");
        List<File> presetFiles=new ArrayList<>();
        for(String presetFileString : presetFileStrings){
            presetFiles.add(new File(presetFileString));
        }
        sessionConfig.setPresetFiles(presetFiles.toArray(new File[0]));
        
        Map fekoCommandConfigMap=(Map) map.get("fekoCommandConfig");
        FekoCommandConfig fekoCommandConfig=new FekoCommandConfig();
        fekoCommandConfig.setClassName((String) fekoCommandConfigMap.get("className"));
        fekoCommandConfig.setProperties(fekoCommandConfigMap);
        sessionConfig.setFekoCommandConfig(fekoCommandConfig);
        
        Map postRunnerConfigMap=(Map) map.get("postRunnerConfig");
        PostRunnerConfig postRunnerConfig=new PostRunnerConfig();
        postRunnerConfig.setClassName((String) postRunnerConfigMap.get("className"));
        postRunnerConfig.setProperties(postRunnerConfigMap);
        sessionConfig.setPostRunnerConfig(postRunnerConfig);
        
        DefaultSessionImpl session=new DefaultSessionImpl();
        session.init(sessionConfig);
        return session;
    }
}
