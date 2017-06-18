package spring.prop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropTest {
	
	@Test 
	public void test() { 
		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml" );
		PropInfo propInfo = (PropInfo)c.getBean("propInfo");
		System.out.println(propInfo.getUsername());
		System.out.println(propInfo.getDb());
	}

}
