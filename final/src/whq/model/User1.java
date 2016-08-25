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
	private String user_name;
	//����
	private String password;
	//����
	@Column(name = "user_id")
	private int user_id;
	//�Ƿ�Ϊ����Ա
	private byte isAdmin;
	//ְλ
	private String profession;
	
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	public byte getIsAdmin() {
		return isAdmin;
	}
	@Id
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
