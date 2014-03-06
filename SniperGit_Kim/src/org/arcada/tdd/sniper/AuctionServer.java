package org.arcada.tdd.sniper;

import java.util.*;

public class AuctionServer {

	private List<AuctionItem> items = new ArrayList<AuctionItem>();
	
	//########################################################
	// methods called directly from server, to manage auction
	
	public void startSellingItem(String name, int price) {
		AuctionItem item = new AuctionItem();
		item.name = name;
		item.price = price;
		this.items.add(item);	
	}
	
	public void bidFromAnotherPerson(String name, int amount) {
		for (AuctionItem item : this.items) {
			if (item.name.equals(name)) {
				if (item.price < amount) {
					item.price = amount;
					item.last_bidder = "another person";
				};
				return;
			}
		}
	}
	
	public void announceClosed(String name) {
		for (AuctionItem item : this.items) {
			if (item.name.equals(name)) {
				item.is_active = false;
			}
		}
	}

	//########################################################
	// methods called by Auction Sniper
	
	public int getPrice(String name) throws Exception {
		for (AuctionItem item : this.items) {
			if (item.name.equals(name)) {
				return item.price;
			}
		}
		throw new Exception("Item does not exist");
	}
	
	public boolean isActive(String name) {
		for (AuctionItem item : this.items) {
			if (item.name.equals(name)) {
				return item.is_active;
			}
		}
		return false;
	}
	
	// FIXXXAAAAAAAAAAAAAAAAAAAAARRRNNNNNNNNNNN
	public void makeBid(String name, int amount) throws Exception {
		for (AuctionItem item : this.items) {
			if (item.name.equals(name)) {
				if (item.price < amount) {
					item.price = amount;
					item.last_bidder = "AuctionSniper";
				}
				return;
			}
		}
		throw new Exception("Item does not exist");		
	}
}
