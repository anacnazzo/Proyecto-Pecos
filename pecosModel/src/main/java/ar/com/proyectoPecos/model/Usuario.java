package ar.com.proyectoPecos.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)

@Value
@Builder
public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq-gen", sequenceName = "MY_SEQ_GEN", initialValue = 205, allocationSize = 12)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq-gen")
	@Column(name = "\"ID\"", unique = true, nullable = false)
	private Integer id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@JsonCreator
	public
	Usuario(@JsonProperty("username") String email,
	       @JsonProperty("password") String password) {
	    super();
	    this.email = email;
	    this.password = password;
	  }
	  
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		return email;
	}

}
