package com.example.pizzaservice.repository;

import com.example.pizzaservice.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository works directly with a table.
 * It has common operation (like selection by id, saving,
 * counting etc.) defined in CrudRepository already
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.name = ?1")
    User findByName(String name);
    List<User> findAll();
}
