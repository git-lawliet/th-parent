package spring.aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	@Test
	public void test() { 
		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		UserService u = (UserService) c.getBean("userService");
		u.sayHello();
	}

}
