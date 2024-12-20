package com.td.mbna.msec.midtier.statement;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.mbnaweb.xsd.types.statement.HistoryStatementListType;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
 * 
 * This class contains a methods to compare statement dates.
 *
 */

public class SearchResultItemComparable implements Comparator<HistoryStatementListType>{
	
	private static final String STATEMENTDATE_DATE_FORMAT = "yyyyMMdd";
	private static final String LOADDATE_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	private static MbnaLogger logger = new MbnaLogger(SearchResultItemComparable.class);
	
	/**
	 * compare search results
	 */
	@Override
    public int compare(HistoryStatementListType item1, HistoryStatementListType item2){
        
		try {
			SimpleDateFormat stmtFmt = new SimpleDateFormat(STATEMENTDATE_DATE_FORMAT);
			Date statementDate1 = stmtFmt.parse(item1.getStatementDate());			
			Date statementDate2 = stmtFmt.parse(item2.getStatementDate());			
			int statementDateCompareResult = statementDate2.compareTo(statementDate1); //descending
			
			if(statementDateCompareResult == 0) {				
				SimpleDateFormat loadFmt = new SimpleDateFormat(LOADDATE_DATE_FORMAT);
				Date loadDate1 = loadFmt.parse(item1.getLoadDate());
				Date loadDate2 = loadFmt.parse(item2.getLoadDate());
				return loadDate2.compareTo(loadDate1);
			}
			else{
				return statementDateCompareResult;
			}
		}
		catch (Throwable ex) {
			logger.error(ex);
			throw ExceptionUtil.genRuntimeException(ex);
		}
    }
}
