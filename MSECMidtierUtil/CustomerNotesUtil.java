package com.td.mbna.msec.midtier.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * This class contains the actual implementation of createCustomerNote and contains other utility methods.
 * 
 */
@Component
public class CustomerNotesUtil {
	public static final int MAX_LENGTH = 79;
	public static final int MAX_ARRAY = 25; // 5 notes, each note has 5 lines

	// double space separator
	public static final String SPACE_SEPARATOR = "  ";
	// single space separator
	public static final String SINGLE_SPACE = " ";

	private final static String DATE_TIME = "Date/Time: ";
	private final static String REQUEST_ORIGIN = "  Origin of request: OLB  Action performed: ";
	private final static String PRIMARY = "Primary";
	private final static String AUTHORIZED = "Authorized";
	private final static String USER = "  Initiating User: ";
	private final static String DASH = "-";
	private final static String X_OF_Y = "X of Y  ";
	public final static int LINE_HEADER_LENGTH = X_OF_Y.length();
	
	
	
	public static String getHeaderContent(com.td.mbna.msec.midtier.types.common.BaseRequest baseRequest, String actionPerformed) {
		SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(DATE_TIME);
		synchronized(formatDate){
			strBuilder.append(formatDate.format(new Date()));
		}
		strBuilder.append(REQUEST_ORIGIN);
		strBuilder.append(actionPerformed);
		strBuilder.append(USER);
		strBuilder.append((baseRequest.getIsPrimaryUser() == null ? false : baseRequest.getIsPrimaryUser().booleanValue()) ? PRIMARY : AUTHORIZED);
		strBuilder.append(SINGLE_SPACE);
		strBuilder.append(DASH);
		strBuilder.append(SINGLE_SPACE);
		strBuilder.append(baseRequest.getSessionInfo().getFirstName());
		strBuilder.append(SINGLE_SPACE);
		strBuilder.append(baseRequest.getSessionInfo().getLastName());
		strBuilder.append(SPACE_SEPARATOR);
		return strBuilder.toString();
	}

	public static String maskCardNum(String cardDigits, boolean delimitWithDash) {
		String rc = cardDigits;
		int cardLen = cardDigits.length();
		if (cardLen > 4) {
			StringBuilder sb = new StringBuilder(19);
			int numLastDigits = 4;
			int numDigitsInFront = cardLen - numLastDigits;
			int num4DigitGroupInFront = numDigitsInFront/4;
			for (int i = 0; i < num4DigitGroupInFront; i++) {
				sb.append(delimitWithDash ? "****-" : "****");
			}
			int numLeftOverDigits = cardLen - (4*num4DigitGroupInFront) - numLastDigits;
			if (numLeftOverDigits > 0) {
				for (int j = 0; j < numLeftOverDigits; j++) {
					sb.append("*");
				}
				if (delimitWithDash) {sb.append("-");}
			}
			sb.append(cardDigits.substring(cardLen-numLastDigits));
			rc = sb.toString();
		}
		return rc;
	}
	
}
