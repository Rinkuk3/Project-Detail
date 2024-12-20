package com.td.mbna.msec.midtier.statement;

import java.util.Comparator;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import com.mbnaweb.xsd.types.common.CardNumHistoryType;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
 * Sorting by start date
 * @author shenh4
 *
 */
public class CardHistoryComparable implements Comparator<CardNumHistoryType>{
	private static MbnaLogger logger = new MbnaLogger(CardHistoryComparable.class);

	@Override
	public int compare(CardNumHistoryType object1, CardNumHistoryType object2) {
		try {
			logger.toJson(object1);
			logger.toJson(object2);
			XMLGregorianCalendar xmlStartDate1 = object1.getStartDate();
			XMLGregorianCalendar xmlStartDate2 = object2.getStartDate();
			XMLGregorianCalendar xmlEndDate1 = object1.getEndDate();
			XMLGregorianCalendar xmlEndDate2 = object2.getEndDate();
			
			Date gStart1 = xmlStartDate1.toGregorianCalendar().getTime();
			Date gStart2 = xmlStartDate2.toGregorianCalendar().getTime();
			
			int statementDateCompareResult = gStart2.compareTo(gStart1); 
			
			if (statementDateCompareResult==0) {
				Date gEnd1 = null;
				Date gEnd2 = null;
				
				if (xmlEndDate1!=null) {
					gEnd1 = xmlEndDate1.toGregorianCalendar().getTime();
					if (xmlEndDate2!=null) {
						
						gEnd2 = xmlEndDate2.toGregorianCalendar().getTime();
						
						return gEnd1.compareTo(gEnd2);
						
					}
				}
			}else {
				return statementDateCompareResult;
			}
			
		}
		catch (Throwable ex) {
			logger.error(ex);
			throw ExceptionUtil.genRuntimeException(ex);
		}
		return 0;
	}

}
