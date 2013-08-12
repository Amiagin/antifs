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

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.Sequential;

public class IfElseTask extends Task {

    protected Sequential mElse;
    protected List<ElseIfSequential> mElseIf = null;
    protected Sequential mThen;

    private String []value = null;
	private boolean ignorecase=false;
	private boolean compareState = true;
	
	public IfElseTask() {
		ignorecase = false;
		value = new String[2];
		mElseIf = new ArrayList<ElseIfSequential>();
	}

    public void execute() throws BuildException {
        if (mThen != null) {
            if (matched(value[0],value[1],ignorecase) == compareState) {
                mThen.execute();
            } else {
            	if (mElseIf != null) {
            		boolean matchFound = false;
            		for (ElseIfSequential elseifseq:mElseIf) {
            			if (elseifseq.matched()) {
            				matchFound = true;
            				elseifseq.execute();
            				break;
            			}
            		}
            		if (!matchFound) {
                        if (mElse != null) {
                            mElse.execute();
                        }
                    }
            		
            	}
            }
        }
    }

    public void setInput(String val) {
        value[0] = val;
    }

    public void setEquals(String val) {
    	value[1] = val;
    	compareState = true;
    }
    
    public void setNotEqualTo(String val) {
    	value[1] = val;
    	compareState = false;
    }
	
	public void setIgnoreCase(boolean value) {
	    ignorecase = value;
	}
	
	public void setProperty(String property) {
		String val = getProject().getProperty(property);
		value[0] = val == null ? "" : val;
	}

    public Object createThen() {
        mThen = new Sequential();
        return mThen;
    }

    public Object createElse() {
        mElse = new Sequential();
        return mElse;
    }
	
	public Object createElseIf() {
	    mElseIf.add(new ElseIfSequential());
		return mElseIf.get(mElseIf.size()-1);
	}
	
	private boolean matched(String arg1,String arg2,boolean ignorecase) {
		boolean match = false;
		if (ignorecase) {
			if (arg1.equalsIgnoreCase(arg2)) {
				match = true;
			}
		} else {
		    if (arg1.equals(arg2)) {
		    	match = true;
		    }
		}
		return match;
	}

    public static class ElseIfSequential extends Sequential {
        private String []value = new String[2];
        private boolean ignorecase=false;
        
        public void setInput(String value) {
        	this.value[0] = value;
        }
        public void setEquals(String value) {
        	this.value[1] = value;
        }
        
    	public void setIgnoreCase(boolean value) {
    	    ignorecase = value;
    	}
    	
    	public boolean matched() {
    		boolean match = false;
    		if (ignorecase) {
    			if (value[0].equalsIgnoreCase(value[1])) {
    				match = true;
    			}
    		} else {
    		    if (value[0].equals(value[1])) {
    		    	match = true;
    		    }
    		}
    		return match;
    	}
        
    	public void setProperty(String property) {
    		String val = getProject().getProperty(property);
    		value[0] = val == null ? "" : val;
    	}        
    }
}
