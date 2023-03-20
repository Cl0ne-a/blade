package com.awesome.blade.services;

import com.awesome.blade.model.BladeProfile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface WeightService {

	Optional<BladeProfile> getByDate(LocalDateTime localDateTime);

	void saveWeight(Double weight);

	void saveWeightWithPastDate(Double weight, LocalDateTime dateAndTime);

	List<BladeProfile> getAll();
}
