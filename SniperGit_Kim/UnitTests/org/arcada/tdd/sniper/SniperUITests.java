package org.arcada.tdd.sniper;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SniperUITests {

	@Test
	public void setStatus_NewStatus_ShowInUI() {
		SniperUI ui = new SniperUI();
		
		ui.addItem("item1");
		ui.setStatus("new-status");
		ui.showUI();
		String output = ui.display.toString();
		
		assertTrue(output.contains("new-status"));
	}
	
	
	@Test
	public void showUI_NewItem_ItemNameAppearsInUI() {
		AuctionServer stubServer = mock(AuctionServer.class);
		SniperUI ui = new SniperUI();
		AuctionSniper sniper = new AuctionSniper(stubServer, ui);
		when(stubServer.isActive(anyString())).thenReturn(true);
		
		sniper.startBiddingIn("item1");
		String output = ui.display.toString();
		
		assertTrue(output.contains("item1"));
	}	
}
