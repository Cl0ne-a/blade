package com.awesome.blade.repoes;

import com.awesome.blade.model.BladeProfile;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WeightRepository extends CrudRepository<BladeProfile, Integer> {
	List<BladeProfile> findAllByLocalDateTime(LocalDateTime localDateTime);
}
