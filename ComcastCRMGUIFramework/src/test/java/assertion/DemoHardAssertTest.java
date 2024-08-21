package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoHardAssertTest {

	
	@Test
	public void HardAssertTest() {
		System.out.println(1);
		System.out.println(2);
		Assert.assertEquals("ca", "car"); //fail
		System.out.println(3);
		System.out.println(4);
		Assert.assertEquals("bike", "bike");
		System.out.println(5);
		System.out.println(6);
	}
	
	@Test
	public void HardAssertTest1() {
		System.out.println(11);
		System.out.println(21);
		Assert.assertEquals("car", "car");
		System.out.println(31);
		System.out.println(41);
		Assert.assertEquals("bike", "bike");
		System.out.println(51);
		System.out.println(61);
	}
}
