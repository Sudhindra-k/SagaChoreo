package com.orderservice.order.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.OrderRequestDto;
import com.events.order.OrderStatus;
import com.orderservice.order.entity.PurchaseOrder;
import com.orderservice.order.repository.PurchaseOrderRepository;

@Service
public class OrderCommandService {
	
	@Autowired
	private Map<Integer, Integer> productPriceMap;
	
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	private OrderStatusPublisher publisher;

	
	@Transactional
	public PurchaseOrder createOrder(OrderRequestDto orderRequestDto) {
		
		PurchaseOrder purchaseOrder = this.purchaseOrderRepository.save(this.dtoToEntity(orderRequestDto));
		this.publisher.raiseOrderEvent(purchaseOrder, OrderStatus.ORDER_CREATED);
		return purchaseOrder;
		
	}
	
	
	private PurchaseOrder dtoToEntity(final OrderRequestDto dto) {
		
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setId(dto.getOrderId());
		purchaseOrder.setProdcutId(dto.getProductId());
		purchaseOrder.setUserId(dto.getUserId());
		purchaseOrder.setOrderStatus(OrderStatus.ORDER_CREATED);
		purchaseOrder.setPrice(productPriceMap.get(purchaseOrder.getProdcutId()));
		return purchaseOrder;
		
	}
}
