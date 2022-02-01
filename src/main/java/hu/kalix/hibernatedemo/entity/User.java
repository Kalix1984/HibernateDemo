package hu.kalix.hibernatedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue()
	private int id;
	@Column(name = "login_name", length = 20, nullable = false)
	private String loginName;
	@Column(name = "password", length = 100, nullable = false)
	private String password;
	@Column(name = "first_name", length = 20, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 20, nullable = false)
	private String lastName;
	@Column(name = "active")
	private boolean active = true;
	@ManyToOne()
	@JoinColumn(name = "role_id")
	private Role role;
	
	public User() {}

	public User(String loginName, String password, String firstName, String lastName, Role role) {
		this.loginName = loginName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", active=" + active + ", role=" + role + "]";
	}
}
