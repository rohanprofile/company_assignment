package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entity {

	@NonNull
	private String id;
	@NonNull
	private String status;
	@NonNull
	private Long amount;
	@NonNull
	private String currency;
	
}
