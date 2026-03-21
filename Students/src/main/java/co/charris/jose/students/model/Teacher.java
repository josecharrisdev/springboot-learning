package co.charris.jose.students.model;

public class Teacher {
	private String id;
	private String name;
	private String code;
	private Integer age;
	
	public Teacher() {
		super();
	}
	public Teacher(String id, String name, String code, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
}
