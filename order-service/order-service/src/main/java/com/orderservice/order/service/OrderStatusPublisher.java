package com.orderservice.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.PurchaseOrderDto;
import com.events.order.OrderEvent;
import com.events.order.OrderStatus;
import com.orderservice.order.entity.PurchaseOrder;

import reactor.core.publisher.Sinks;

@Service
public class OrderStatusPublisher {

	@Autowired
	private Sinks.Many<OrderEvent> orderSink;
	
	
	public void raiseOrderEvent(final PurchaseOrder purchaseOrder, OrderStatus orderStatus) {
		
		var dto = PurchaseOrderDto.of(
						purchaseOrder.getId(),
						purchaseOrder.getProdcutId(),
						purchaseOrder.getPrice(),
						purchaseOrder.getUserId()
				);
		
		var orderEvent = new OrderEvent(dto, orderStatus);
		
		this.orderSink.tryEmitNext(orderEvent);
		
		
	}
}
