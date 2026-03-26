package co.edu.uptc.josecharris.springboot.teachers.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.josecharris.springboot.teachers.model.Teacher;
import co.edu.uptc.josecharris.springboot.teachers.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherRestController {
	private TeacherService teacherService;
	
	public TeacherRestController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@GetMapping
	public ResponseEntity<?> findTeachers(){
		return ResponseEntity.ok(teacherService.findTeachers());
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<?> findTeacherByCode(@PathVariable String code){
		return ResponseEntity.ok(this.teacherService.findTeacherByCode(code));
	}
	
	@PostMapping
	public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher){
		Teacher teacherCreated = this.teacherService.createTeacher(teacher);
		return ResponseEntity.created(URI.create("/teacher/" + teacher.getCode())).body(teacherCreated);
	}
	
	@PostMapping
	public ResponseEntity<?> updateTeacher(@RequestBody Teacher teacher){
		return ResponseEntity.ok(this.teacherService.updateTeacherOrThrow(teacher));
	}
	
	@DeleteMapping("/{code}")
	public ResponseEntity<Void> deleteTeacher(@PathVariable String code){
		this.teacherService.deleteTeacher(code);
		return ResponseEntity.noContent().build();
	}
	
}
