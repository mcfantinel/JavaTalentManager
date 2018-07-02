package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Applicants;
import service.ApplicantsService;

@Controller
public class ApplicantsController {

	private ApplicantsService applicantsService;
	
	@Autowired(required=true)
	@Qualifier(value="applicantsService")
	public void setApplicantsService(ApplicantsService ps){
		this.applicantsService = ps;
	}

	@RequestMapping(value = "/applicants", method = RequestMethod.GET)
	public String listApplicants(Model model) {
		//model.addAttribute("applicant", new Applicants());
		model.addAttribute("listApplicants", this.applicantsService.listApplicants());
		return "listApplicants";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		return "test";
	}

}
