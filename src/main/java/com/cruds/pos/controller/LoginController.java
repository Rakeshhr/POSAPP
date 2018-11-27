package com.cruds.pos.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cruds.pos.entity.User;
import com.cruds.pos.service.UserService;



@Controller
public class LoginController {
	
	@Autowired
	UserService ser;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET) 
	public String login() {  
	    return "home"; 
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET) 
	public String login1() {  
	    return "login"; 
	}
	
	@RequestMapping(value="/checklogin",method=RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username,@RequestParam("password") String password,RedirectAttributes redirectAttributes, ModelMap model,HttpSession session)
	{
			if(username == null || password == null || username.trim().length() == 0 || password.trim().length() == 0)
			{
				redirectAttributes.addAttribute("error", "Invalid username and password!");
				return "redirect:login";
			}
			
			else
			{
			String user = UserService.authenticateUser(username, password);
			
			if(user == null)
			{
				redirectAttributes.addAttribute("error", "Invalid username and password!");
				return "redirect:login";
			}
			
			else if(user.equals("ADMIN"))
			{
				session.setAttribute("uname",username);
				model.addAttribute("USER", user);
				return "redirect:users.html";
			}
			
			else if (user.equals("POS"))
			{
				
					session.setAttribute("uname",username);
					model.addAttribute("USER", user);
					return "redirect:poshome.html";
			}
			else
			{
				redirectAttributes.addAttribute("error", "Please contact system admin!");
				return "redirect:login";
			}
			
			
			}
		
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET) 
	public String displayLogin(Model model) { 
	    model.addAttribute("user", new User()); 
	    return "signup"; 
	}
	
	@RequestMapping(value = { "/logout"}, method = RequestMethod.GET)
    public String logout(HttpSession session,Model model,RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("logout","You have been logged out successfully.");
		session.invalidate();
		model.asMap().clear();
        return "redirect:login";
    }	
	
	
	
	
	
	
	
	
	
}
