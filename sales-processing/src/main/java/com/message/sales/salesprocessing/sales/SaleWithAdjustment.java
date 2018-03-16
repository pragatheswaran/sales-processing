package com.message.sales.salesprocessing.sales;

public class SaleWithAdjustment extends SingleSale {
	
	AdjustmentType adjustmentType;

	public SaleWithAdjustment() {
	}

	public SaleWithAdjustment(String productType, Double productPrice,AdjustmentType adjustmentType) {
		super(productType, productPrice);
		this.adjustmentType = adjustmentType;
	}

	public SaleWithAdjustment(AdjustmentType adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public AdjustmentType getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(AdjustmentType adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

}
