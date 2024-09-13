package com.example.web_calendar.reporitory;

import com.example.web_calendar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
