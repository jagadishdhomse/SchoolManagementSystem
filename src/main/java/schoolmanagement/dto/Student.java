package schoolmanagement.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Student {

	@Id
	private int id;
	private String name;
	private String dob;
	private String email;
	private String password;
	@OneToMany
	private List<Assignment> assignment;
	public List<Assignment> getAssignment() {
		return assignment;
	}
	public void setAssignment(List<Assignment> assignment) {
		this.assignment = assignment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
