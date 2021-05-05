
package test.hotel.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.hotel.reservation.modal.UserDetail;
import test.hotel.reservation.services.ReservationServices;

@RestController
 @RequestMapping("/reservation")
public class ReservRestConctroller {

	@Autowired
	ReservationServices service;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<UserDetail> getAllRecords(){
		return service.getAllRecord();
	}
	
	@RequestMapping(value="/getrecord/{name}",method=RequestMethod.GET)
	public UserDetail getUserReservation(@PathVariable String name){
		return service.getRecordByUsername(name);
	}
	
	@RequestMapping(value="/bookroom",method=RequestMethod.POST)
	public String addReseration(@RequestBody UserDetail res){
		return service.addBooking(res);
	}
	
		
	@RequestMapping(path="/adduser/{name}",method=RequestMethod.POST)
	public String createUser(@PathVariable String name){
		return service.addNewUser(name);
	}
}
