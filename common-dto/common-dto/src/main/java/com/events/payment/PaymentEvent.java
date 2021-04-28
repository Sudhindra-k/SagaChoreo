package com.events.payment;

import java.util.Date;
import java.util.UUID;
import com.dto.PaymentDto;
import com.events.Event;


import lombok.Data;


@Data
public class PaymentEvent implements Event {
	
	private final UUID eventId = UUID.randomUUID();
    private final Date date = new Date();
    private PaymentDto payment;
    private PaymentStatus paymentStatus;

	public PaymentEvent() {
	}

	public PaymentEvent(PaymentDto payment, PaymentStatus paymentStatus) {
		this.payment = payment;
		this.paymentStatus = paymentStatus;
	}



	@Override
	public UUID getEventId() {
		return this.eventId;
	}

	@Override
	public Date getDate() {
		return this.date;
	}

	public PaymentDto getPayment() {
		return payment;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	
	
	
	

}
