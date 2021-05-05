package test.hotel.reservation.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.hotel.reservation.modal.Reservation;
import test.hotel.reservation.modal.UserDetail;
import test.hotel.reservation.repository.JPARepository;
import test.hotel.reservation.repository.UserDetailJPARepository;

@Service
public class ReservationServices {

	@Autowired
	JPARepository jpaReservation;
	
	@Autowired
	UserDetailJPARepository jpaUserdetail;
	
	
	
	public List<UserDetail> getAllRecord(){
		List<UserDetail> list=new ArrayList<>();
		jpaUserdetail.findAll().forEach(list::add);
		return list;
	}
	
	
	public UserDetail getRecordByUsername(String username){
				Optional<UserDetail> op=jpaUserdetail.findByName(username);
				if(!op.isPresent())
					return null;
				UserDetail res=op.get();
		return res;
	}
	
	/*public void updateStatus(String username,Reservation newrow){
		jpaRepository.save(newrow);
	}
	*/
	public String addBooking(UserDetail bookuser){
		//check user is valid or not 
		Optional<UserDetail> checkname=jpaUserdetail.findByName(bookuser.getName());
		if(!checkname.isPresent()){
			return "please register username to add booking";
		}
		
		UserDetail existingUser=checkname.get();
		List<Reservation>bookreservation=bookuser.getReservation();
		
		// check price of room entered or not
		if((bookreservation.get(0).getPrice())<1)
			return "please add room price for reservation";

		//check room occupied or not
		System.out.println(bookreservation.get(0).getRoomNo());
		Optional<Reservation> check=jpaReservation.findByRoomNo(bookreservation.get(0).getRoomNo());
		if(check.isPresent())
			return "room occupied";
		
		
		if(existingUser.getBonusPoint()<bookreservation.get(0).getPrice()){
			bookreservation.get(0).setStatus("pending approval");
		}
		else if(existingUser.getBonusPoint()==bookreservation.get(0).getPrice()){
			bookreservation.get(0).setStatus("booked");
		}
		else if(existingUser.getBonusPoint()>bookreservation.get(0).getPrice()){
			long tempbonus=(existingUser.getBonusPoint()-bookreservation.get(0).getPrice());
			existingUser.setBonusPoint(tempbonus);
			bookreservation.get(0).setStatus("booked");
		}
		else{
			bookreservation.get(0).setStatus("waiting");
		}
		bookreservation.get(0).setUserdetail(existingUser);
		existingUser.setReservation(bookreservation);
		jpaUserdetail.save(existingUser);
		return bookreservation.get(0).getStatus().toString();
	}


	public String addNewUser(String name) {
		Optional<UserDetail> check=jpaUserdetail.findByName(name);
		if(check.isPresent())
			return "try another user name to add...... This username already registered";
		UserDetail user=new UserDetail();
		user.setName(name);
		user.setBonusPoint(0);
		jpaUserdetail.save(user);
		return "user added successfully";
	}
}
