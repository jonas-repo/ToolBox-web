package com.toolbox.springboot.backend.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;


import com.toolbox.springboot.backend.apirest.dao.IUserGeneralDaoJonas;
import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;
import com.toolbox.springboot.backend.apirest.services.IUserGeneralServiceJonas;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	private IUserGeneralServiceJonas usuarioService;
	
	@SuppressWarnings("deprecation")
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		UserGeneral usuario = usuarioService.findByEmail(authentication.getName());
		
		Map<String,Object> info = new HashMap<>();
		info.put("info_adicional",usuario.getUserid());
		info.put("nombre",usuario.getUsername());
		info.put("apellido",usuario.getUserlastname());
		info.put("email",usuario.getUseremail());
		//info.put("roles",usuario.getRoles());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info); 
		return accessToken;
	}
	

}
