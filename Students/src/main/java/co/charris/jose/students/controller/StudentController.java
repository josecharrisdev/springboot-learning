package co.charris.jose.students.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.charris.jose.students.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	private List<Student> listStudent;
	
	public StudentController() {
		this.listStudent = new ArrayList<>();
		this.listStudent.add(new Student("1", "Jose", "jose@gmail.com", 27, null));
		this.listStudent.add(new Student("2", "Angel", "angel@gmail.com", 27, null));
		this.listStudent.add(new Student("3", "Pedro", "pedro@gmail.com", 31, null));
		this.listStudent.add(new Student("4", "Alejandro", "alejandro@gmail.com", 29, null));
	}
	
	@PostMapping("/insertStudent")
	public boolean insertStudent(@RequestBody Student student) {
		if(this.getStudentById(student.getId()) != null) {
			this.listStudent.add(student);
			return true;
		}
		return false;
	}
	
	@GetMapping("/getStudentById/{id}")
	public Student getStudentById(@PathVariable String id) {
		return this.listStudent.stream().filter(student -> student.getId().equals(id)).findAny()
		.orElse(null);
	}
	
	public int findIndexById(String id) {
	    return IntStream.range(0, listStudent.size())
	            .filter(i -> listStudent.get(i).getId().equals(id))
	            .findFirst()
	            .orElse(-1);
	}
	
	
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		Student studentUpdate = this.getStudentById(student.getId());
		int indice = this.findIndexById(student.getId());
		if(indice != -1) {
			this.listStudent.set(this.findIndexById(student.getId()), studentUpdate);
			return studentUpdate;
		}
		return null;
	}
	
	@PatchMapping("/updateStudent")
	public Student updateStudentPath(@RequestBody Student student) {
		Student studentUpdate = this.getStudentById(student.getId());
		int indice = this.findIndexById(student.getId());
		if(indice != -1) {
			if(student.getName() != null) {
				studentUpdate.setName(student.getName());
			}
			
			if(student.getEmail() != null) {
				studentUpdate.setEmail(student.getEmail());
			}
			
			if(student.getAge() != null) {
				studentUpdate.setAge(student.getAge());
			}
			
			if(student.getCourse() != null) {
				studentUpdate.setCourse(student.getCourse());
			}
			this.listStudent.set(this.findIndexById(student.getId()), studentUpdate);
			return studentUpdate;
		}
		return null;
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public Student deleteMapping(@PathVariable String id) {
		Student studentUpdate = this.getStudentById(id);
		if(studentUpdate != null) {
			this.listStudent.remove(studentUpdate);
			return studentUpdate;
		}
		return null;
	}
	
}
