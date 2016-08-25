package whq.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="user_table")
public class User1 {
	//��֪�����Ƿ�������
	//�û���
	@Column(name = "user_name")
	private String username;
	//����
	private String password;
	//����
	@Column(name = "user_id")
	private int id;
	//�Ƿ�Ϊ����Ա
	private byte isAdmin;
	//ְλ
	private String profession;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Id
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public byte getIsAdmin() {
		return isAdmin;
	}
	
	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public String getProfession() {
		return profession;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
}
