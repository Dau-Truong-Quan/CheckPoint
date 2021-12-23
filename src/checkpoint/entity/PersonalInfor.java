package checkpoint.entity;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="`PersonalInfor`")
public class PersonalInfor {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "FullName")
	private String fullName;
	
	@Column(name = "Sex")
	private String sex;
	
	@Column(name = "UserName")
	private String userName;
	
	@Column(name = "Nationality")
	private String nationality;
	
	
	@ManyToOne
	@JoinColumn(name = "idAddress")
	private Address idAddress;
	
	@Column(name = "DateRange")
	private String dateRange;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(mappedBy = "personalId", fetch = FetchType.EAGER)
	private Collection<Declaration> listDeclaration;
	
	
	
	public PersonalInfor() {
		super();
	}

	public PersonalInfor(int iD, String fullName, String sex, String userName, String nationality, Address idAddress,
			String dateRange, String password, String phone, Collection<Declaration> listDeclaration) {
		super();
		id = iD;
		fullName = fullName;
		sex = sex;
		userName = userName;
		nationality = nationality;
		this.idAddress = idAddress;
		dateRange = dateRange;
		password = password;
		this.phone = phone;
		this.listDeclaration = listDeclaration;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		password = password;
	}

	public Collection<Declaration> getListDeclaration() {
		return listDeclaration;
	}

	public void setListDeclaration(Collection<Declaration> listDeclaration) {
		this.listDeclaration = listDeclaration;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		fullName = fullName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		sex = sex;
	}

	public int getID() {
		return id;
	}

	public void setID(int iD) {
		id = iD;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	

	public Address getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Address idAddress) {
		this.idAddress = idAddress;
	}

	public String getDateRange() {
		return dateRange;
	}

	

	

	public void setDateRange(String dateRange) {
		dateRange = dateRange;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	

}
