package com.coding.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.web.models.Contact;
import com.coding.web.models.Student;
import com.coding.web.repositories.IContactRepository;
import com.coding.web.repositories.IStudentRepository;

@Service
public class MainService {
	@Autowired
	private IStudentRepository studentRepo;
	@Autowired
	private IContactRepository contactRepo;
	

	public Student getStudent(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	public Student crearEstudiante(Student student) {
		return studentRepo.save(student);
	}
	
	public List<Student> todosEstudiantes(){
		return studentRepo.findAll();
	}

	public List<Student> obtenerNoContacts(){
		return studentRepo.findByNoContact();
	}
	public List<Student> obtenerNoContactJPA(){
		return studentRepo.findByContactIdIsNull();
	}

	public Contact crearContacto(Contact contact) {
		return contactRepo.save(contact);
	}
	

}
