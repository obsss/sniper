package org.arcada.tdd.sniper;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class AuctionSniperTests {

	@Test
	public void update_AuctionCloses_SniperHasLost() {
		SniperUI mockUI = mock(SniperUI.class);
		AuctionServer stubServer = mock(AuctionServer.class);
		AuctionSniper sniper = new AuctionSniper(stubServer, mockUI);
		
		when(stubServer.isActive(anyString())).thenReturn(true);
		sniper.startBiddingIn("item1");
		when(stubServer.isActive(anyString())).thenReturn(false);
		sniper.update();
		
		verify(mockUI).setStatus("lost");
	}
	
	
	@Test
	public void startBiddingIn_JoinAuction_UpdateUI() {
		SniperUI mockUI = mock(SniperUI.class);
		AuctionServer server = new AuctionServer();
		AuctionSniper sniper = new AuctionSniper(server, mockUI);
		
		server.startSellingItem("item1", 1);
		sniper.startBiddingIn("item1");
		
		verify(mockUI).showUI();
	}
	
}
