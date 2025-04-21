package aplication;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {


		DepartmentDao dp = DaoFactory.createDepartmentDao();
		
		
		System.out.println("======= teste insert ======");
		Department dp1 = new Department(22, "lunch");
		//dp.insert(dp1);
		System.out.println("insert completed");
		
		System.out.println("======= teste update ======");
		
		Department dp2 = new Department(4, "books");
		dp2.setName("foods");
		dp.upDate(dp2);
		System.out.println("update completed");

		System.out.println("======= teste Delete ======");
		dp.deletById(22);
		System.out.println("delete completed");
		

		System.out.println("======= teste findAll ======");
		List <Department> list = new ArrayList();
		list = dp.findALL();
		list.forEach(System.out::println);
		

	}

}
