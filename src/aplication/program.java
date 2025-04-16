package aplication;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class program {

	public static void main(String[] args) {
		
		

	   SellerDao sellerDao = DaoFactory.createSellerDao();
	   
	  Seller seller = sellerDao.findyId(3);
	   
	   System.out.println(seller);
	}

}
