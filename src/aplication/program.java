package aplication;

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
	 
	   
	}

}
