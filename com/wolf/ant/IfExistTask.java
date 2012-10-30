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

public class IfExistTask extends Task {
    private Sequential mThen;
    private Sequential mElse;
    private boolean isFound = false;
    private boolean isDirectory = false;
    public void execute() throws BuildException {
        if (isFound != false) {
            if (mThen != null) {
                mThen.execute();
            }
        } else if (isDirectory != false) {
            if (mThen != null) {
                mThen.execute();
            }
        } else {
            if (mElse != null) {
                mElse.execute();
            }
        }
    }

    public void setFile(String file) {
        File f = new File(file);
        if (f.exists()) {
            isFound = true;
        } else {
            isFound = false;
        }
        f = null;
    }

    public void setDir(String dir) {
        File f = new File(dir);
        if (f.exists() && f.isDirectory()) {
            isDirectory = true;
        } else {
            isDirectory = false;
        }
        f = null;
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
