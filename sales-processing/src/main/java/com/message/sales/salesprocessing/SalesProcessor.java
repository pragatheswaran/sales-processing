package com.message.sales.salesprocessing;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.message.sales.salesprocessing.model.Product;
import com.message.sales.salesprocessing.model.SaleMessage;
import com.message.sales.salesprocessing.sales.MultipleSale;
import com.message.sales.salesprocessing.sales.SingleSale;

public class SalesProcessor {
	Map<Product, List<SaleMessage>> allMessages;
	Map<Product, List<SaleMessage>> processedMessages;
	public SalesProcessor() {
		this.allMessages = new HashMap<>();
		this.processedMessages = new HashMap<>();
	}
	
	public List<SingleSale> readSaleMessage(){
		List<SingleSale> saleMsgs = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

    	try {
			saleMsgs = mapper.readValue(new File("C:\\Users\\Admin\\Downloads\\sales-processing\\SampleInput\\testdata.json"), new TypeReference<List<SingleSale>>(){});
			System.out.println("readSaleMessage size"+saleMsgs.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return saleMsgs;
	}

	public void processMessage(SingleSale msg) {
		//findProduct(msg);
		Product product = new Product(msg.getProductType(),msg.getProductPrice());
		for(Map.Entry<Product, List<SaleMessage>> map :allMessages.entrySet()) {
			List<SaleMessage> list = allMessages.get(product);		
			if(msg instanceof SingleSale) {
				product.setUnitsSaled(product.getUnitsSaled()+1);
				SaleMessage slmsg = new SaleMessage(Double.valueOf(1),BigDecimal.valueOf(product.getProductPrice()));
				list.add(slmsg);
			} else if(msg instanceof MultipleSale) {
				MultipleSale ms = (MultipleSale) msg;
				product.setUnitsSaled(product.getUnitsSaled()+ms.getProductQuantity());	
				SaleMessage slmsg = new SaleMessage(ms.getProductQuantity(),BigDecimal.valueOf(product.getProductPrice()));
				list.add(slmsg);
			}
			allMessages.put(product, list);
		/*} else {
			List<SingleSale> list = new ArrayList<>();
			list.add(msg);
			//allMessages.put(product, list);
		}
	*/}}
	
}
