package com.td.mbna.msec.midtier.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mbnaweb.xsd.types.statement.AvailableStatementListType;

/**
 * This class is responsible for fetching account activity based on a statement closing date
 *
 */
public class StatementUtil {
	public static final String DMS_MainStatement_Folder_Indicator = "MAINSTMT";
	public static final String DMS_HistStatement_Folder_Indicator = "HISTSTMT";
	public static final String DMS_MainStatementInsert_Folder_Indicator = "MAININSRT";
	public static final String DMS_HistStatementOngoingInsert_Folder_Indicator = "HISTONGINSRT";	  
	public static final String DMS_MainStatement_Folder_Default = "MBNA_Statements";
	public static final String DMS_HistStatement_Folder_Default = "MBNA_Statements";	  
	public static final String DMS_MainStatementInsert_Folder_Default = "MBNA_StatementInserts";	
	public static final String DMS_HistStatementOngoingInsert_Folder_Default = "MBNA_StatementInserts";
	public static final String TdOp_getMainStatementInsertInfo = "getMainStatementInsertInfo";
	public static final String DMS_MainStatementInsert_Folder_External_Property_Key = "statement.ongoing.insert.folder";	
	public static final String DMS_HistStatementOngoingInsert_Folder_External_Property_Key = "statement.ongoing.insert.folder";	
	public static final String DMS_MainStatementInsert_FormType_External_Property_Key = "statement.ongoing.insert.formtype";	
	public static final String DMS_HistStatementOngoingInsert_FormType_External_Property_Key = "statement.ongoing.insert.formtype";	
	public static final String DMS_LegalInsert_Match_Pattern_Default = "L.+";	
	public static final String DMS_LegalInsert_Match_Pattern_External_Property_Key = "statement.legal.insert.match.pattern";
	public static final int    MAX_NUMBER_OF_CYCLES_DISPLAYED = 13;
	public static final String DMS_formNumber = "FormNumber";	
	public static final String DMS_folderName = "OngInsertFolderName";	
	
	
	
	public static boolean isValidLegalInsertId(String insertIdParm) {
		Pattern pat;
		Matcher mat;
		boolean legalInsertIdMatched = false;
		
		//Trailing space will be stripped off.
		String legalInsertsPatternStr = ConfigUtil.getProperty(DMS_LegalInsert_Match_Pattern_External_Property_Key, DMS_LegalInsert_Match_Pattern_Default);
		pat = Pattern.compile(legalInsertsPatternStr);
		mat = pat.matcher(insertIdParm);
		legalInsertIdMatched = mat.matches(); 
		
		return legalInsertIdMatched;
	}
	
	public static String getFormId(String insertIdParm) {
		
		//12/11/2013 DMS re-design, no stripping
		
		return insertIdParm;
	}
	
	public static void limitCycles(AvailableStatementListType availStmtList) {
		
		while (availStmtList.getStatementEndDate().size() > StatementUtil.MAX_NUMBER_OF_CYCLES_DISPLAYED &&
				availStmtList.getStatementEndDate().size() == availStmtList.getStatementActivityStatus().size()) {
			// Remove the last entry in the EndDate
			availStmtList.getStatementEndDate().remove(availStmtList.getStatementEndDate().size() - 1);
			availStmtList.getStatementActivityStatus().remove(availStmtList.getStatementActivityStatus().size() - 1);
		}
	}

	public static void limitCycles(com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.AvailableStatementListType availStmtList) {

		while (availStmtList.getStatementEndDate().size() > StatementUtil.MAX_NUMBER_OF_CYCLES_DISPLAYED &&
				availStmtList.getStatementEndDate().size() == availStmtList.getStatementActivityStatus().size()) {
			// Remove the last entry in the EndDate
			availStmtList.getStatementEndDate().remove(availStmtList.getStatementEndDate().size() - 1);
			availStmtList.getStatementActivityStatus().remove(availStmtList.getStatementActivityStatus().size() - 1);
		}
	}
}
