package co.edu.uptc.josecharris.springboot.teachers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uptc.josecharris.springboot.teachers.exception.ResourceNotFoundException;
import co.edu.uptc.josecharris.springboot.teachers.model.Teacher;

@Service
public class TeacherService {
	private List<Teacher> listTeacher;
	
	public TeacherService() {
		this.listTeacher = new ArrayList<>();
		this.listTeacher.add(new Teacher("Jose", "Charris", "12", 27, "Programación 1"));
	}
	
	public Teacher createTeacher(Teacher teacher) {
		if(this.findTeacherByCode(teacher.getCode()) == null) {
			this.listTeacher.add(teacher);
		}
		return null;
	}
	
	public List<Teacher> findTeachers(){
		return this.listTeacher;
	}
	
	public Teacher findTeacherByCodeOrThrow(String code) {
		return this.listTeacher.stream().filter(t -> t.getCode().equals(code)).findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("La persona no fue encontrada."));
	}
	
	public Teacher findTeacherByCode(String code) {
		return this.listTeacher.stream().filter(t -> t.getCode().equals(code)).findFirst()
				.orElse(null);
	}
	
	public Teacher updateTeacherOrThrow(Teacher teacher) {
		Teacher updateTeacher = this.findTeacherByCodeOrThrow(teacher.getCode());
		
		if(teacher.getFirstName() != null) {
			updateTeacher.setFirstName(teacher.getFirstName());
		}
		
		if(teacher.getLastName() != null) {
			updateTeacher.setLastName(teacher.getLastName());
		}

		if(teacher.getAge() != null) {
			updateTeacher.setAge(teacher.getAge());
		}

		if(teacher.getCourseName() != null) {
			updateTeacher.setCourseName(teacher.getCourseName());
		}
		
		return updateTeacher;
	}
	
	public void deleteTeacher(String code) {
		Teacher teacher = this.findTeacherByCodeOrThrow(code);
		this.listTeacher.remove(teacher);
	}
	
	
	
	
}
