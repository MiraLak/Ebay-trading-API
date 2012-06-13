package com.ebay.trading.application;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ebay.domain.model.builders.AmountBuilder;
import com.ebay.domain.model.builders.CategoryBuilder;
import com.ebay.domain.model.builders.ItemBuilder;
import com.ebay.domain.model.builders.ShippingDetailsBuilder;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDurationCodeType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.trading.application.impl.TradingServiceImpl;

public class TradingIntegrationTest {

	private TradingServiceImpl service;
	private ItemType item;

	@Before
	public void setUp() {
		service = new TradingServiceImpl();
		item = createAnItem();
	}

	@After
	public void tearDown() {
		try {
			service.endItemSell(item.getItemID(), EndReasonCodeType.LOST_OR_BROKEN);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addingNewItem() {
		try {
			service.addNewItem(item);
			Assert.assertNotNull(item.getItemID());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ItemType createAnItem() {

		return ItemBuilder.anItemCreated("itemTest", //
				"descriptionTest",//
				ListingTypeCodeType.FIXED_PRICE_ITEM,//
				new AmountBuilder().withValue(122.0),//
				CurrencyCodeType.USD,//
				ListingDurationCodeType.DAYS_3,//
				CountryCodeType.US,//
				"LA",//
				new CategoryBuilder().withCategoryId("357"),//
				new Integer(1),//
				"me@ebay.com",//
				new ShippingDetailsBuilder().withApplyShippingDiscount(true)).build();
	}

}
