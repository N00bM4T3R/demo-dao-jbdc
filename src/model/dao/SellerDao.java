package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
	

	void insert(Seller obj);
	void upDate(Seller obj);
	void deletById(Integer id);
	Seller findyId(Integer id);
	List<Seller> findALL();

}
