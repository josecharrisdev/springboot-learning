package co.charris.jose.students.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		if(this.getTeacherById(teacher.getId()).getStatusCode().equals(HttpStatus.OK)) {
			this.listTeacher.add(teacher);
			return ResponseEntity.status(HttpStatus.CREATED).body("Se creó el registro de profesor.");
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/getTeacherById")
	public ResponseEntity<?> getTeacherById(@PathVariable String id){
		return this.listTeacher.stream().filter(teacher -> teacher.getId().equals(id))
				.findFirst().map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping
	public ResponseEntity<?> updateTeacher(@RequestBody Teacher newTeacher){
		for(Teacher teacher: this.listTeacher) {
			if(teacher.getId().equals(newTeacher.getId())) {
				teacher.setName(newTeacher.getName());
				teacher.setCode(newTeacher.getCode());
				teacher.setAge(newTeacher.getAge());
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteTeacher(@PathVariable String id) {
		boolean eliminar = this.listTeacher.removeIf((t) -> t.getId().equals(id));
		if(eliminar) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
}
