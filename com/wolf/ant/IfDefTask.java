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
import org.apache.tools.ant.taskdefs.Property;

import java.io.File;

public class IfDefTask extends Task {
    private Sequential mThen;
    private Sequential mElse;
    private boolean isPropertySet = false;
    public void execute() throws BuildException {
        if (isPropertySet != false) {
            if (mThen != null) {
                mThen.execute();
            }
        } else {
            if (mElse != null) {
                mElse.execute();
            }
        }
    }

    public void setProperty(String property) {
        if (getProject().getProperty(property) != null) {
            isPropertySet = true;
        } else {
            isPropertySet = false;
        }
    }

    public Object createThen() {
        mThen = new Sequential();
        return mThen;
    }

    public Object createElse() {
        mElse = new Sequential();
        return mElse;
    }
}
