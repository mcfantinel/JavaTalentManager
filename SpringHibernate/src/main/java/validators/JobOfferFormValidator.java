package validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import model.JobOffers;
import model.JobOffersSkills;

@Component
public class JobOfferFormValidator implements Validator  {
	
	@Override
	public boolean supports(Class<?> paramClass) {
		return JobOffers.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "name", "empty");
		ValidationUtils.rejectIfEmpty(err, "description", "empty");
		ValidationUtils.rejectIfEmpty(err, "workingTime", "empty");

		JobOffers jobOffer = (JobOffers) obj;
		
		if(jobOffer.getMinSalary() >= jobOffer.getMaxSalary()) {
			err.rejectValue("minSalary", "invalid");
		}
		
		boolean isAnyJobOfferSkill = false;
		for(JobOffersSkills jobOfferSkills : jobOffer.getJobOfferSkills()) {
			if (jobOfferSkills.getScale() > 0) {
				isAnyJobOfferSkill = true;
				break;
			}
		}
		if(!isAnyJobOfferSkill) {
			err.rejectValue("jobOfferSkills", "empty");
		}
	}

}
