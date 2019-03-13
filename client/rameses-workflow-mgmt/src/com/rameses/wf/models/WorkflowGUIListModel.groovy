package com.rameses.wf.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import java.awt.*;
import java.awt.image.RenderedImage;
import javax.swing.*;
import javax.imageio.*;
import com.rameses.seti2.models.*;
import com.rameses.rcp.draw.figures.*;
import com.rameses.rcp.draw.interfaces.*;
import com.rameses.util.*;
import com.rameses.common.*;
import java.rmi.server.*;

public class WorkflowGUIListModel extends CrudListModel {
    
    @Service("WorkflowGUIService")
    def guiSvc;
    
    public def getRoot() {
        return this;
    }
    
    public String getConnection() {
       return invoker.module?.properties?.connection;
    }
    
    void copy() {
        if(!selectedItem) return;
        def r = MsgBox.prompt("Copying " + selectedItem.name + " to " );
        if(!r) return;
        guiSvc.copy( [oldname: selectedItem.name, name: r ] );
        reload();
    }
    
    void exportData() { 
        if(!selectedItem) return;
        def fileChooser = new javax.swing.JFileChooser();         
        fileChooser.setFileSelectionMode(fileChooser.FILES_ONLY); 
        fileChooser.setSelectedFile(new java.io.File('wf_' + selectedItem.name)); 
        int opt = fileChooser.showSaveDialog(null); 
        if (opt == fileChooser.APPROVE_OPTION) { 
            def file = fileChooser.getSelectedFile(); 
            def data = guiSvc.openDataForExport([name: selectedItem.name]); 
            if (!data) throw new Exception('No record(s) found'); 
            com.rameses.io.FileUtil.writeObject(file, data); 
            MsgBox.alert('Successfully exported to file'); 
        } 
    } 


}

