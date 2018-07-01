package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANIES")
public class Companies {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false, length = 80)
	private String name;

	@Column(name = "phone", nullable = false, length = 20)
	private String phone;

	public Companies() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

}
