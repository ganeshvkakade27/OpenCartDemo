package RerunAutomation;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunAutoScripts implements IRetryAnalyzer{

	
	private int retrycount=0;
	private static final int maxcount=5;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(retrycount<maxcount)
		{
			System.out.println("Retrying:"+result.getName());
			retrycount++;
			return true;
		}
		
		
		
		
		return false;
	}

}
