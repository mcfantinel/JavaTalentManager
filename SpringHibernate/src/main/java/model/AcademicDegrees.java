package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACADEMIC_DEGREES")
public class AcademicDegrees {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "name", unique = true, length = 50)
	private String name;

	public AcademicDegrees() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
