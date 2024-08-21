package assertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssertTest {

	
	@Test
	public void HardAssertTest() {
		SoftAssert soft=new SoftAssert();
		
		System.out.println(1);
		System.out.println(2);
		soft.assertEquals("ca", "car"); 
		System.out.println(3);
		System.out.println(4);
		soft.assertEquals("bike", "bike");
		System.out.println(5);
		soft.assertAll();
		System.out.println(6);
	}
	
	@Test
	public void HardAssertTest1() {
		SoftAssert soft=new SoftAssert();
		System.out.println(11);
		System.out.println(21);
		soft.assertEquals("car", "car");
		System.out.println(31);
		System.out.println(41);
		soft.assertEquals("bike", "bike");
		System.out.println(51);
		soft.assertAll();
		System.out.println(61);
	}
}
