package listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetryListenersTest {

	@Test(retryAnalyzer = com.comcast.crm.listenerutility.ClassRetryListenerutility.class)
	public void createinvoice() {
	
		//hard assert
		Assert.assertEquals("data", "login");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
}
}
