package org.arcada.tdd.sniper;

import java.util.*;

public class SniperUI {
	
	class ExtendedItem extends AuctionItem {
		public String status;
	}
	
	private ExtendedItem item;
	
	public List<String> display; 
	
	public void addItem(String name) {
		ExtendedItem item = new ExtendedItem();
		item.name = name;
		item.status = "bidding";
		this.item = item;
	}
	
	public void setStatus(String new_status) {
		this.item.status = new_status;
	}
	
	public void showUI() {
		this.display = new ArrayList<String>();
		this.display.add("#### AuctionSniper ###");
		String s = String.format("%s : %s", this.item.name, this.item.status);
		this.display.add(s);
		this.display.add("######################");
		
		for (String s1 : this.display) {
			System.out.println(s1);
		}
	}
}
