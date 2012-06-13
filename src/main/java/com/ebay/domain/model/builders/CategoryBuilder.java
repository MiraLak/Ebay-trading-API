package com.ebay.domain.model.builders;

import com.ebay.soap.eBLBaseComponents.CategoryType;

public class CategoryBuilder implements Builder<CategoryType> {

	private String categoryId;

	public static CategoryBuilder aCategoryCreated(String categoryId) {
		CategoryBuilder builder = new CategoryBuilder();
		builder.withCategoryId(categoryId);
		return builder;
	}

	public CategoryBuilder withCategoryId(String id) {
		this.categoryId = id;
		return this;
	}

	@Override
	public CategoryType build() {
		CategoryType category = new CategoryType();
		category.setCategoryID(this.categoryId);
		return category;
	}

}
