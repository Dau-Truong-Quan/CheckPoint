package checkpoint.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	private Address startAddressCode;
	
	@ManyToOne
	@JoinColumn(name = "EndAddressCode")
	private Address endAddressCode;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
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
	public void setNameVehicle(String nameVehicle) {
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
		this.startAddressCode = startAddressCode;
		this.endAddressCode = endAddressCode;
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
		return startAddressCode;
	}
	public void setStartAddressCode(Address startAddressCode) {
		this.startAddressCode = startAddressCode;
	}
	public Address getEndAddressCode() {
		return endAddressCode;
	}
	public void setEndAddressCode(Address endAddressCode) {
		this.endAddressCode = endAddressCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
