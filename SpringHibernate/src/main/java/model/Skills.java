package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SKILLS")
public class Skills {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "skill", unique = true, length = 50, nullable = false)
	private String skill;

	public Skills() {
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Long getId() {
		return id;
	}

}
