package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Student;



public class Studentdao {
    
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void save(Student student)
	{
		entityTransaction.begin();
	entityManager.persist(student);	
	entityTransaction.commit();
	
	}
	
	public Student fetch(String email)
	{
		List<Student> list = entityManager.createQuery("Select x from Student x where email= ?1").setParameter(1, email).getResultList();
		if(list.isEmpty()) {
			return null;
		}else {
			
		return list.get(0);
		}
	}
	
	public Student fetch(long mobile)
	{
		List<Student> list = entityManager.createQuery("Select x from Student x where mobile= ?1").setParameter(1, mobile).getResultList();
		if(list.isEmpty()) {
			return null;
		}else {
		
		return list.get(0);
		}
	}
	
	
	public List<Student> fetch()
	{
		List<Student> list =entityManager.createQuery("Select x from Student x").getResultList();
		return list;
		
	}
	
	public void delete(int id){
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Student.class, id));
		entityTransaction.commit();
	}
	
	public Student fetch(int id){
		return entityManager.find(Student.class, id);
	}
	
	public void update(Student student){
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
	}
	
}