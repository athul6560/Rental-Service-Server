package com.zeezaglobal.Rental.Car.Z.repos;

import com.zeezaglobal.Rental.Car.Z.entities.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
        Users findByEmail(String email);
        }