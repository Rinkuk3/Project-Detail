package com.td.mbna.msec.midtier.util;

import java.math.BigDecimal;

/**
 * Utility class to convert income to yearly based on income frequency
 * MDM does not support income frequency, it needs be stored as yearly
 */
public class IncomeUtil {
	
	//1-Yearly
	public static final String YEARLY = "1";
	//2-Monthly
	public static final String MONTHLY = "2";
	//3-Bi-Weekly
	public static final String BIWEEKLY = "3";
	//4-Weekly
	public static final String WEEKLY = "4";
	// number of weeks per year
	public static final BigDecimal num_weeks = new BigDecimal(52);
	// number of biweeks per year
	public static final BigDecimal num_biweeks = new BigDecimal(26);
	// number of months per year
	public static final BigDecimal num_months = new BigDecimal(12);

	
	/** If Income Frequency (applies to both primary and additional) is different than annual,
	 * convert the amount to annual according to the frequency selected:
	 * a. Weekly: Income = Income * 52
	 * b. Bi-weekly: Income = Income * 26
	 * c. Monthly: Income = Income * 12 
	 * @param frenquency
	 * @param income
	 * @return
	 */
	public static BigDecimal convertIncome(String frenquency, BigDecimal income){
		if(frenquency!=null){
			if(frenquency.equalsIgnoreCase(YEARLY)){
		    	return income;
			}
			if (frenquency.equalsIgnoreCase(WEEKLY)) {
				return income.multiply(num_weeks);
			}
			if (frenquency.equalsIgnoreCase(MONTHLY)) {
				return income.multiply(num_months);
			}
			if (frenquency.equalsIgnoreCase(BIWEEKLY)) {
				return income.multiply(num_biweeks);
			}
		}
		return income;	
	}
}
