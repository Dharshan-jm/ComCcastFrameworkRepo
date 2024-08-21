package listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.baseclassutility.BaseClass;


@Listeners(com.comcast.crm.listenerutility.ClassListenerutility.class)
public class PacticeListenersTest extends BaseClass{
	
	
	@Test
	public void createinvoice() {
		System.out.println("create invoice method");
		String acttitle = driver.getTitle();
		System.out.println(acttitle);
		System.out.println("step-1");
		
		//hard assert
		Assert.assertEquals(acttitle, "login");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	
	}
	
	@Test
	public void createinvoicewithcontact() {
		System.out.println("create invoice with contact method");
		
	}

}
