package com.message.sales.salesprocessing.model;

import java.math.BigDecimal;

public class SaleMessage {
	
	private Double unitsSaled;
	private BigDecimal price;
	
	public SaleMessage(Double unitsSaled,BigDecimal price) {
		super();
		this.price = price;
	}
	public Double getUnitsSaled() {
		return unitsSaled;
	}
	public void setUnitsSaled(Double unitsSaled) {
		this.unitsSaled = unitsSaled;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
