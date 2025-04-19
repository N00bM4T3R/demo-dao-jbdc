package aplication;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class program {

	public static void main(String[] args) {
		
		

	   SellerDao sellerDao = DaoFactory.createSellerDao();
	
	 
	  Department department = new Department(2, null);
	  List<Seller> obj = sellerDao.findByDepartment(department);
	  obj.forEach(System.out::println);
	 
	  System.out.println("======= teste find all========");

		
	  obj = sellerDao.findALL();
	  obj.forEach(System.out::println);
	  System.out.println("======= teste insert========");
	  Seller seller1 = new Seller(2, "greg", "greg@gmail.com", new Date(), 2000.0, department);


	  sellerDao.insert(seller1);
	  System.out.println(seller1);
	   
	}

}
