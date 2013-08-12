package com.wolf.ant;

/***************************************************************************************************
 * AntIfs
 * Custom Ant Task
 *
 * @version: v1.0.1
 * @author:  Cris del Rosario
 * Git       https://github.com/Amiagin/antifs.git
 * 
 ***************************************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.Sequential;

public class SwitchTask extends Task {
	private String value = "";
	private List<CaseSequential> mCase;
	private Sequential mDefault;
	private boolean ignorecase = false;
	
	public SwitchTask() {
		value = "";
		mCase = new ArrayList<CaseSequential>();
	}
	
	public void execute() throws BuildException {
		if (mCase != null) {
			boolean foundMatch = false;
			for (CaseSequential caseTask:mCase) {
				if (caseTask.isEqualTo(value,ignorecase)) {
					caseTask.execute();
					foundMatch = true;
					break;
				}
			}
			
			if (!foundMatch) {
				if (mDefault != null) {
					mDefault.execute();
				}
			}
		}
	}
	
	public void setInput(String value) {
		this.value = value;
	}
	
	public void setIgnoreCase(boolean value) {
	    ignorecase = value;
	}
	
	public void setProperty(String property) {
		if (getProject().getProperty(property) != null) {
			this.value = getProject().getProperty(property);
		} else {
			this.value = "";
		}
	}
	
	public Object createCase() {
		mCase.add(new CaseSequential());
		return mCase.get(mCase.size()-1);
	}
	
	public Object createDefault() {
		mDefault = new Sequential();
		return mDefault;
	}
	
	public class CaseSequential extends Sequential {
		private String value = "";		
		
		public boolean isEqualTo(String value,boolean ignorecase) {
			if (ignorecase) {
			    if (this.value.equalsIgnoreCase(value)) {
			    	return true;
			    }
			} else {
			    if (this.value.equals(value)) {
				    return true;
			    }
			}
			
			return false;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
