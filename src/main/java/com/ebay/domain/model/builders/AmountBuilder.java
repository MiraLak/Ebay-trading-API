package com.ebay.domain.model.builders;

import com.ebay.soap.eBLBaseComponents.AmountType;

public class AmountBuilder implements Builder<AmountType> {

	private Double value;

	public static AmountBuilder anAmountCreated(Double value) {
		AmountBuilder builder = new AmountBuilder();
		builder.withValue(value);
		return builder;
	}

	public AmountBuilder withValue(Double value) {
		this.value = value;
		return this;
	}

	@Override
	public AmountType build() {
		AmountType amount = new AmountType();
		amount.setValue(value);
		return amount;
	}

}
