package com.awesome.blade.services;

import com.awesome.blade.model.BladeProfile;
import com.awesome.blade.repoes.WeightRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class WeightServiceImplTest {

	@Autowired
	private WeightService weightService;
	@MockBean
	private WeightRepository weightRepository;

	@Test
	void name() {
		ArgumentCaptor<BladeProfile> captor = ArgumentCaptor.forClass(BladeProfile.class);
		BladeProfile profile = new BladeProfile();
		double weight = 40;
		profile.setWeight(weight);
		profile.setLocalDateTime(LocalDateTime.now());
		when(weightRepository.save(any())).thenReturn(profile);

		weightService.saveWeight(weight);
		verify(weightRepository, times(4)).save(captor.capture());
		assertThat(profile.getWeight()).isEqualTo(captor.getValue().getWeight());
		assertThat(profile.getLocalDateTime()).isBeforeOrEqualTo(captor.getValue().getLocalDateTime());
	}
}