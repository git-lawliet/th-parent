package struts.test1;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	public String login() throws Exception {
		System.out.println("admin login");
		return SUCCESS;
	}

	public String logout() throws Exception {
		System.out.println("admin logout");
		return SUCCESS;
	}
}

