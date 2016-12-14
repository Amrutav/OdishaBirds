package bird.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_login")
public class User {
	
	@Id
	@GenericGenerator(name="bird",strategy="increment")
	@GeneratedValue(generator="bird")
	@Column(name="LoginId")
    private int loginId;
	@Column(name="UserName")
    private String userName;
	@Column(name="Password")
	private String password;
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
