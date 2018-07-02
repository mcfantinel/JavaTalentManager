package controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.AcademicDegrees;
import model.Applicants;
import model.ApplicantsSkills;
import model.QualifiedJobOffers;
import model.Skills;
import service.AcademicDegreesService;
import service.ApplicantsService;
import service.JobOffersService;
import service.SkillsService;

@Controller
public class ApplicantsController {

	private ApplicantsService applicantsService;
	private JobOffersService jobOffersService;
	private AcademicDegreesService academicDegreesService;
	private SkillsService skillsService;

	@Autowired(required = true)
	@Qualifier(value = "jobOffersService")
	public void setJobOffersService(JobOffersService service) {
		this.jobOffersService = service;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "applicantsService")
	public void setApplicantsService(ApplicantsService service) {
		this.applicantsService = service;
	}

	@Autowired(required = true)
	@Qualifier(value = "academicDegreesService")
	public void setAcademicDegreesServiceService(AcademicDegreesService service) {
		this.academicDegreesService = service;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "skillsService")
	public void setSkillsServiceService(SkillsService service) {
		this.skillsService = service;
	}

	@RequestMapping(value = "/applicants/listApplicants", method = RequestMethod.GET)
	public String listApplicants(Model model) {
		model.addAttribute("listApplicants", this.applicantsService.listApplicants());
		return "listApplicants";
	}

	@RequestMapping(value = "/applicants/addApplicants", method = RequestMethod.GET)
	public String addApplicants(Model model) {
		model.addAttribute("applicant", new Applicants());

		Map<Long, String> academicDegreesList = new HashMap<>();
		List<AcademicDegrees> academicDegrees = academicDegreesService.listAcademicDegrees();
		for (AcademicDegrees a : academicDegrees) {
			academicDegreesList.put(a.getId(), a.getName());
		}
		model.addAttribute("academicDegreesList", academicDegreesList);
		
		model.addAttribute("applicantSkills", new ApplicantsSkills());		
		Map<Long, String> skillsList = new HashMap<>();
		List<Skills> skills = skillsService.listSkills();
		for (Skills s : skills) {
			skillsList.put(s.getId(), s.getSkill());
		}
		model.addAttribute("skillsList", skillsList);
		
		return "addApplicants";
	}

	@RequestMapping(value = "/applicants/addApplicants", method = RequestMethod.POST)
	public String addApplicants(@ModelAttribute("applicant") Applicants applicant) {

		this.applicantsService.addApplicant(applicant);
//		if (applicant.getId() == 0) {
//			// new person, add it
//			this.applicantsService.addApplicant(applicant);
//		} else {
//			// existing person, call update
//			this.applicantsService.updateApplicant(applicant);
//		}

		return "redirect:/applicants/listApplicants";

	}
	
	@RequestMapping("/applicants/show/{id}")
    public String showPerson(@PathVariable("id") long id, Model model){
		Applicants applicant = this.applicantsService.getApplicantById(id);
        model.addAttribute("applicant", applicant);
        model.addAttribute("qualifiedJobOffers", this.jobOffersService.getJobOffersForApplicant(applicant));
        return "showApplicant";
    }
	
	@RequestMapping("/applicants/remove/{id}")
    public String removePerson(@PathVariable("id") long id){
        this.applicantsService.removeApplicant(id);
        return "redirect:/listApplicants";
    }

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		return "test";
	}

}
