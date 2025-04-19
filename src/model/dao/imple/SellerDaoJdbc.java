package model.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
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
	
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO seller\r\n"
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)\r\n"
					+ "VALUES\r\n"
					+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS );
		
			
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getEmail());
			ps.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			ps.setDouble(4, obj.getBaseSalary());
			ps.setInt(5,obj.getDepartment().getId());
			
			long rows = ps.executeUpdate();
			if (rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id =rs.getInt(1);
					obj.setId(id);
				}
			}
			else {
				throw new DbExcepition("rows not afeccted, unexplicabe erro");
			}
		}
		catch (SQLException e) {
			throw new DbExcepition(e.getMessage());
		}
		finally {
			DB.closeStaman(ps);;
		}
		
		
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
			
			       ps = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName"
					+ " FROM seller INNER JOIN department"
					+ " ON seller.DepartmentId = Department.Id"
					+ " WHERE seller.Id = ?");
			       
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
		
		PreparedStatement ps = null;
	     ResultSet rs = null;
	  
	     try {
	    	 
	    	 
	    	  ps = conn.prepareStatement("SELECT seller.*,department.Name as DepName\r\n"
	    	  		+ "FROM seller INNER JOIN department\r\n"
	    	  		+ "ON seller.DepartmentId = department.Id\r\n"
	    	  		+ "ORDER BY Name");
	    	  
	    	 rs = ps.executeQuery();
	    	   List<Seller> list = new ArrayList<>();
	    	 
	    	 while(rs.next()) {
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
		    	  list.add(sl);
		    	
	    		 
	    		 
	    	 }
	    	  return list;
	}
	     catch (SQLException e) {
	    throw new DbExcepition(e.getMessage());
		}}

	@Override
	public List<Seller> findByDepartment(Department department) {
		
     PreparedStatement ps = null;
     ResultSet rs;
     List<Seller> list = new ArrayList<>();
     try {
    	 
    	 
    	  ps = conn.prepareStatement("SELECT seller.*,department.Name as DepName\r\n"
    	  		+ "FROM seller INNER JOIN department\r\n"
    	  		+ "ON seller.DepartmentId = department.Id\r\n"
    	  		+ "WHERE seller.Id = ?");
    	 
 
    	 ps.setInt(1, department.getId());
    	 rs = ps.executeQuery();
    	 
    	 
    	 while(rs.next()) {
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
	    	  list.add(sl);
	    	 
    		 
    		 
    		 
    	 }
    	 return list;
    	 
    	 
    	 
    	 
    	 
     }
     catch (SQLException e) {
		throw new DbExcepition(e.getMessage());
	}
		
	}

}
