package test.hotel.reservation.modal;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="reservation")
public class Reservation	 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(
		    name = "native",
		    strategy = "native"
		)
	@Column(name="r_id")
	private int id;
    
	@Column(name="price")
	private int price;
	
	@Column(name="roomno")
	private int roomNo;
	
	@Column(name="status")
	private String status;

	@ManyToOne
	@JoinColumn(name="userid")
	private UserDetail userdetail;
	
	public Reservation(){}
	
	public Reservation(int roomNo, String status, UserDetail user) {
		super();
		this.roomNo = roomNo;
		this.status = status;
		this.userdetail=user;
	}
	 

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	public void setUserdetail(UserDetail userdetail) {
		this.userdetail = userdetail;
	}

	
}
