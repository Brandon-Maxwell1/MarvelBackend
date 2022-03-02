package com.bmaxwell.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmaxwell.backend.models.userLogins;

@Repository
public interface UserLoginsRepository extends JpaRepository<userLogins, Integer>{
	List<userLogins> findByUsername(String username);

}
