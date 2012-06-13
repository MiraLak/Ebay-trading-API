package com.ebay.domain.model.builders;

import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;

public class ShippingDetailsBuilder implements Builder<ShippingDetailsType> {

	private Boolean applyShippingDiscount = true;

	public ShippingDetailsBuilder withApplyShippingDiscount(Boolean applyShippingDiscount) {
		this.applyShippingDiscount = applyShippingDiscount;
		return this;
	}

	@Override
	public ShippingDetailsType build() {
		ShippingDetailsType sd = new ShippingDetailsType();
		sd.setApplyShippingDiscount(this.applyShippingDiscount);

		AmountType amount = new AmountType();
		amount.setValue(2.8);
		sd.setPaymentInstructions("eBay Java SDK test instruction.");

		// FIXME: refactor Shipping type and shipping service options
		sd.setShippingType(ShippingTypeCodeType.FLAT);
		ShippingServiceOptionsType shippingOptions = new ShippingServiceOptionsType();
		shippingOptions.setShippingService(ShippingServiceCodeType.SHIPPING_METHOD_STANDARD.value());
		amount = new AmountType();
		amount.setValue(2.0);
		shippingOptions.setShippingServiceAdditionalCost(amount);
		amount = new AmountType();
		amount.setValue(10);
		shippingOptions.setShippingServiceCost(amount);
		shippingOptions.setShippingServicePriority(new Integer(1));
		amount = new AmountType();
		amount.setValue(1.0);
		shippingOptions.setShippingInsuranceCost(amount);

		sd.setShippingServiceOptions(new ShippingServiceOptionsType[] { shippingOptions });

		return sd;
	}

}
