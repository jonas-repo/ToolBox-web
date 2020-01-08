package com.toolbox.springboot.backend.apirest.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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


@Entity
@Table(name="userGeneral")
public class UserGeneral implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@NotEmpty(message="no puede ser vacio")
	@Email(message="El campo email no tiene el formato correcto")
	@Column(nullable=false, unique=true)
	private String userEmail;
	
	@NotEmpty(message="no puede ser vacio")
	@Size(min=4,max=12, message="debe de tener entre 4 y 12 caracteres")
	@Column(nullable=false)
	private String userPassword;
	
	@NotEmpty(message="no puede ser vacio")
	@Column(nullable=false)
	private String userName;
	
	
	private String userTelephone;
	private String userAddress;
	
	
	@NotEmpty(message="El apellido no puede ser vacio")
	private String userLastName;
	private String userPicture;
	
	@Temporal(TemporalType.DATE)
	private Date userBirthDate;
	
	
	private boolean userEmailConfirmed;
	
	@OneToMany(mappedBy ="userGeneral")
	@JsonIgnore
	public List<UserGeneral> userGeneral;
	
	
	public List<UserGeneral> getUserGeneral() {
		return userGeneral;
	}
	public void setUserGeneral(List<UserGeneral> userGeneral) {
		this.userGeneral = userGeneral;
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
