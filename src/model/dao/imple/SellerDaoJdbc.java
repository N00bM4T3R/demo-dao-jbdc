package model.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import db.DbExcepition;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJdbc implements SellerDao {
	
	Connection conn ; 
	
	public SellerDaoJdbc(Connection conn) {
		this.conn = conn;
		
	}
 
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upDate(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findyId(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			try {
			       ps = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName"
					+ " FROM seller INNER JOIN department"
					+ " ON seller.DepartmentId = Department.Id"
					+ " WHERE seller.Id = ?");
			       
			       ps.setInt(1, id);
			       rs = ps.executeQuery();
			}
			catch (SQLException e) {
				System.out.println("erro em prepareStatment");
			}
			ps.setInt(1, id);
			rs = ps.executeQuery();
			       if(rs.next()) {
			    	   Department dp = new Department();
			    	   dp.setId(rs.getInt("DepartmentId"));
			    	   dp.setName(rs.getString("DepName"));
			    	   Seller sl = new Seller();
			    	   sl.setId(rs.getInt("Id"));
			    	   sl.setName(rs.getString("Name"));
			    	   sl.setEmail(rs.getString("Email"));
			    	   sl.setBirthDate(rs.getDate("BirthDate"));
			    	   sl.setBaseSalary(rs.getDouble("BaseSalary"));
			    	  sl.setDepartment(dp);
			    	  return sl;
			    	   
			       }
			       return null;
			
		}
		catch (SQLException e) {
			throw new DbExcepition(e.getMessage());
		}
		
		
		
	}

	@Override
	public List<Seller> findALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
