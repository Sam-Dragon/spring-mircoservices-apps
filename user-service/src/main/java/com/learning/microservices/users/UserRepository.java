package com.learning.microservices.users;

import com.learning.microservices.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<Users, String> {

    @Query("select u from Users u")
    Stream<Users> getAll();
}
