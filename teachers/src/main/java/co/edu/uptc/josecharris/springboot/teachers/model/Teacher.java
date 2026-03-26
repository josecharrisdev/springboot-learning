package co.edu.uptc.josecharris.springboot.teachers.model;

public class Teacher {
	private String firstName;
	private String lastName;
	private String code;
	private Integer age;
	private String courseName;
	
	public Teacher() {
		
	}

	public Teacher(String firstName, String lastName, String code, Integer age, String courseName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.code = code;
		this.age = age;
		this.courseName = courseName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
