/***************************************************************************************************
 * AntIfs
 * Custom Ant Task
 *
 * @version: v1.0.1
 * @author:  Cris del Rosario
 * Git       https://github.com/Amiagin/antifs.git
 * 
 ***************************************************************************************************/

package com.wolf.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.Sequential;
import org.apache.tools.ant.taskdefs.condition.And;

import java.io.File;

public class TolowerCaseTask extends Task {    
	private String property = "";
    public void execute() throws BuildException {	    
		String value = getProject().getProperty(property);
	    if (value != null) {
		    getProject().setProperty(property,value.toLowerCase());
		}
    }
	
	public void setProperty(String property) {
	    this.property = property;
	}
}
