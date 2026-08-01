package com.rickdev.DevTasks.Repository;

import com.rickdev.DevTasks.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserDetails findByLogin(String login);
}
