package org.arcada.tdd.sniper;

public class AuctionSniper {

	private AuctionItem item;
	private SniperUI ui;
	private AuctionServer server;
	
	public AuctionSniper(AuctionServer server, SniperUI ui) {
		this.ui = ui;
		this.server = server;
	}
	
	public void startBiddingIn(String name) {
		boolean exists = this.server.isActive(name);
		if (exists) {
			AuctionItem item = new AuctionItem();
			item.name = name;
			item.is_active = true;
			this.item = item;
			this.ui.addItem(name);
			this.ui.showUI();
		}
	}

	
	public void update() {
		String name = this.item.name;
		boolean active = this.server.isActive(name);
		if (!active) {
			this.item.is_active = false;
			this.ui.setStatus("lost");
			this.ui.showUI();
		}
	}
	
}


























