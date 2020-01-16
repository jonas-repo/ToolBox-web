package com.toolbox.springboot.backend.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;

public interface DAOClientProfile extends JpaRepository<UserGeneral, Long> {

}
