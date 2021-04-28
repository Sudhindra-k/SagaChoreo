package com.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PaymentDto {
	
	private UUID orderId;
	private Integer userId;
	private Integer amount;

}
