package com.orderservice.order.config;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.events.inventory.InventoryEvent;
import com.events.payment.PaymentEvent;

@Configuration
public class EventHandlersConfig {

	
	@Autowired
	private OrderStatusEventUpdateHandler orderEventHandler;
	
	
	@Bean
	public Consumer<PaymentEvent> paymentEventConsumer(){
		
		return pe -> {
			orderEventHandler.updateOrder(pe.getPayment().getOrderId(), 
					po -> { po.setPaymentStatus(pe.getPaymentStatus()); 
						  });
		};
		
	}
	
	
	@Bean
	public Consumer<InventoryEvent> inventoryEventConsumer(){
		
		return ie -> {
						orderEventHandler.updateOrder(ie.getInventory().getOrderId(), 
								po -> { po.setInventoryStatus(ie.getStatus());
								      });
		};
		
	}
}
