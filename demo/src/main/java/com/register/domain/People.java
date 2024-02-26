package com.register.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
public class People implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Setter
	private String name;
	@Setter
	private String phone;
	@Setter
	private String email;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Setter
	@OneToOne(mappedBy ="people", cascade = CascadeType.ALL)
	private Address address;
	
	@Setter
	@OneToMany(mappedBy = "people", cascade = CascadeType.ALL)
	private List<Activity> activity;
	
	public People() {
	}

	public People(Long id, String name, String phone, String email, Address address, List<Activity> activity) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.activity = activity;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public Address getAddress() {
		return address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Activity> getActivity() {
		return activity;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return Objects.equals(id, other.id);
	}
}
