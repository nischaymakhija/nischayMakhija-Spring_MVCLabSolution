package studentmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentid;
	private String name;
	private String departement;
	private String country;
	
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public Student() {
		
	}
	
	
	public Student(String name, String departement, String country) {
		super();
		this.name = name;
		this.departement = departement;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Student Details: \nName: "+name+"\nDepartment: "+departement+"\nCountry: "+country;
	}	

}
