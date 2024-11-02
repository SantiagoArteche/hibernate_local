package arg.com.art.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Clients implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	private String phone;
	
	
	public Clients() {
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, id, lastName, name, phone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clients other = (Clients) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", phone="
				+ phone + "]";
	}
	
	
}
