package controller;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Employee;
import datasourse.HibernateConfig;

import datasourse.HibernateConfig;

public class Main {

	private static Session session;

	public static void main(String[] args) {

		//insert employee
//		insertEmployee();

		//update employee
		updateEmployee(23L);

		//update employee
//		deleteEmployee(27L);
//		for(long i=18;i<=22;i++) {
//			deleteEmployee(i);
//		}
		
		List<Employee> emList = getListEmployee(); 
		for(Employee e : emList) {
			System.out.println("FullName: " + e.getFullName() + "   Department: " + e.getDepartment() + "   Position: " + e.getPosition() + "   Level: " + e.getLevel());
		}


	}

	//get list employee
	public static List<Employee> getListEmployee(){
		List<Employee> listEmployee = new ArrayList<Employee>();
		try {
			session = HibernateConfig.buildSessionFactory().openSession();

			session.beginTransaction();
			listEmployee = session.createQuery("select e from Employee e", Employee.class).getResultList();
		} catch (Exception e) {
			System.out.println("Rollback");
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return listEmployee;
	}
	public static void insertEmployee(){
		System.out.println("Start insert data");
		try {
			session = HibernateConfig.buildSessionFactory().openSession();
			session.beginTransaction();
			for (int i=0;i<5;i++){
				Employee em = new Employee("Nhan vien "+i, "Phong "+i, "Vi tri "+i, "Level "+i);
				session.save(em);
			}
			session.getTransaction().commit();
			System.out.println("Insert sucessfully!");
		}catch (Exception e) {
			if (session.getTransaction() != null){
				session.getTransaction().rollback();
			}
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}

	public static void updateEmployee(Long id){
		System.out.println("Start update data");
		try {
			session = HibernateConfig.buildSessionFactory().openSession();
			session.beginTransaction();
			Employee em = session.find(Employee.class, id);
			em.setFullName("Mai Duc Chuong");
			em.setLevel("2.5");
			em.setDepartment("Nghien cuu");
			em.setPosition("Truong phong");


			session.getTransaction().commit();
			System.out.println("Update sucessfully!");
		}catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null){
				session.getTransaction().rollback();
			}
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}
	public static void deleteEmployee(Long id){
		System.out.println("Start delete data");
		try {
			session = HibernateConfig.buildSessionFactory().openSession();
			session.beginTransaction();
			Employee em = session.find(Employee.class, id);
			session.delete(em);

			session.getTransaction().commit();
			System.out.println("Delete sucessfully!");
		}catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null){
				session.getTransaction().rollback();
			}
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}

}
