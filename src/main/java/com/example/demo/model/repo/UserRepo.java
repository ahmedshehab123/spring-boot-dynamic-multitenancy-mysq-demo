package com.example.demo.model.repo;

import com.example.demo.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {
}
