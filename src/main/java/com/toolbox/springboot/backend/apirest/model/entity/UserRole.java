package com.toolbox.springboot.backend.apirest.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="userRole")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userRoleId;
	
	@NotNull
	@NotEmpty
	private String userRoleName;
	
	@JsonIgnoreProperties({"userRoleId", "hibernateLazyInitializer", "handler"})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="userRole", cascade=CascadeType.ALL)
	List<UserRoleAssigned> userRoleAssigned;

	public UserRole() {
		
	}		
	
	public UserRole(long userRoleId, @NotNull @NotEmpty String userRoleName) {
		super();
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	
	
}
