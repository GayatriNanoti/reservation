package test.hotel.reservation.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import test.hotel.reservation.modal.Reservation;

public interface JPARepository extends CrudRepository<Reservation, String> {

	Optional<Reservation> findByRoomNo(int roomno);	
}
