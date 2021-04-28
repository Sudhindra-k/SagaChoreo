package com.orderservice.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.order.entity.PurchaseOrder;
import com.orderservice.order.repository.PurchaseOrderRepository;

@Service
public class OrderQueryService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	
	public List<PurchaseOrder> getAll(){
		return this.purchaseOrderRepository.findAll();
	}
	
}
