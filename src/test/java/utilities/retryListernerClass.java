package utilities;

import java.lang.reflect.Constructor;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IAnnotation;

public class retryListernerClass implements IAnnotationTransformer
{
	public void transforms(IAnnotation testannotation,Class testClass, Constructor testConstructor)
	{
		
		//testannotation.setRetryAnalyzer(Retry)
		
	}
	
}
