package model.dao;

import db.DB;
import model.dao.imple.DepartmentDaoJdbc;
import model.dao.imple.SellerDaoJdbc;
import model.entities.Department;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJdbc(DB.getConnection());
	}
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJdbc(DB.getConnection());
	}


}
