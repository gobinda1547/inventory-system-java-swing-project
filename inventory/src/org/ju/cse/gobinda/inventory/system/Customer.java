package org.ju.cse.gobinda.inventory.system;

public class Customer {

	private String customerName;
	private String customerMobileNumber;
	private String customerDetails;
	private String customerDueBill;

	public Customer(String customerName, String customerMobileNumber, String customerDetails, String customerDueBill) {
		this.customerName = customerName;
		this.customerMobileNumber = customerMobileNumber;
		this.customerDetails = customerDetails;
		this.customerDueBill = customerDueBill;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public String getCustomerDetails() {
		return customerDetails;
	}

	public String getCustomerDueBill() {
		return customerDueBill;
	}

}
