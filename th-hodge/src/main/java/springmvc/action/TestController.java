package springmvc.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.User;
import spring.prop.PropInfo;

@Controller
@RequestMapping("/body")
public class TestController {
	@Autowired 
	private PropInfo info;
	
	@RequestMapping("/ff")
	@ResponseBody
	public User getXX() {
		User u = new User();
//		u.setUsername(info.getXx());
		u.setPassword("bb");
		u.setDate(new Date());
		return u;
	}

}
