package hu.kalix.hibernatedemo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Authority")
public class Authority {
	@Id
	@Column(name = "authority_id")
	@GeneratedValue()
	private int id;
	@Column(name = "authority_name", length = 100, nullable = false)
	private String authorityName;
		
	public Authority() {}
	
	public Authority(String authorityName) {
		this.authorityName = authorityName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", authorityName=" + authorityName + "]";
	}
}
