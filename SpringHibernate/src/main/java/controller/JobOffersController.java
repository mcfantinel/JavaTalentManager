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
import model.Companies;
import model.JobOffers;
import model.JobOffersSkills;
import model.Skills;
import service.AcademicDegreesService;
import service.ApplicantsService;
import service.CompaniesService;
import service.JobOffersService;
import service.SkillsService;
import validators.JobOfferFormValidator;

@Controller
public class JobOffersController {

	@Autowired
	private JobOfferFormValidator jobOfferValidator;

	@InitBinder("jobOffer")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(jobOfferValidator);
	}

	private JobOffersService jobOffersService;
	private ApplicantsService applicantsService;
	private AcademicDegreesService academicDegreesService;
	private CompaniesService companiesService;
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
	public void setAcademicDegreesService(AcademicDegreesService service) {
		this.academicDegreesService = service;
	}

	@Autowired(required = true)
	@Qualifier(value = "companiesService")
	public void setCompaniesService(CompaniesService service) {
		this.companiesService = service;
	}

	@Autowired(required = true)
	@Qualifier(value = "skillsService")
	public void setSkillsServiceService(SkillsService service) {
		this.skillsService = service;
	}

	@RequestMapping(value = "/jobOffers/listJobOffers", method = RequestMethod.GET)
	public String listJobOffers(Model model) {
		model.addAttribute("listJobOffers", this.jobOffersService.listJobOffers());
		return "listJobOffers";
	}

	@RequestMapping(value = "/jobOffers/addJobOffers", method = RequestMethod.GET)
	public String addJobOffers(Model model) {
		model.addAttribute("jobOffer", new JobOffers());

		Map<Long, String> academicDegreesList = new HashMap<>();
		List<AcademicDegrees> academicDegrees = academicDegreesService.listAcademicDegrees();
		for (AcademicDegrees a : academicDegrees) {
			academicDegreesList.put(a.getId(), a.getName());
		}
		model.addAttribute("academicDegreesList", academicDegreesList);

		Map<Long, String> companiesList = new HashMap<>();
		List<Companies> companies = companiesService.listCompanies();
		for (Companies c : companies) {
			companiesList.put(c.getId(), c.getName());
		}
		model.addAttribute("companiesList", companiesList);

		List<Skills> skills = skillsService.listSkills();
		model.addAttribute("skillsList", skills);

		return "addJobOffers";
	}

	@RequestMapping(value = "/jobOffers/addJobOffers", method = RequestMethod.POST)
	public String addJobOffers(@ModelAttribute("jobOffer") @Validated JobOffers jobOffer, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			Map<Long, String> academicDegreesList = new HashMap<>();
			List<AcademicDegrees> academicDegrees = academicDegreesService.listAcademicDegrees();
			for (AcademicDegrees a : academicDegrees) {
				academicDegreesList.put(a.getId(), a.getName());
			}
			model.addAttribute("academicDegreesList", academicDegreesList);

			List<Skills> skills = skillsService.listSkills();
			model.addAttribute("skillsList", skills);
			return "addJobOffers";
		}

		List<JobOffersSkills> jobOfferSkillsToRemove = new ArrayList<JobOffersSkills>();
		List<JobOffersSkills> jobOfferSkills = jobOffer.getJobOfferSkills();
		for (int i = 0; i < jobOfferSkills.size(); i++) {
			if (jobOfferSkills.get(i).getScale() == 0) {
				jobOfferSkillsToRemove.add(jobOfferSkills.get(i));
			}
		}
		jobOffer.getJobOfferSkills().removeIf(x -> jobOfferSkillsToRemove.contains(x));

		this.jobOffersService.addJobOffer(jobOffer);
//		if (jobOffer.getId() == 0) {
//			// new person, add it
//			this.jobOffersService.addJobOffer(jobOffer);
//		} else {
//			// existing person, call update
//			this.jobOffersService.updateJobOffer(jobOffer);
//		}

		return "redirect:/jobOffers/listJobOffers";

	}

	@RequestMapping("/jobOffers/show/{id}")
	public String showJobOffer(@PathVariable("id") long id, Model model) {
		JobOffers jobOffer = this.jobOffersService.getJobOfferById(id);
		model.addAttribute("showJobOffer", jobOffer);
		model.addAttribute("qualifiedApplicants", this.applicantsService.getApplicantsForJobOffer(jobOffer));
		return "showJobOffer";
	}

	@RequestMapping("/jobOffers/remove/{id}")
	public String removeJobOffer(@PathVariable("id") long id) {
		this.jobOffersService.removeJobOffer(id);
		return "redirect:/jobOffers/listJobOffers";
	}

}
