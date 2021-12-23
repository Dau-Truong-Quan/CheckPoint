package checkpoint.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="`Declaration`")
public class Declaration {
	

	
	@Id
	@Column(name = "Id")
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "PersonalId")
	private PersonalInfor personalId;
	
	@ManyToOne
	@JoinColumn(name = "StartAddressCode")
	private Address StartAddressCode;
	
	@ManyToOne
	@JoinColumn(name = "EndAddressCode")
	private Address EndAddressCode;
	
	@Column(name = "Date")
	private Date date;
	
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "nameVehicle")
	private String nameVehicle;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNameVehicle() {
		return nameVehicle;
	}
	public void setName(String nameVehicle) {
		this.nameVehicle = nameVehicle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public Declaration() {
		super();
	}
	public Declaration(int id, PersonalInfor personalId, Address startAddressCode, Address endAddressCode, Date date,
			String phone, String nameVehicle) {
		super();
		this.id = id;
		this.personalId = personalId;
		StartAddressCode = startAddressCode;
		EndAddressCode = endAddressCode;
		this.date = date;
		this.phone = phone;
		this.nameVehicle = nameVehicle;
	}
	public PersonalInfor getPersonalId() {
		return personalId;
	}
	public void setPersonalId(PersonalInfor personalId) {
		this.personalId = personalId;
	}
	public Address getStartAddressCode() {
		return StartAddressCode;
	}
	public void setStartAddressCode(Address startAddressCode) {
		StartAddressCode = startAddressCode;
	}
	public Address getEndAddressCode() {
		return EndAddressCode;
	}
	public void setEndAddressCode(Address endAddressCode) {
		EndAddressCode = endAddressCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setNameVehicle(String nameVehicle) {
		this.nameVehicle = nameVehicle;
	}
	
	

}
