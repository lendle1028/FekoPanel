/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel;

import fekopanel.impl.DefaultSessionFactory;
import java.io.File;

/**
 *
 * @author lendle
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        Session session=DefaultSessionFactory.fromJsonFile(new File("fake.json"));
        session.run();
    }
    
}
