package xpadro.thymeleaf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class GuestDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long personId;

	private String firstName;

	private String lastName;

	private String country;

	public GuestDTO() {
	}

	public GuestDTO(String firstName, String lastName, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long studentId) {
		this.personId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + "]";
	}

}
