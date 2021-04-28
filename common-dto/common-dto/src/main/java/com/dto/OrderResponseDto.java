package com.dto;

import java.util.UUID;

import com.events.order.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class OrderResponseDto {

	private UUID orderId;
	private Integer userId;
	private Integer productId;
	private Integer amount;
	private OrderStatus status;

	
}
