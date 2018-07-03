package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.AcademicDegrees;
import model.Applicants;
import model.ApplicantsSkills;
import model.Skills;
import service.AcademicDegreesService;
import service.ApplicantsService;
import service.JobOffersService;
import service.SkillsService;
import validators.ApplicantFormValidator;

@Controller
public class ApplicantsController {

	@Autowired
	private ApplicantFormValidator applicantValidator;

	@InitBinder("applicant")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(applicantValidator);
	}

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

		model.addAttribute("academicDegreesList", getAcademicDegreesList());

		model.addAttribute("skillsList", getSkillsList());

		return "addApplicants";
	}

	@RequestMapping(value = "/applicants/addApplicants", method = RequestMethod.POST)
	public String addApplicants(@ModelAttribute("applicant") @Validated Applicants applicant,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("academicDegreesList", getAcademicDegreesList());

			model.addAttribute("skillsList", getSkillsList());
			return "addApplicants";
		}

		removeSkillsUnused(applicant);

		this.applicantsService.addApplicant(applicant);

		return "redirect:/applicants/listApplicants";

	}

	@RequestMapping("/applicants/show/{id}")
	public String showApplicant(@PathVariable("id") long id, Model model) {
		Applicants applicant = this.applicantsService.getApplicantById(id);
		model.addAttribute("showApplicant", applicant);
		model.addAttribute("qualifiedJobOffers", this.jobOffersService.getJobOffersForApplicant(applicant));
		return "showApplicant";
	}

	@RequestMapping("/applicants/remove/{id}")
	public String removeApplicant(@PathVariable("id") long id) {
		this.applicantsService.removeApplicant(id);
		return "redirect:/applicants/listApplicants";
	}
	
	private void removeSkillsUnused(Applicants applicant) {
		List<ApplicantsSkills> applicantSkillsToRemove = new ArrayList<ApplicantsSkills>();
		List<ApplicantsSkills> applicantSkills = applicant.getApplicantSkills();
		for (int i = 0; i < applicantSkills.size(); i++) {
			if (applicantSkills.get(i).getScale() == 0) {
				applicantSkillsToRemove.add(applicantSkills.get(i));
			}
		}
		applicant.getApplicantSkills().removeIf(x -> applicantSkillsToRemove.contains(x));
	}

	private Map<Long, String> getAcademicDegreesList() {
		Map<Long, String> academicDegreesList = new HashMap<>();
		List<AcademicDegrees> academicDegrees = academicDegreesService.listAcademicDegrees();
		for (AcademicDegrees a : academicDegrees) {
			academicDegreesList.put(a.getId(), a.getName());
		}
		return academicDegreesList;
	}
	
	private List<Skills> getSkillsList() {
		List<Skills> skills = skillsService.listSkills();
		return skills;
	}


}
