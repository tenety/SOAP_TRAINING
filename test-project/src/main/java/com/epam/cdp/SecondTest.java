package com.epam.cdp;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations="classpath:context.xml")
public class SecondTest extends AbstractTestNGSpringContextTests {
	@Value("${testprop}")
	private String testprop;
	
	@Test
	public void firstMethod(){
		System.out.println(testprop);
		Assert.assertTrue(true);
	}
	
}
