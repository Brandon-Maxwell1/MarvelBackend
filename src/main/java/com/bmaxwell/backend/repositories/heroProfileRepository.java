package com.bmaxwell.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmaxwell.backend.models.heroProfiles;

@Repository
public interface heroProfileRepository extends JpaRepository<heroProfiles, Integer> {
	
	List<heroProfiles> findByName(String name);
	

}
