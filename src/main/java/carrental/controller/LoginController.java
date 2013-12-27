package carrental.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HelloWorld");
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");
		HttpSession session = request.getSession();
		session.setAttribute("user", name);

		Cookie loginCookie = new Cookie("user",name);
		//setting cookie to expiry in 30 mins
		loginCookie.setMaxAge(30*60);//seconds
		response.addCookie(loginCookie);


		return "index";

	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";

	}

	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

		return "login";

	}

}