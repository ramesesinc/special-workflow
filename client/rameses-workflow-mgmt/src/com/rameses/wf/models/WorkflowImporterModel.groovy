package com.rameses.wf.models;

import com.rameses.rcp.common.*;
import com.rameses.rcp.annotations.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*
import com.rameses.rulemgmt.*;
import com.rameses.util.*;
import java.rmi.server.*;
import com.rameses.io.*;

public class WorkflowImporterModel {

    @Caller
    def caller;
    
    public def getService() {
        return InvokerProxy.instance.create( "WorkflowGUIService", null, caller.getConnection() );
    }

    
    def fileChooser = new javax.swing.JFileChooser(); 

    void startImport() {
        fileChooser.setFileSelectionMode(fileChooser.FILES_ONLY); 
        int opt = fileChooser.showOpenDialog(null); 
        if (opt == fileChooser.APPROVE_OPTION) { 
            def file = fileChooser.getSelectedFile(); 
            def obj = FileUtil.readObject( file );
            service.importData( obj );
            MsgBox.alert('Successfully read file'); 
        } 
    }

    
}

