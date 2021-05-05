package test.hotel.reservation.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_detail")
public class UserDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(
		    name = "native",
		    strategy = "native"
		)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="bonuspoint")
	private long bonusPoint;


	@OneToMany(mappedBy="userdetail",cascade=CascadeType.ALL)
List<Reservation> reservation=new ArrayList<>();
		
	
	
	
	public UserDetail(){}
	UserDetail(String username,long bonuspoint){
		this.name=username;
		this.bonusPoint=bonuspoint;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(long bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public List<Reservation> getReservation() {
		return reservation;
	}
	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	

}
