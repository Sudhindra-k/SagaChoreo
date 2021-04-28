package com.orderservice.order.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.OrderRequestDto;
import com.orderservice.order.entity.PurchaseOrder;
import com.orderservice.order.service.OrderCommandService;
import com.orderservice.order.service.OrderQueryService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderCommandService commandService;
	
	@Autowired
	private OrderQueryService queryService;
	
	
	@PostMapping("/create")
	public PurchaseOrder createOrder(@RequestBody OrderRequestDto requestdto) {
		
		requestdto.setOrderId(UUID.randomUUID());
		
		return this.commandService.createOrder(requestdto);
	}
	
	
	@GetMapping("/all")
	public List<PurchaseOrder> getOrders(){
		return this.queryService.getAll();
	}
}
