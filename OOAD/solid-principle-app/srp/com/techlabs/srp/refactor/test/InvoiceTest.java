package com.techlabs.srp.refactor.test;

import com.techlabs.srp.refactor.Invoice;
import com.techlabs.srp.refactor.InvoiceConsolePrinter;

public class InvoiceTest {

	public static void main(String args[]) {
		Invoice invoice = new Invoice(1, "milk", 20, 1);
		new InvoiceConsolePrinter().printInvoice(invoice);
	}	
}
