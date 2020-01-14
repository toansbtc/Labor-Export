package com.toan.controler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.toan.model.Partner;
import com.toan.model.login;
import com.toan.service.LaborService;
import com.toan.service.PartnerService;
import com.toan.service.UserService;

@Controller
@SessionAttributes("user")
public class HomeController {
	
	@Autowired
	PartnerService service;
	@Autowired
	UserService user;
	@Autowired
	LaborService laborsv;

	
	@RequestMapping(value = "/home")
	public String showIndex()
	
	{
		return "home";
	}
	
	@RequestMapping(value="getpartnerlist",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Partner> listpartner()
	{
		List<Partner> list=new ArrayList<Partner>();
		for(Partner partner:service.getlistPartners())
		{
			if(partner.getNumgot()<partner.getNumneed())
				list.add(partner);
			System.out.print(1);
		}
		return list;
		
	}
	
	@RequestMapping(value="search",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Partner> searchpartner(@RequestParam String company)
	{
		List<Partner> list=new ArrayList<Partner>();
		if(company!="") {
			
			for(Partner partner:service.getlistPartners())
			{
				if(partner.getNamecompany().contains(company))
					list.add(partner);
			}
		}
		else
		{
			for(Partner partner:service.getlistPartners())
			{
				if(partner.getNumgot()<partner.getNumneed())
					list.add(partner);
				System.out.print(1);
			}
		}
		return list;
		
	}
	
	@RequestMapping(value = "check",method = RequestMethod.GET)
	public String check(@RequestParam(value = "username") String username,@RequestParam(value="password") String password,ModelMap view,HttpSession session)
	{
		
		String page="";
		ModelMap model=new ModelMap();
		
		if(username!=""&&password!="")
		{

			for(login login:user.getuser())
			
			if(login.getUsername().equals(username) && login.getPassword().equals(password))
			{
				//model.addAttribute("username",username);
				session.setAttribute("username", username);
				page="redirect:home";break;
			}
			else
			{
				view.addAttribute("mgs","Username or Password is something wrong!");
				page="index";
			}
		}
		else
		{
			view.addAttribute("mgs","please enter all information!");
			page="index";
		}
		
		return page;
	}
	@RequestMapping(value = "OpenAddLabor/{id}", method=RequestMethod.GET)
	public String OpenAddLabor(ModelMap model,@PathVariable("id") int IdCompany)
	{
		
		model.addAttribute("id", IdCompany);
		return "laborr";
	}
}
