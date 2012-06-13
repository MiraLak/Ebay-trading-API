/*
 * 
 *  * ========================================================= *
 *  *************************************************************
 *  *      _______. _______  _______ .___________.____    ____  *
 *  *     /       ||   ____||   ____||           |\   \  /   /  *
 *  *    |   (----`|  |__   |  |__   `---|  |----` \   \/   /   *
 *  *     \   \    |   __|  |   __|      |  |       \_    _/    *
 *  * .----)   |   |  |____ |  |____     |  |         |  |      *
 *  * |_______/    |_______||_______|    |__|         |__|      *
 *  *                                                           *
 *  *************************************************************
 *  * ========================================================= *
 *           _____  _   _      _   
 *     /\   |  __ \| \ | |    | |  
 *    /  \  | |  | |  \| | ___| |_ 
 *   / /\ \ | |  | | . ` |/ _ \ __|
 *  / ____ \| |__| | |\  |  __/ |_ 
 * /_/    \_\_____/|_| \_|\___|\__|
 * 
 * 
 * 
 * NOTICE:
 * 
 * ##################################################################################
 * #                                                                                #
 * # This file is part of the Seety project.                                        #
 * # All information contained herein is, remains the property of PagesJaunes Group #
 * # The intellectual and technical concepts contained herein are proprietary to    #
 * # PagesJaunes Group and may be covered by Patents, patents in process, and are   #
 * # protected by trade secret or copyright law.                                    #
 * #                                                                                #
 * # Dissemination of this information or reproduction of this material is strictly #
 * # forbidden unless prior written permission is obtained from PagesJaunes Group.  #
 * #                                                                                #
 * # All Right Reserved                                                             #
 * # Copyright (c) 2011 , PagesJaunes Group                                         #
 * #                                                                                #
 * ##################################################################################
 */
package com.ebay.domain.model.builders;

import com.ebay.soap.eBLBaseComponents.BuyerPaymentMethodCodeType;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDurationCodeType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.ReturnPolicyType;

public class ItemBuilder implements Builder<ItemType> {

	private String title = "";
	private String description = "";
	private ListingTypeCodeType listingType = ListingTypeCodeType.FIXED_PRICE_ITEM;
	private CurrencyCodeType currency = CurrencyCodeType.EUR;
	private AmountBuilder amountBuilder;
	private ListingDurationCodeType listingDuration = ListingDurationCodeType.DAYS_1;
	private CountryCodeType countryCode = CountryCodeType.FR;
	private String location;
	private CategoryBuilder categoryBuilder;
	private Integer quantity = 1;
	private String paypalMail = "me@ebay.com";
	private ShippingDetailsBuilder shippingBuilder;

	public static ItemBuilder anItemCreated(//
			String title,//
			String description, //
			ListingTypeCodeType listingType, //
			AmountBuilder amountBuilder, //
			CurrencyCodeType currency,//
			ListingDurationCodeType listingDuration, //
			CountryCodeType countryCode, //
			String location, //
			CategoryBuilder categoryBuilder, //
			Integer quantity,//
			String paypalMail,//
			ShippingDetailsBuilder shippingBuilder) {
		ItemBuilder builder = new ItemBuilder();
		builder.withTitle(title);
		builder.withDescription(description);
		builder.withListningType(listingType);
		builder.withAmountBuilder(amountBuilder);
		builder.withCurrency(currency);
		builder.withListningDurationType(listingDuration);
		builder.withCountryCodeType(countryCode);
		builder.withLocation(location);
		builder.withCategoryBuilder(categoryBuilder);
		builder.withQuantity(quantity);
		builder.withPayPalMail(paypalMail);
		builder.withShippingBuilder(shippingBuilder);
		return builder;
	}

	public ItemBuilder withTitle(String title) {
		this.title = title;
		return this;
	}

	public ItemBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public ItemBuilder withCurrency(CurrencyCodeType currency) {
		this.currency = currency;
		return this;
	}

	public ItemBuilder withListningType(ListingTypeCodeType listingType) {
		this.listingType = listingType;
		return this;
	}

	public ItemBuilder withAmountBuilder(AmountBuilder amountBuilder) {
		this.amountBuilder = amountBuilder;
		return this;
	}

	public ItemBuilder withListningDurationType(ListingDurationCodeType listingDuration) {
		this.listingDuration = listingDuration;
		return this;
	}

	public ItemBuilder withCountryCodeType(CountryCodeType countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	public ItemBuilder withLocation(String location) {
		this.location = location;
		return this;
	}

	public ItemBuilder withCategoryBuilder(CategoryBuilder categoryBuilder) {
		this.categoryBuilder = categoryBuilder;
		return this;
	}

	public ItemBuilder withQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public ItemBuilder withPayPalMail(String paypalMail) {
		this.paypalMail = paypalMail;
		return this;
	}

	public ItemBuilder withShippingBuilder(ShippingDetailsBuilder shippingBuilder) {
		this.shippingBuilder = shippingBuilder;
		return this;
	}

	@Override
	public ItemType build() {
		ItemType item = new ItemType();
		item.setTitle(this.title);
		item.setDescription(this.description);
		item.setListingType(this.listingType);
		item.setStartPrice(this.amountBuilder.build());
		item.setCurrency(this.currency);
		item.setListingDuration(this.listingDuration.value());
		item.setCountry(this.countryCode);
		item.setLocation(this.location);
		item.setPrimaryCategory(this.categoryBuilder.build());
		item.setQuantity(this.quantity);
		item.setPaymentMethods(new BuyerPaymentMethodCodeType[] { BuyerPaymentMethodCodeType.PAY_PAL });
		item.setPayPalEmailAddress(this.paypalMail);
		item.setShippingDetails(this.shippingBuilder.build());

		// FIXME replace test parameters with dynamic ones
		item.setConditionID(1000);
		item.setDispatchTimeMax(Integer.valueOf(1));
		ReturnPolicyType returnPolicy = new ReturnPolicyType();
		returnPolicy.setReturnsAcceptedOption("ReturnsAccepted");
		item.setReturnPolicy(returnPolicy);
		return item;
	}

}
