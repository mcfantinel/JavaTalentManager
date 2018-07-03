package validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import model.Applicants;
import model.ApplicantsSkills;

@Component
public class ApplicantFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Applicants.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "fullName", "empty");
		ValidationUtils.rejectIfEmpty(err, "email", "empty");
		ValidationUtils.rejectIfEmpty(err, "phone", "empty");
		ValidationUtils.rejectIfEmpty(err, "workingTime", "empty");

		Applicants applicant = (Applicants) obj;
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(applicant.getEmail()).matches())) {
			err.rejectValue("email", "invalid");
		}
		
		boolean isAnyApplicantSkill = false;
		for(ApplicantsSkills applicantSkills : applicant.getApplicantSkills()) {
			if (applicantSkills.getScale() > 0) {
				isAnyApplicantSkill = true;
				break;
			}
		}
		if(!isAnyApplicantSkill) {
			err.rejectValue("applicantSkills", "empty");
		}
	}
}
