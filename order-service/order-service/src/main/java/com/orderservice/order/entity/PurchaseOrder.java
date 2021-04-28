package com.orderservice.order.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import com.events.inventory.InventoryStatus;
import com.events.order.OrderStatus;
import com.events.payment.PaymentStatus;

import lombok.Data;
import lombok.ToString;


@Data
@Entity
@ToString
public class PurchaseOrder {

	@Id
	private UUID Id;
	private Integer userId;
	private Integer prodcutId;
	private Integer price;
	private OrderStatus orderStatus;
	private PaymentStatus paymentStatus;
	private InventoryStatus inventoryStatus;
	
	@Version
	private int version;
	
}
