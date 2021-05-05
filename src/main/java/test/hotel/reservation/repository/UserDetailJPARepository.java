package test.hotel.reservation.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import test.hotel.reservation.modal.UserDetail;

public interface UserDetailJPARepository extends CrudRepository<UserDetail,String>{
Optional<UserDetail> findByName(String name);

}
