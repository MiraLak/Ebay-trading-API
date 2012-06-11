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
package helloWorld;

import java.io.IOException;
import java.util.Calendar;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;
import com.ebay.sdk.helper.ConsoleUtil;

/**
 * A Hello World-like sample, showing how to call eBay API using eBay SDK.
 * 
 * @author boyang
 * 
 */
public class ApplicationHelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			System.out.print("\n");
			System.out.print("+++++++++++++++++++++++++++++++++++++++\n");
			System.out.print("+ Welcome to eBay SDK for Java Sample +\n");
			System.out.print("+  - ConsoleAddItem                   +\n");
			System.out.print("+++++++++++++++++++++++++++++++++++++++\n");
			System.out.print("\n");

			// [Step 1] Initialize eBay ApiContext object
			System.out.println("===== [1] Account Information ====");
			ApiContext apiContext = getApiContext();

			// [Step 2] Create call object and execute the call
			GeteBayOfficialTimeCall apiCall = new GeteBayOfficialTimeCall(apiContext);
			System.out.println("Begin to cal eBay API, please wait ... ");
			Calendar cal = apiCall.geteBayOfficialTime();
			System.out.println("End to cal eBay API, show call result ...");

			// [Setp 3] Handle the result returned
			System.out.println("Official eBay Time : " + cal.getTime().toString());
		} catch (Exception e) {
			System.out.println("Fail to get eBay official time.");
			e.printStackTrace();
		}

	}

	/**
	 * Populate eBay SDK ApiContext object with data input from user
	 * 
	 * @return ApiContext object
	 */
	private static ApiContext getApiContext() throws IOException {

		String input;
		ApiContext apiContext = new ApiContext();

		// set Api Token to access eBay Api Server
		ApiCredential cred = apiContext.getApiCredential();
		input = ConsoleUtil.readString("Enter your eBay Authentication Token: ");
		cred.seteBayToken(input);

		// set Api Server Url
		input = ConsoleUtil.readString("Enter eBay SOAP server URL (e.g., https://api.ebay.com/wsapi): ");
		apiContext.setApiServerUrl(input);

		return apiContext;
	}

}