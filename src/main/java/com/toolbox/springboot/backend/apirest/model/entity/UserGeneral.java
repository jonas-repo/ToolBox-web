package com.toolbox.springboot.backend.apirest.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="userGeneral")
public class UserGeneral implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@NotEmpty(message="An email is required")
	@Email(message="Email format is incorrect")
	@Column(nullable=false, unique=true)
	private String userEmail;
	
	
	@NotEmpty(message="A name is required")
	@Column(nullable=false, unique=true)
	private String userFullName;
	
	
	@NotEmpty(message="The password is required")
	@Size(min=4,max=60, message="the password has to be of more than 4 characters")
	@Column(nullable=false, length = 60)	
	private String userPassword;
	
	@NotEmpty(message="Please verify the information")
	@Email(message="Please verify the information")
	@Column(nullable=false)
	private String userName;
	
	
	private String userTelephone;
	private String userAddress;
	
	
	@NotEmpty(message="The last name is required")
	private String userLastName;
	private String userPicture;
	
	@Temporal(TemporalType.DATE)
	private Date userBirthDate;
	
	
	private boolean userEmailConfirmed;
	
	@OneToMany(mappedBy="userId")
	@JsonIgnore
	public List<UserPartnerProducts> userPartnerProducts;	

	@JsonIgnoreProperties({"userId", "hibernateLazyInitializer", "handler"})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="userGeneral", cascade=CascadeType.ALL)
	public List<UserRoleAssigned> userRole;
	

	public List<UserRoleAssigned> getUserRole() {
		return userRole;
	}
	public void setUserRole(List<UserRoleAssigned> userRole) {
		this.userRole = userRole;
	}
	@JsonIgnore
	@OneToMany(mappedBy="userGeneral")
	List<UserPaymentMethods> userPaymentMethods;
	
	
	public List<UserPaymentMethods> getUserPaymentMethods() {
		return userPaymentMethods;
	}
	public void setUserPaymentMethods(List<UserPaymentMethods> userPaymentMethods) {
		this.userPaymentMethods = userPaymentMethods;
	}

	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public Long getUserid() {
		return userId;
	}
	public void setUserid(Long userid) {
		this.userId = userid;
	}
	public String getUseremail() {
		return userEmail;
	}
	public void setUseremail(String useremail) {
		this.userEmail = useremail;
	}
	public String getUserpassword() {
		return userPassword;
	}
	public void setUserpassword(String userpassword) {
		this.userPassword = userpassword;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getUsertelephone() {
		return userTelephone;
	}
	public void setUsertelephone(String usertelephone) {
		this.userTelephone = usertelephone;
	}
	public String getUseraddress() {
		return userAddress;
	}
	public void setUseraddress(String useraddress) {
		this.userAddress = useraddress;
	}
	public String getUserlastname() {
		return userLastName;
	}
	public void setUserlastname(String userlastname) {
		this.userLastName = userlastname;
	}
	public String getUserpicture() {
		return userPicture;
	}
	public void setUserpicture(String userpicture) {
		this.userPicture = userpicture;
	}
	public Date getUserbirthdate() {
		return userBirthDate;
	}
	public void setUserbirthdate(Date userbirthdate) {
		this.userBirthDate = userbirthdate;
	}
	public boolean isUseremailconfirmed() {
		return userEmailConfirmed;
	}
	public void setUseremailconfirmed(boolean useremailconfirmed) {
		this.userEmailConfirmed = useremailconfirmed;
	}
}
