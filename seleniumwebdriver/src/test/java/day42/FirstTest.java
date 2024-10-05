package day42;

import org.testng.annotations.Test;

public class FirstTest {
	
	@Test
	void openApp() {
		System.out.println("opening app");
	}
	
	@Test(priority=1)
	void login() {
		System.out.println("login");
	}
	
	@Test(priority=2)
	void logout() {
		System.out.println("logout");
	}

}
