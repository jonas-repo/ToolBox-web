package com.toolbox.springboot.backend.apirest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.toolbox.springboot.backend.apirest.dao.IUserGeneralDaoJonas;
import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;

@Service
public class UserGeneralServiceImplJonas implements IUserGeneralServiceJonas, UserDetailsService  {

	@Autowired
	private IUserGeneralDaoJonas iUser ;
	
	@Override
	public List<UserGeneral> showAll() {
		return (List<UserGeneral>) iUser.findAll();
	}

	@Override
	public Page<UserGeneral> showAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserGeneral Save(UserGeneral user) {
		
		return iUser.save(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		iUser.deleteById(id);
	}

	@Override
	public UserGeneral findById(Long id) {
		// TODO Auto-generated method stub
		return iUser.findById(id).orElse(null);
	}

	@Override
	public UserGeneral findByEmail(String email) {
		
		return iUser.findByUserEmail(email);
	}

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			UserGeneral usuario = iUser.findByUserEmail(username);
		
		if(usuario == null) {
			System.out.println("error en el login: no existe el usuario");
			throw new UsernameNotFoundException("error en el login: no existe el usuario");
		}
		
		List<GrantedAuthority> authorities = usuario.getUserRole().
				stream().
				map(role -> new SimpleGrantedAuthority(role.getUserRole().getUserRoleName()))//every role transform to simple user authority
				.collect(Collectors.toList());
		
		
		return new User(usuario.getUsername(),usuario.getUserpassword(),true,true,true,true,authorities);
	}


}
