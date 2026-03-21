package co.charris.jose.students.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.charris.jose.students.model.Teacher;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	private List<Teacher> listTeacher;
	
	public TeacherController() {
		this.listTeacher = new ArrayList<>();
	}
	
	@PostMapping("/insertTeacher")
	public ResponseEntity<?> insertTeacher(@RequestBody Teacher teacher){
		this.listTeacher.add(teacher);
		return ResponseEntity.status(HttpStatus.CREATED).body("Se creó el registro de profesor.");
	}
}
