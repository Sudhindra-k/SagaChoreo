package com.dto;

import java.util.UUID;

import lombok.Data;


@Data
public class OrderRequestDto {
	

	private Integer userId;
	private Integer productId;
	private UUID orderId;
	
	
	
	
}
