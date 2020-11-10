package base;

import javax.persistence.*;

@Entity
@Table(name = "product1") 
	
public class Product {
	
	@Id          
	//@GeneratedValue(strategy = GenerationType.IDENTITY)  
	 @Column(name ="Barcode")
	 int barcode;
	
	@Column(name ="Name")
	 String name;
	
	@Column(name ="Color")
	String color;
	
	@Column(name ="Description")
	 String description;
	
	public Product() {
		
	}
	
	
	public Product( String name, String color, String description) {
		super();
		this.name = name;
		this.color = color;
		this.description = description;
	}

	public Product(int barcode, String name, String color, String description) {
		super();
		this.barcode = barcode;
		this.name = name;
		this.color = color;
		this.description = description;
	}

	
	
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
