package com.selllabs;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SecondTestng extends AnnotTest {
	
	@Test
	public void secondTestng() {
		
		System.out.println("Print Testng");
		Reporter.log("secondTestng",true);
	}

}
