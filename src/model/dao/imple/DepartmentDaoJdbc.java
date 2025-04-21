package model.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbExcepition;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJdbc implements DepartmentDao {
	
	Connection conn;

	public DepartmentDaoJdbc(Connection conn) {
		this.conn = conn;
		
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT "
					 +"INTO department (Id,Name)"
					+ "VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, obj.getId());
			ps.setString(2, obj.getName());
			
			int rows = ps.executeUpdate();
			
			if (rows > 0) {
				
			ResultSet rs = ps.getGeneratedKeys();
					if (rs.next()) {
						int id =rs.getInt(1);
						obj.setId(id);
					}
			
			}}
		catch (SQLException e) {
    throw new DbExcepition(e.getMessage());
			
		}
		
	}

	@Override
	public void upDate(Department obj) {	

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE department\r\n"
					+ "SET Name = ?\r\n"
					+ "WHERE Id = ?");

			ps.setString(1, obj.getName());
			ps.setInt(2, obj.getId());
			
			ps.execute();
			
			
		}
		catch (SQLException e) {
		    throw new DbExcepition(e.getMessage());
		}
	}

	@Override
	public void deletById(Integer id) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			
			ps.setInt(1, id);
			ps.execute();
			
		}
		catch (SQLException e) {
			throw new DbExcepition(e.getMessage());
		}
		
	}

	@Override
	public Department findyId(Integer id) {


		return null;
	}

	@Override
	public List<Department> findALL() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
			rs = ps.executeQuery();
			
			List<Department> list = new ArrayList<>();
			
			
			while(rs.next()) {
				Department dp = new Department(rs.getInt("Id"), rs.getString("Name"));
				list.add(dp);
				
				
			}
			return list;
			
			
			
		}
		catch (SQLException e) {
			throw new DbExcepition(e.getMessage());
			
		}
		
		
	}


}
