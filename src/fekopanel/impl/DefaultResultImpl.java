/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.impl;

import fekopanel.FekoCommand;
import fekopanel.PostRunner;
import fekopanel.Result;

/**
 *
 * @author lendle
 */
public class DefaultResultImpl implements Result{
    private FekoCommand fekoCommand=null;
    private PostRunner postRunner=null;

    public FekoCommand getFekoCommand() {
        return fekoCommand;
    }

    public void setFekoCommand(FekoCommand fekoCommand) {
        this.fekoCommand = fekoCommand;
    }

    public PostRunner getPostRunner() {
        return postRunner;
    }

    public void setPostRunner(PostRunner postRunner) {
        this.postRunner = postRunner;
    }
    
    
}
