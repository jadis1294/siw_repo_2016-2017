package it.uniroma3.db.products;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"firstname","lastname"}))
public class Customer {


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Address address;
    
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
    
    public Customer() {
	}
    
	public Customer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.orders=new ArrayList<Order>();
	}
	public Long getId() {
		return id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
