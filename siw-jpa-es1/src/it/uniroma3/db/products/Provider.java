package it.uniroma3.db.products;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Provider {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String email;
    @ManyToMany
    private List<Product> products;
    @OneToOne
    private Address address;
    
    public Provider() {
    	this.products=new ArrayList<Product>();
	}
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}