package studentmanagement.service;

import java.util.List;

import studentmanagement.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public void save(Student b);
	public Student findById(Integer id);
	public void delete(Student b);
	public List<Student> findByName_Departement(String name, String departement);

}
