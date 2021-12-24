package checkpoint.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="`Address`")
public class Address {

	@Id
	@Column(name = "Id")
	@GeneratedValue
	private int id;
	
	
	private String addressName;

	@OneToMany(mappedBy = "startAddressCode", fetch = FetchType.EAGER)
	private Collection<Declaration> listStartAddressCode;
	
	@OneToMany(mappedBy = "endAddressCode", fetch = FetchType.EAGER)
	private Collection<Declaration> listEndAddressCode;
	
	
	@OneToMany(mappedBy = "idAddress", fetch = FetchType.EAGER)
	private Collection<PersonalInfor> listPersonalInfor;
	
	
	public Collection<Declaration> getListStartAddressCode() {
		return listStartAddressCode;
	}


	public void setListStartAddressCode(Collection<Declaration> listStartAddressCode) {
		this.listStartAddressCode = listStartAddressCode;
	}


	public Collection<Declaration> getListEndAddressCode() {
		return listEndAddressCode;
	}


	public void setListEndAddressCode(Collection<Declaration> listEndAddressCode) {
		this.listEndAddressCode = listEndAddressCode;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddressName() {
		return addressName;
	}


	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}


	public Address(int id, String addressName) {
		super();
		this.id = id;
		this.addressName = addressName;
	}


	public Address() {
		super();
	}
	
	
	
}
