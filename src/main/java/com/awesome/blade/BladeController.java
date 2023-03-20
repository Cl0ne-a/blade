package com.awesome.blade;

import com.awesome.blade.model.BladeCurrentProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blade")
public class BladeController {
	@GetMapping("/today")
	public ResponseEntity<BladeCurrentProfile> getCurrentProfile() {
		var currentProfile = new BladeCurrentProfile();
		return ResponseEntity.ok(currentProfile);
	}
}
