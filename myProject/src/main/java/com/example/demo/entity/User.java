package com.example.demo.entity;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import javax.persistence.ManyToOne;

@Entity
@Table(name = "consumer")
public class User implements UserDetails {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nickname;
	
	private String firstName;
	
	private String lastName;
	
	@ManyToOne
	private Country country;
	
	private String email;
	
	private String password;
	
	private String photo;
	
	private Role role ;

	
	public User() {}
	




	public User(int id, String nickname, String firstName,String lastName,  Country country, String email, String password,
			String photo) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.email = email;
		this.password = password;
		this.photo = photo;
		
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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


 
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	


	public String getPhoto() {
		return photo;
	}





	public void setPhoto(String photo) {
		this.photo = photo;
	}





	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", firstName=" + firstName + ",  email="
				+ email + "]";
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority(role.name())));
	}


	@Override
	public String getUsername() {
		return this.email;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}






	


	
	
}
