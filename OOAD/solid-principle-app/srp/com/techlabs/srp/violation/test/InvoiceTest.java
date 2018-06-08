package com.techlabs.srp.violation.test;

import com.techlabs.srp.violation.Invoice;

public class InvoiceTest {
	
	public static void main(String args[])
	{
		Invoice invoice=new Invoice(1,"milk", 20, 1);
		invoice.printInvoice();
	}
}
