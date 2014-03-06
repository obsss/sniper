package org.arcada.tdd.sniper;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuctionSniper_AcceptanceTests {

	@Test
	public void AuctionSniper_JoinNoAction_Lose() throws Exception {
		AuctionServer server = new AuctionServer();
		SniperUI ui = new SniperUI();
		AuctionSniper sniper = new AuctionSniper(server, ui);
		
		server.startSellingItem("item1", 1);
		sniper.startBiddingIn("item1");
		server.announceClosed("item1");
		sniper.update();
		
		String output = ui.display.toString();
		assertTrue(output.contains("lost"));
	}
}
