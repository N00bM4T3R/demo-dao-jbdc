package aplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		

	   SellerDao sellerDao = DaoFactory.createSellerDao();
	
	 
	  Department department = new Department(2, null);
	  List<Seller> obj = sellerDao.findByDepartment(department);
	  obj.forEach(System.out::println);
	 
	  System.out.println("======= teste find all========");

		
	  obj = sellerDao.findALL();
	  obj.forEach(System.out::println);
	  
	  System.out.println("======= teste insert========");
	  Seller seller1 = new Seller(2, "greg", "greg@gmail.com", new Date(), 2000.0, department);


	  
	System.out.println("======= teste UPDATE ========");
	Seller seller =  sellerDao.findyId(1);
	seller.setName("martha waine");
	sellerDao.upDate(seller);
	System.out.println("test completed");
	

	System.out.println("======= teste Delete ========");
	
	System.out.println("Enter id from delete : ");
	int id = sc.nextInt();
    sellerDao.deletById(id);
    System.out.println("delete completed");
    sc.close();
	
	
	
	   
	}

}
