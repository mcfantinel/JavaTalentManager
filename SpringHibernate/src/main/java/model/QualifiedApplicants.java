package model;

public class QualifiedApplicants {

	private Applicants applicant;

	private int totalPoints;

	public QualifiedApplicants(Applicants applicant, int totalPoints) {
		this.applicant = applicant;
		this.totalPoints = totalPoints;
	}

	public Applicants getApplicant() {
		return applicant;
	}

	public int getTotalPoints() {
		return totalPoints;
	}
	
	

}
