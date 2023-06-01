package com.coding.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.coding.web.models.Student;

public interface IStudentRepository extends CrudRepository<Student, Long>{
	List<Student> findAll();
	
	@Query(value="SELECT p.* FROM students p LEFT OUTER JOIN contacts l ON p.id = l.contact_id WHERE l.id IS NULL", nativeQuery=true)
	List<Student> findByNoContact();
//	
	List<Student> findByContactIdIsNull();
}
