package com.toan.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

@Controller
public class LaborController {

	@Autowired
	LaborService laborService;
	@Autowired
	PartnerService parsv;
	
	//get all labors
			@RequestMapping(value="getalllabor",method = RequestMethod.GET, produces = "application/json")
			public @ResponseBody List<labor> getallcompany()
			{
				return laborService.getlistlabor();
			}
	
	@RequestMapping(value="OpenAddLabor/savelabor")
	public String insert(@RequestParam("idcompany") String idcompany,@RequestParam("nameoflabor") String nameoflabor,
			@RequestParam("gender") String gender,@RequestParam("born") String born
			,@RequestParam("address") String address,@RequestParam("phone") String phone,@RequestParam("level") String level)
	{
		
		labor labor=new labor(0, nameoflabor, gender, born, address, phone, level, Integer.parseInt(idcompany));
		laborService.insert(labor);
		Partner partner=parsv.getpartner(Integer.parseInt(idcompany));
		
		int count=partner.getNumgot()+1;
		
		partner.setNumgot(count);
		
		parsv.update(partner);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value="updatelabor")
	public void update(@ModelAttribute("laborupdate") labor labor)
	{
		laborService.insert(labor);
	}
	
	@RequestMapping(value="getlabortcompany/deletelabor/{id}")
	public String delete(@PathVariable("id") int id)
	{
		System.out.print(laborService.getLabor(id).getCompanyid()+"sao khong thay");		
		int idcompany;
		
		idcompany=laborService.getLabor(id).getCompanyid();
		
		laborService.delete(id);
		
		System.out.print(idcompany+"sao khong thay");
		
		Partner partner=parsv.getpartner(idcompany);
		
		int count=partner.getNumgot()-1;
		
		partner.setNumgot(count);
		
		parsv.update(partner);
		
		//return "partner";
		return "redirect:/home";
	}
	
	@RequestMapping(value="getlabor")
	public void insert(@RequestParam(value="id") int id,ModelMap model)
	{
		model.addAttribute("labor", laborService.getLabor(id));
	}
	
	@RequestMapping(value="labor")
	public ModelAndView getfulllabors(Model model)
	{
		ModelAndView view =new ModelAndView("AllLabors");
		view.addObject("labor", laborService.getlistlabor());
		return view;
	}
	
}
