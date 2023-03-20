package com.awesome.blade.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class BladeCurrentProfile {
	private int id;
	private LocalDate localDate;
	private Double weight;
}
