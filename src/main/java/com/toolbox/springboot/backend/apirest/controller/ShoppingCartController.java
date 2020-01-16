package com.toolbox.springboot.backend.apirest.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolbox.springboot.backend.apirest.dao.DAOPayment;
import com.toolbox.springboot.backend.apirest.dao.DAORentPayment;
import com.toolbox.springboot.backend.apirest.model.entity.Payment;
import com.toolbox.springboot.backend.apirest.model.entity.Product;
import com.toolbox.springboot.backend.apirest.model.entity.RentPayment;
import com.toolbox.springboot.backend.apirest.model.entity.ShoppingInfo;
import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;
import com.toolbox.springboot.backend.apirest.model.entity.UsersPayment;
import com.toolbox.springboot.backend.apirest.services.IUserGeneralServiceJonas;



@RestController
@RequestMapping("/shoppingCartCheck")
public class ShoppingCartController {
	
	@Autowired
	private DAOPayment daoPayment;
	
	@Autowired
	private DAORentPayment rentPaymentdao;
	
	@Autowired
	private IUserGeneralServiceJonas userService;

	
	@PostMapping
	private void checkOut(@RequestBody ShoppingInfo shoppingInfo)
	{
		Payment payment = new Payment();
		Payment paymentN = new Payment();
		UserGeneral userClient = new UserGeneral();
		UserGeneral userSeller = new UserGeneral();
		UsersPayment usersPayment = new UsersPayment();
		
		try {
			userClient = userService.findByEmail(shoppingInfo.getUserIdentifier());
			
			payment.setPaymentPrice(shoppingInfo.getTotals());
			payment.setPaymentProductQuantity(shoppingInfo.getCartItems().size());
			payment.setPaymentStatus("En espera");
			payment.setPaymentDate(new Date());
			payment.setPaymentPickup("general");
			
			paymentN = daoPayment.save(payment);		
			int count = 0;
			
			for(Product product : shoppingInfo.getCartItems())
			{
				RentPayment rentPayment = new RentPayment();
				rentPayment.setPaymentId(paymentN);
				rentPayment.setRentPaymentTimeStart(new Date());
				rentPayment.setRentPaymentTimeEnd(getDate(shoppingInfo.getCartPrices().indexOf(count)));	
				rentPaymentdao.save(rentPayment);
				count++;
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public Date getDate(int days)
	{
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		System.out.println(Calendar.DATE);
		c.setTime(dt); 
		c.add(Calendar.DATE, days);
		
		dt = c.getTime();
		System.out.println(dt);
		return dt;
	}
}
