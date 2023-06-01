package com.coding.web.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coding.web.models.Contact;

public interface IContactRepository extends CrudRepository<Contact, Long>{
	public List<Contact> findAll();
	
	public Contact findTopByOrderByDireccionDesc();
}
