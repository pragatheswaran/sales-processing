package com.message.sales.salesprocessing;

import java.util.List;

import com.message.sales.salesprocessing.sales.SingleSale;

public class SaleThread implements Runnable {
	
	private static final long MAX_MESSAGE_PROCESSING_CAPACITY = 50;
	private int processedMsg = 0;
	@Override
	public void run() {
		System.out.println("SaleThread entry");
		SalesProcessor processor = new SalesProcessor();	
		List<SingleSale> msgs = processor.readSaleMessage();
		while (true) {
			for(SingleSale msg :msgs) {
				processor.processMessage(msg);
				processedMsg++;
				if(processedMsg == MAX_MESSAGE_PROCESSING_CAPACITY) {
					
				}
			}
			break;
		}
		System.out.println("SaleThread exit");
	}
}
