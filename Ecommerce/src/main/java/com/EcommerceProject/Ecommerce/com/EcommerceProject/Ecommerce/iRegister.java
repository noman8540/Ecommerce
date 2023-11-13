package com.EcommerceProject.Ecommerce.com.EcommerceProject.Ecommerce;

import org.springframework.data.repository.CrudRepository;

public interface iRegister extends CrudRepository<Register, Integer>{
	
	Register findByEmail(String email);

	void save(product p1);
	
	
}
