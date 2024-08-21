package com.comcast.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ClassRetryListenerutility implements IRetryAnalyzer{
    
	int startcount=0;
	int endcount=5;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (startcount<endcount) {
			startcount++;
			return true;
			
		}
		return false;
	}

}
