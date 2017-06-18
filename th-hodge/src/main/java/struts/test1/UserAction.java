package struts.test1;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	public String login() throws Exception {
		System.out.println("user login");
		return SUCCESS;
	}

	public String logout() throws Exception {
		System.out.println("user logout");
		return SUCCESS;
	}
}

