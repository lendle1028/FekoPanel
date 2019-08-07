/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fekopanel.gui;

import fekopanel.FekoFiles;
import java.util.HashMap;
import java.util.Map;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.Button;

/**
 * manage the state of enabling/disabling of function buttons
 * by watching at the specified FekoFiles instance
 * that is, the files selected from the main gui
 * @author lendle
 */
public class FunctionDisableStateManager {
    private FekoFiles fekoFiles=null;
    private Map<String, BindingSpec> bindings=new HashMap<>();
    public FunctionDisableStateManager(FekoFiles fekoFiles){
        this.fekoFiles=fekoFiles;
    }
    
    public void addBinding(String buttonName, Button button, final String [] extensionNames){
        BooleanBinding binding=new BooleanBinding() {
            @Override
            protected boolean computeValue() {
                boolean enabled=true;
                for(String ext : extensionNames){
                    if(ext.equals("fek")){
                        enabled=enabled && fekoFiles.getFekFile()!=null;
                    }else if(ext.equals("bof")){
                        enabled=enabled && fekoFiles.getBofFile()!=null;
                    }else if(ext.equals("pfs")){
                        enabled=enabled && fekoFiles.getPfsFile()!=null;
                    }
                }
                return !enabled;
            }
        };
        button.disableProperty().bind(binding);
        bindings.put(buttonName, new BindingSpec(button, binding));
    }
    
    public void invalidatae(){
        for(BindingSpec bindingSpec : bindings.values()){
            bindingSpec.binding.invalidate();
        }
    }
    
    class BindingSpec{
        protected Button button;
        protected BooleanBinding binding;

        public BindingSpec(Button button, BooleanBinding binding) {
            this.button = button;
            this.binding = binding;
        }
        
    }
}
