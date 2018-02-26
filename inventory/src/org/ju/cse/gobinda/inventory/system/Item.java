package org.ju.cse.gobinda.inventory.system;

public class Item {

	private String itemName;
	private String itemAmount;
	private String itemUnit;

	public Item(String itemName, String itemAmount, String itemUnit) {
		this.itemName = itemName;
		this.itemAmount = itemAmount;
		this.itemUnit = itemUnit;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemAmount() {
		return itemAmount;
	}

	public String getItemUnit() {
		return itemUnit;
	}

}
