package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/login")
	public String login() {
		return "login";//璺宠浆鍒扳��/WEB-INF/jsp/login.jsp鈥�
	}
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	@RequestMapping("/transfer")
	public String transfer() {
		return "transfer";
	}
}
