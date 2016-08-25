package whq.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="fileinfo_table")
public class FileInfo {
	private String file_name;		//�ļ���ʵ����
	
	private int file_id;       		//�ļ�id��Ψһ��ʶ
	private String title;			//����
	private int item_info_id;		//�ļ�������Ŀ
	private String type;			//�ļ����ͣ���doc��pdf
	private String filepath;		//�ļ�·��
	private int  up_user_id;		//�ϴ��û�
	private byte check_status;		//�ļ��Ƿ����
	private int down_count;			//���ش���
	private Timestamp up_time;		//�ϴ�ʱ��
	private Timestamp check_time;	//���ʱ��
	
	
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	/**
	 * ��ȡ�ļ�id
	 * @return
	 */
	
	@Id
	public int getFile_id() {
		return file_id;
	}
	/**
	 * �����ļ�id
	 * @param file_id
	 */
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	/**
	 * ��ȡ�ļ�����
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * �����ļ�����
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * ��ȡ�ļ�������Ŀ
	 * @return
	 */
	public int getItem_info_id() {
		return item_info_id;
	}
	/**
	 * �����ļ�������Ŀ
	 * @param item_info_id
	 */
	public void setItem_info_id(int item_info_id) {
		this.item_info_id = item_info_id;
	}
	/**
	 * ��ȡ�ļ�����
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * �����ļ�����
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * ��ȡ�ļ��洢·��
	 * @return
	 */
	public String getFilepath() {
		return filepath;
	}
	/**
	 * �����ļ��洢·��
	 * @param filepath
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	public int getUp_user_id() {
		return up_user_id;
	}
	public void setUp_user_id(int up_user_id) {
		this.up_user_id = up_user_id;
	}
	/**
	 * ��ȡ���״̬
	 * @return
	 */
	public byte getCheck_status() {
		return check_status;
	}
	/**
	 * �������״̬
	 * @param check_status
	 */
	public void setCheck_status(byte check_status) {
		this.check_status = check_status;
	}
	/**
	 * ��ȡ�ļ����ش���
	 * @return
	 */
	public int getDown_count() {
		return down_count;
	}
	/**
	 * �����ļ����ش���
	 * @param down_count
	 */
	public void setDown_count(int down_count) {
		this.down_count = down_count;
	}
	/**
	 * ��ȡ�ļ��ϴ�ʱ��
	 * @return
	 */
	public Timestamp getUp_time() {
		return up_time;
	}
	/**
	 * �����ļ��ϴ�ʱ��
	 * @param up_time
	 */
	public void setUp_time(Timestamp up_time) {
		this.up_time = up_time;
	}
	/**
	 * ��ȡ�ļ����ͨ��ʱ��
	 * @return
	 */
	public Timestamp getCheck_time() {
		return check_time;
	}
	/**
	 * �����ļ����ͨ��ʱ��
	 * @param check_time
	 */
	public void setCheck_time(Timestamp check_time) {
		this.check_time = check_time;
	}
	
	
}
