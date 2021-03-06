/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gitittech.syswriter.builders;

import com.gitittech.syswriter.LogMan;
import com.gitittech.syswriter.Level;
import com.gitittech.syswriter.models.Log;

/**
 *
 * @author Ambrose Ariagiegbe
 */
public class ErrorLogBuilder extends LogBuilder {

    private Throwable e;
    private String stackTrace;
    
    public ErrorLogBuilder(Throwable e) {
        this.e = e;
        this.level = Level.ERROR.name();
        this.stackTrace = LogMan.getStackTrace(e);
        this.description = e.getMessage();
    }
   
     public LogBuilder setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
        return this;
    }
     
    public Log build() {   
        if(controller == null)
            throw new IllegalArgumentException("Controller is null");
        return new Log(controller, description, stackTrace, level);
    }

}
