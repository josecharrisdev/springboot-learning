package co.edu.uptc.josecharris.springboot.products.domain;

public class Product {
	private Integer id;
	private String name;
	private Double price;
	private Integer stock;
	
	public Product() {
		super();
	}

	public Product(Integer id, String name, Double price, Integer stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public int getId() {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}
