package com.message.sales.salesprocessing.sales;

public class MultipleSale extends SingleSale {
	private Double productQuantity;

	public MultipleSale() {
		super();
	}

	public MultipleSale(String productType, Double productPrice,Double productQuantity) {
		super(productType, productPrice);
		this.productQuantity = productQuantity;
	}

	public MultipleSale(Double productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Double getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Double productQuantity) {
		this.productQuantity = productQuantity;
	}
}
