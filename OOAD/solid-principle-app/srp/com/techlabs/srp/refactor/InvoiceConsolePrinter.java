package com.techlabs.srp.refactor;

public class InvoiceConsolePrinter {

	public void printInvoice(Invoice invoice) {
		System.out.println("No\tName\tCost");
		System.out.println(invoice.getNo() + "\t" + invoice.getName() + "\t"
				+ invoice.totalCost());
	}
}
