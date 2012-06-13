package com.ebay.trading.application;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;

public interface TradingService {

	public void addNewItem(ItemType item) throws ApiException, SdkException, Exception;

	public void updateItemDescription(String itemID, String description) throws ApiException, SdkException, Exception;

	public void endItemSell(String itemID, EndReasonCodeType endingReason) throws ApiException, SdkException, Exception;

	public void deleteUnsoldItem(String itemID);
}
