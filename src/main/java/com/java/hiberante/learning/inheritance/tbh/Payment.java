package com.java.hiberante.learning.inheritance.tbh;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
	
	private int paymentId;
	private BigDecimal amount;
	private Date paymentDate;
	
	public Payment() {
		
	}
	
	public Payment(int paymentId, BigDecimal amount, Date paymentDate) {
		
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	

}
