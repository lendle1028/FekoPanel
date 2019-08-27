/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

/**
 *
 * @author lendle
 */
public class OpenFekoApplicationFekoCommandImpl extends AbstractFekoCommandImpl{

    @Override
    public String[] getCommand() {
        return new String[]{
            "postfeko",
            this.fekoCommandConfig.getFekoFile().getName()
        };
    }
    
}
