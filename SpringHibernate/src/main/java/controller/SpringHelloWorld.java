package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import database.dao.UsersDao;
import model.Users;

@Controller
public class SpringHelloWorld {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}

	@RequestMapping("/users")
	public ModelAndView showUsers() {
		List<Users> users = UsersDao.getUsers();

		return new ModelAndView("listUsers", "users", users);
	}
	
	@RequestMapping("/users/add")
	public ModelAndView addUsers(Model model) {
		model.addAttribute("userForm", new Users());
		return new ModelAndView("addUser");
	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	public String addUsers(@ModelAttribute("userForm") Users user) {

		System.out.println(user.getUsername());
		//UserDao.addUser(user);

		return "redirect:/users";

	}
	
	

}
