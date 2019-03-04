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
    
    public def getRoot() {
        return this;
    }
    
    public String getConnection() {
       return invoker.module?.properties?.connection;
    }

}

