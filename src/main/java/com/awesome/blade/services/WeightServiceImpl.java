package com.awesome.blade.services;

import com.awesome.blade.model.BladeProfile;
import com.awesome.blade.repoes.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

@Service
public class WeightServiceImpl implements WeightService {
	@Autowired
	private WeightRepository weightRepository;

	@Override
	public Optional<BladeProfile> getByDate(@NonNull LocalDateTime localDate) {
		return weightRepository.findAllByLocalDateTime(localDate)
				.stream().min(comparing(BladeProfile::getLocalDateTime));
	}

	@Override
	@Transactional
	public void saveWeight(Double weight) {
		BladeProfile profile = new BladeProfile();
		profile.setWeight(weight);
		profile.setLocalDateTime(LocalDateTime.now());
		weightRepository.save(profile);
	}

	@Override
	@Transactional
	public void saveWeightWithPastDate(Double weight, LocalDateTime dateAndTime) {
		BladeProfile profile = new BladeProfile();
		profile.setWeight(weight);
		profile.setLocalDateTime(dateAndTime);
		weightRepository.save(profile);
	}

	@Override
	public List<BladeProfile> getAll() {
		return (List<BladeProfile>) weightRepository.findAll();
	}
}
