package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String addressLine1;
	private String city;
	private String state;
	private String zip;
	
	@OneToMany
	@JoinColumn(name = "publisher_id")
	private Set<Book> books = new HashSet<>();
	
	public Publisher()
	{
		
	}
	
	public Publisher(String addressLine1, String city, String state, String zip) {
		super();
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Publisher(" +
				"id=" + id +
				", addressLine1='" + addressLine1 +
				", city='" + city +
				", state='" + state +
				", zip='" + zip +
				")";
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (this ==o) return true;
		if (o == null|| getClass() != o.getClass()) return false;
		
		Publisher publisher = (Publisher) o ;
		return id !=null ? id.equals(publisher.id): publisher.id == null; 
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id !=null ? id.hashCode() : 0;
	}
}
