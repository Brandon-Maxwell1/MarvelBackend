package com.bmaxwell.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmaxwell.backend.exceptions.ResourceNotFoundException;
import com.bmaxwell.backend.models.heroProfiles;
import com.bmaxwell.backend.repositories.heroProfileRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class heroProfilesController {

	@Autowired
	private heroProfileRepository profileRepo;

	@GetMapping("allprofiles")
	public List<heroProfiles> getAllProfiles() {
		return profileRepo.findAll();
	}

	@GetMapping("profiles/{userid}")
	public ResponseEntity<heroProfiles> getProfileById(@PathVariable int userid) {
		heroProfiles profile = profileRepo.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("Profile not Found"));
		return ResponseEntity.ok(profile);

	}

	@GetMapping("allprofiles/{name}")
	public List<heroProfiles> getProfileByName(@PathVariable String name) {
		List<heroProfiles> profile = profileRepo.findByName(name);
		if (profile.isEmpty()) {
			System.out.println(new ResourceNotFoundException("Profile(s) with the name " + name + " not found."));
		}
		return profileRepo.findByName(name);
	}

	@PostMapping("addprofile")
	public heroProfiles newProfile(@RequestBody heroProfiles profile) {
		return profileRepo.save(profile);
	}

	@PutMapping("profile/{userid}")
	public ResponseEntity<heroProfiles> updateProfile(@PathVariable int userid, @RequestBody heroProfiles newProfileInfo) {
		heroProfiles foundProfile = profileRepo.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("Profile not found."));

		foundProfile.setName(newProfileInfo.getName());
		foundProfile.setDescription(newProfileInfo.getDescription());

		heroProfiles updatedProfile = profileRepo.save(foundProfile);

		return ResponseEntity.ok(updatedProfile);
	}

	@DeleteMapping("profile/{userid}")
	public ResponseEntity<String> deleteProfile(@PathVariable int userid) {
		profileRepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException("Profile not found."));

		String message = "Profile has been deleted.";

		profileRepo.deleteById(userid);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
