package com.coding.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.web.models.Contact;
import com.coding.web.models.Student;
import com.coding.web.services.MainService;

import jakarta.validation.Valid;
@Controller
public class MainController {
	@Autowired
	private MainService mainService;
	
	
	@GetMapping("/")
	public String raiz(Model viewModel) {
		List<Student> todos = mainService.todosEstudiantes();
		viewModel.addAttribute("todos", todos);
		return "Students.jsp";
	}

	@GetMapping("/students/new")
	public String formularioEstudiante(@ModelAttribute("student") Student student) {
		return "NewStudent.jsp";
	}
	
	@PostMapping("/students/new")
	public String crearEstudiante(@Valid @ModelAttribute("student") Student student, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "NewStudent.jsp";
		}
		mainService.crearEstudiante(student);
		return "redirect:/";
	}

	@GetMapping("/contacts/new")
	public String formularioLicencia(@ModelAttribute("contact") Contact contact, 
			Model viewModel) {

		List<Student> estudiantesSinContacto = mainService.obtenerNoContactJPA();
		viewModel.addAttribute("students", estudiantesSinContacto);
		return "NewContact.jsp";
	}
	@PostMapping("/contacts/new")
	public String crearLicencia(@Valid @ModelAttribute("contact") Contact contact,
			BindingResult resultado, Model viewModel) {
		if(resultado.hasErrors()) {
			viewModel.addAttribute("students", mainService.obtenerNoContactJPA());
			return "NewContact.jsp";
		}
		mainService.crearContacto(contact);
		return "redirect:/";
	}
}
