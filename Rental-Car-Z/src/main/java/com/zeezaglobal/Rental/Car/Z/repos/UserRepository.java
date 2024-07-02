package com.zeezaglobal.Rental.Car.Z.repos;

import com.zeezaglobal.Rental.Car.Z.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {
}
