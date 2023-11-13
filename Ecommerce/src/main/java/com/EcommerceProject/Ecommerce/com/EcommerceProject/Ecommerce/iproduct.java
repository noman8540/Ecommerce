package com.EcommerceProject.Ecommerce.com.EcommerceProject.Ecommerce;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface iproduct extends CrudRepository<product, Integer>{
////	List<product> findByName(String name);
	product findById(int id);
}
