package com.toolbox.springboot.backend.apirest.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="userRoleAssigned")
public class UserRoleAssigned implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userRoleAssignedId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	@JsonIgnore
	private UserGeneral userGeneral;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="userRoleId")
	@JsonIgnore
	private UserRole userRole;

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Long getUserRoleAssignedId() {
		return userRoleAssignedId;
	}

	public void setUserRoleAssignedId(Long userRoleAssignedId) {
		this.userRoleAssignedId = userRoleAssignedId;
	}

	public UserGeneral getUserGeneral() {
		return userGeneral;
	}

	public void setUserGeneral(UserGeneral userGeneral) {
		this.userGeneral = userGeneral;
	}
	
	
	
	
}
