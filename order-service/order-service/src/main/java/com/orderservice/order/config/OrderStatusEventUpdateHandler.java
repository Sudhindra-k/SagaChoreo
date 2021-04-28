package com.orderservice.order.config;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.inventory.InventoryStatus;
import com.events.order.OrderStatus;
import com.events.payment.PaymentStatus;
import com.orderservice.order.entity.PurchaseOrder;
import com.orderservice.order.repository.PurchaseOrderRepository;
import com.orderservice.order.service.OrderStatusPublisher;

@Service
public class OrderStatusEventUpdateHandler {
	
	
	@Autowired
	private PurchaseOrderRepository repository;
	
	@Autowired
	private OrderStatusPublisher publisher;
	
	
	@Transactional
	public void updateOrder(final UUID id, Consumer<PurchaseOrder> consumer) {
		
		this.repository.findById(id).ifPresent(consumer.andThen(this::updateOrder));
		
	}
	
	
	
	private void updateOrder(PurchaseOrder purchaseOrder) {
		
		if(Objects.isNull(purchaseOrder.getInventoryStatus()) || Objects.isNull(purchaseOrder.getPaymentStatus()))
				return;
		
		var isComplete = PaymentStatus.RESERVED.equals(purchaseOrder.getPaymentStatus()) && InventoryStatus.RESERVED.equals(purchaseOrder.getInventoryStatus());
		
		var orderStatus = isComplete ? OrderStatus.ORDER_COMPLETED : OrderStatus.ORDER_CANCELLED;
		
		purchaseOrder.setOrderStatus(orderStatus);
		
		if(isComplete) {
			this.publisher.raiseOrderEvent(purchaseOrder, orderStatus);
		}
	}
	

}
