package pack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {

	@BeforeClass
	public void beforeClass() {
		System.out.println("2");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("1");
	}

	@Test(priority=0)
	public void first() {
		System.out.println("3");
	}

	@Test(priority = 1)
	public void second(){
		System.out.println("4");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("8");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("5");
	}
	


}
class go{
	
	@Test(priority=2)
	public void goOne(){
		
		System.out.println("6");
	}
	
	
	@Test(priority=3)
	public void goTwo(){
		System.out.println("7");
	}
	
	


}
