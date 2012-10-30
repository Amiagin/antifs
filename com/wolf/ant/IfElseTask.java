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

public class IfElseTask extends Task {
    private String fileNameExist;

    private Sequential mElse;
    private Sequential mThen;
    private Sequential mIsEqual;
    private Sequential mIsNotEqual;

    private String arg1 = "";
    private String arg2 = "";

    private String mProperty;

    public void execute() throws BuildException {
        if (mIsEqual != null) {
            if (arg1.equals(arg2)) {
                mIsEqual.execute();
            } else {
                if (mElse != null) {
                    mElse.execute();
                }
            }
        } else if (fileNameExist != null) {
            File file = new File(fileNameExist);
            if (file.exists()) {
                if (mThen != null) {
                    mThen.execute();
                }
            } else {
                if (mElse != null) {
                    mElse.execute();
                }
            }
        } else if (mIsNotEqual != null) {
            if (!arg1.equals(arg2)) {
                mIsNotEqual.execute();
            } else {
                if (mElse != null) {
                    mElse.execute();
                }
            }
        }
    }

    public void setOutput(String property) {
        mProperty = property;
    }

    public void setExist(String fileName) {
        this.fileNameExist = fileName;
    }

    public void setArg1(String value) {
        arg1 = value;
    }

    public void setArg2(String value) {
        arg2 = value;
    }

    public Object createThen() {
        mThen = new Sequential();
        return mThen;
    }

    public Object createElse() {
        mElse = new Sequential();
        return mElse;
    }

    public Object createIsEqual() {
        mIsEqual = new Sequential();
        return mIsEqual;
    }

    public Object createIsNotEqual() {
        mIsNotEqual = new Sequential();
        return mIsNotEqual;
    }

    public static class ElseIfTask extends Task {
        public void setArg1(String value) {
        }
        public void setArg2(String value) {
        }
    }
}
