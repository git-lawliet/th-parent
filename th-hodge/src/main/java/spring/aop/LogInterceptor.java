package spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
 
  
@Aspect 
@Component 
public class LogInterceptor {
	@Pointcut("execution(public void spring.aop.UserService.*())")
	public void point() {}
	
	@Before("point()") 
	public void before() {
		System.out.println("method start");
	}
//	@After("execution(public * *..*.*(..))")
	@After("execution(public void spring..*.sayHello(..))")
	public void after() {
		System.out.println("method after");
	}
}
