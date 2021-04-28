package com.orderservice.order.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderservice.order.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, UUID> {

}
