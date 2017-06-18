package spring.aop;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public void sayHello() {
		System.out.println("hello ~~ ");
	}

}
