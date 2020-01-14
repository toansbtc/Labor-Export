package com.toan.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.toan.model.Partner;
import com.toan.model.labor;
import com.toan.service.LaborService;
import com.toan.service.PartnerService;
import com.toan.service.UserService;

@Controller
public class PartnerController {
	@Autowired
	PartnerService service;
	@Autowired
	UserService user;
	@Autowired
	LaborService laborsv;

	//open company page
	@RequestMapping(value="partner")
	public String insert()
	{
		return "partner";
	}
	
	//get all company
		@RequestMapping(value="getallcompany",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<Partner> getallcompany()
		{
			return service.getlistPartners();
		}
	
	//add a company
	@RequestMapping(value="insertpartner")
	public void insert(@ModelAttribute(value = "company") Partner partner)
	{
		service.insert(partner);
	}
	
	//get all labor on a company
	@RequestMapping(value="getlabortcompany/{id}")
	public ModelAndView getlabors(@PathVariable(value = "id") int id)
	{
		
		ModelAndView model = new ModelAndView("LaborCompany");
		List<labor> list = new ArrayList<labor>();
		for (labor person : laborsv.getlistlabor())
			if (person.getCompanyid() == id)
				list.add(person);
		model.addObject("Labor", list);
		model.addObject("namecompany", service.getpartner(id).getNamecompany());
		return model;
	}
	
	//delete a company
	@RequestMapping(value="deletepartner")
	public void insert(@RequestParam(value = "id") int id)
	{
		service.delete(id);
		for(labor person:laborsv.getlistlabor())
			if(person.getCompanyid()==id)
				laborsv.delete(person.getlaborid());
	}
	
	@RequestMapping(value="updatepartner")
	public void update(@ModelAttribute(value = "company") Partner partner)
	{
		service.update(partner);
	}
	
	@RequestMapping(value="getpartner")
	public void insert(@RequestParam(value="id") int id,ModelMap model)
	{
		model.addAttribute("labor", service.getpartner(id));
	}
}
