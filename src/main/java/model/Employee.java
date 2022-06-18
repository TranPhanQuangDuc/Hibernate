package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "department")
	private String department;

	@Column(name = "position")
	private String position;

	@Column(name = "level")
	private String level; 
	
	public Employee(){
		
	}
	
	public Employee(Long id, String fullName, String department, String position, String level) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.level = level; 
	}
	
	public Employee(String fullName, String department, String position, String level) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.level = level; 
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
}