package day44;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependecyMethod {
	
	@Test(priority=1)
	void openApp() {
		Assert.assertTrue(true);
	}
	
	@Test(priority=2, dependsOnMethods= {"openApp"})
	void login() {
		Assert.assertTrue(false);
	}
	
	@Test(priority=3, dependsOnMethods= {"openApp", "login"})
	void search() {
		
	}
	@Test(priority=4, dependsOnMethods= {"openApp", "login"})
	void adsearch() {
		
	}
	@Test(priority=5, dependsOnMethods= {"login"})
	void logout() {
		
	}
	
}
