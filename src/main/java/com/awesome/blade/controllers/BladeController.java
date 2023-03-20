package com.awesome.blade.controllers;

import com.awesome.blade.model.BladeProfile;
import com.awesome.blade.services.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("blade")
public class BladeController {
	@Autowired
	private WeightService weightService;
	// hello-page
	@GetMapping("/today")
	public ResponseEntity<BladeProfile> getCurrentProfile() {
		var currentProfile = weightService.getByDate(LocalDateTime.now());
		// TODO: 3/25/23 chenge orElse to the latest available
		return ResponseEntity.ok(currentProfile.orElse(new BladeProfile()));
	}

	@PutMapping("/add/{weight}")
	public void newWeightDataPut(@PathVariable("weight") Double weight) {
		weightService.saveWeight(weight);
	}

	// TODO: 3/25/23 make available set weight by different date from today
}
