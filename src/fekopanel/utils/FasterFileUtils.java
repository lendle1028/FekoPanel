/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author lendle
 */
public class FasterFileUtils {
    public static void copyFileToDirectory(File file, File directory) throws Exception{
        File targetFile=new File(directory, file.getName());
        byte [] buffer=new byte[128*1024*1024];
        InputStream fileInputStream=new FileInputStream(file);
        OutputStream fileOutputStream=new BufferedOutputStream(new FileOutputStream(targetFile));
        int readBytes=fileInputStream.read(buffer);
        while(readBytes!=-1){
            fileOutputStream.write(buffer, 0, readBytes);
            readBytes=fileInputStream.read(buffer);
        }
        fileOutputStream.close();
    }
}
