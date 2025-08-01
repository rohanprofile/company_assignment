package com.app.dto;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetail {

	@NonNull
	private String id;
	//@NonNull
	private String event;
	@Valid
	private Payload payload ;
	@NonNull
	private Long created_at;
	
	
}
