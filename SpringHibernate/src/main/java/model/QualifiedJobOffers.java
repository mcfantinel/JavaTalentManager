package model;

public class QualifiedJobOffers {
	
	private JobOffers jobOffer;
	
	private int totalPoints;

	public QualifiedJobOffers(JobOffers jobOffer, int totalPoints) {
		this.jobOffer = jobOffer;
		this.totalPoints = totalPoints;
	}

	public JobOffers getJobOffer() {
		return jobOffer;
	}

	public int getTotalPoints() {
		return totalPoints;
	}
	
	

}
