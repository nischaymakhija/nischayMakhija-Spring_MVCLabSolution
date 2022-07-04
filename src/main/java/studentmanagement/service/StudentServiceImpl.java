package studentmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import studentmanagement.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {

private SessionFactory sessionfactory;
	
	private Session session;
	
	
	public StudentServiceImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;		
		try {
			session=this.sessionfactory.getCurrentSession();
			
		} catch (HibernateException e) {
			session=this.sessionfactory.openSession();
		}
	}


	@Transactional
	public List<Student> findAll()
	{
		List<Student> studentList=session.createQuery("from Student").list();
		return studentList;
	}
	
	@Transactional
	public Student findById(Integer id)
	{
		Student student=session.get(Student.class, id);		
		return student;
	}
	
	@Transactional
	public void save(Student student)
	{
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(student);
		tr.commit();
	}

	@Transactional
	public void delete(Student b) {
		Transaction tr=session.beginTransaction();
		session.delete(b);
		tr.commit();
	}


	@Transactional
	public List<Student>findByName_Departement(String name, String departement) {
		List<Student> studentList=null;
		String query="";
		if(name.length()!=0 && departement.length()!=0)
			query="from Student where name like '%"+name+"%' and departement like '%"+departement+"%'";
		else if(name.length()==0 && departement.length()!=0)
			query="from Student where author like '%"+departement+"%'";
		else if(name.length()!=0 && departement.length()==0)
			query="from Student where title like '%"+name+"%'";
		else
			query="from Student";
		if(query.length()!=0)
		{
			studentList=session.createQuery(query).list();
		}
		return studentList;
	}
}
