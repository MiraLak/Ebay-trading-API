package com.ebay.trading.application.impl;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.AddItemCall;
import com.ebay.sdk.call.AddToItemDescriptionCall;
import com.ebay.sdk.call.EndItemCall;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.trading.application.TradingService;

public class TradingServiceImpl implements TradingService {

	// Test account token to replace with yours.
	private static final String ACCOUNT_TOKEN = "AgAAAA**AQAAAA**aAAAAA**DQLSTw**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFk4GhCJmBqQqdj6x9nY+seQ**x9QBAA**AAMAAA**95LoAuP+eThzqowtiA0Bva7MSqfflr0RTeQatvkADb3qICLLy6tGrSaI/s0MboMwK/+EJPkXgHLC073+N3t3GYAU01YnfDXbeLiZnx4aJGNhnmEe9ArHEhYQGRMvxiZVNNAeDu0n19ht+u+TZTYkS/5np/4K2S5+Hd2ELkR2akKulIEi6aJMC57U3WTGu/W5XCBMVggWOsj/PO/MUWDhDUJ1D+JgLY5xCokYB+c9ObpJdxlM4itoDTr/fMPgwlz8OTNZH0Xs8MDHukGFivEvsysrW8JbDeo0sMOC1U9apBN811ph8OaxhnQ5aByMd7VCyu/XuggqR/BbDlq0UQ08xUYNk6LCXqdqy4bUWGxoj2AcKxgE2XkB6nC8HHTn/cIC9dKazEricRn7UvXrvo/t8Q7eHyk7QPjDIUW86PVKjj/uq1Fo7rad1uyDYjVwRb52mZe+PafeuTJLG0m43rwiiEB7UAEC8kqYR0A2IBAE2uvg5VIHMxr8Lqnall0uxoCVo8S+QmidjNZQnlKD1d03+jfZNijN1vc97aaYeghlWAERc9jCxzzfXLHQptZTpLEs5s5LJbQPX3RV3PK1yafJ69/iQLH+tWRTzC6wgvnRlI8Ag4Iw5+R/a5PM7REcEK4S6nkZXQvonQqT44M/73p2ycCAbQKhqBzsLUJB37RmMGIdQSvNqJV1uNz2vBsYkslF6emM/LE/ce86seCgfF81OuSthTYkkaIBJ2ieGDe7y/9sAkF2sWoEuRZS03iffNoA";
	private static final String SERVER_URL = "https://api.sandbox.ebay.com/wsapi";

	@Override
	public void addNewItem(ItemType item) throws ApiException, SdkException, Exception {
		AddItemCall api = new AddItemCall(getApiContext());
		api.setItem(item);
		api.addItem();
	}

	@Override
	public void updateItemDescription(String itemID, String description) throws ApiException, SdkException, Exception {

		AddToItemDescriptionCall api = new AddToItemDescriptionCall(getApiContext());
		api.setItemID(itemID);
		api.setDescription(description);
		api.addToItemDescription();
	}

	@Override
	public void endItemSell(String itemID, EndReasonCodeType endingReason) throws ApiException, SdkException, Exception {
		EndItemCall api = new EndItemCall(getApiContext());
		api.setItemID(itemID);
		api.setEndingReason(endingReason);
		api.endItem();
	}

	@Override
	public void deleteUnsoldItem(String itemID) {
		// TODO Auto-generated method stub

	}

	/**
	 * Populate eBay SDK ApiContext object with data input from user
	 * 
	 * @return ApiContext object
	 */
	public static ApiContext getApiContext() {

		ApiContext apiContext = new ApiContext();

		// set Api Token to access eBay Api Server
		ApiCredential cred = apiContext.getApiCredential();
		cred.seteBayToken(ACCOUNT_TOKEN);

		// set Api Server Url
		apiContext.setApiServerUrl(SERVER_URL);

		return apiContext;
	}
}
