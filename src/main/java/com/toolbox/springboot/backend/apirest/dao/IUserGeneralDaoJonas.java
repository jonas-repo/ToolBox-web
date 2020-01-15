package com.toolbox.springboot.backend.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;

public interface IUserGeneralDaoJonas extends JpaRepository<UserGeneral, Long>{

		public UserGeneral findByUserEmail(String userEmail);
}
