package com.message.sales.salesprocessing.sales;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "saleType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MultipleSale.class, name="MultipleSale"),
        @JsonSubTypes.Type(value = SaleWithAdjustment.class,name="SaleWithAdjustment")
})
public class SingleSale {
	
	private String productType;
	private Double productPrice;
	
	public SingleSale() {
	}
	
	public SingleSale(String productType, Double productPrice) {
		super();
		this.productType = productType;
		this.productPrice = productPrice;
	}
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
}
