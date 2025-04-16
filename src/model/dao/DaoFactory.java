package model.dao;

import db.DB;
import model.dao.imple.SellerDaoJdbc;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJdbc(DB.getConnection());
	}

}
