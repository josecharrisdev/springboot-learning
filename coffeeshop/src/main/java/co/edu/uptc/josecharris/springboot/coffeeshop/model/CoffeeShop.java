package co.edu.uptc.josecharris.springboot.coffeeshop.model;

public class CoffeeShop {
	private Integer id;
	private String name;
	private String owner;
	private String city;
	
	public CoffeeShop() {
		
	}

	public CoffeeShop(Integer id, String name, String owner, String city) {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
