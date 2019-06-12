/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel;

/**
 *
 * @author lendle
 */
public interface Session {
    public void init(SessionConfig sessionConfig);
    public void run() throws Exception;
}
