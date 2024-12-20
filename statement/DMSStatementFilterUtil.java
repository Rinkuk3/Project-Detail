package com.td.mbna.msec.midtier.statement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mbnaweb.xsd.types.common.CardNumHistoryType;
import com.mbnaweb.xsd.types.statement.HistoryStatementListType;
import com.td.mbna.msec.midtier.util.MbnaLogger;

public class DMSStatementFilterUtil {
	
	private final static MbnaLogger logger = new MbnaLogger(DMSStatementFilterUtil.class);
	
	/**
	 * filtering the statement list from DMS - removing stmts that shouldn't be displayed 
	 * and ensuring the stmt with the latest load date is displayed.
	 * @param stmtInfoList
	 * @param cardList - a list that represents the history of card numbers of the account in session
	 * @return
	 */
	public static List<HistoryStatementListType> filterStatements(List<HistoryStatementListType> stmtInfoList, List<CardNumHistoryType> cardList) {
	
		List<HistoryStatementListType> stmtInfoListUI = new ArrayList<HistoryStatementListType>();
		
		if (stmtInfoList == null || stmtInfoList.isEmpty()) {
			//nothing to do. just return a blank stmt info list object for the UI
			return stmtInfoListUI;
		}

		ArrayList<String> cardListForComparsion = new ArrayList<String>(cardList.size());
		for (CardNumHistoryType card: cardList) {
			//putting the cards in a list so that it can be compared with the the card numebrs in the stmtInfolist object
			cardListForComparsion.add(card.getCard());
		}
		
		List<HistoryStatementListType> stmtInfoListCopy = new ArrayList<HistoryStatementListType>(stmtInfoList);
		for (Iterator<HistoryStatementListType> iterator = stmtInfoListCopy.iterator(); iterator.hasNext(); ) {
			HistoryStatementListType dmsResp = iterator.next();
			dmsResp.setValid(true);
			if (!cardListForComparsion.contains(dmsResp.getAccountNumber())){
		      
				//updating the flag
				dmsResp.setValid(false);
				StringBuffer log = new StringBuffer();
				log.append("SSMT-007: the card number in the DMS response does not match the card number in the request. ");
				log.append(dmsResp.getStatementDate() + "DMS card vs request card: ["+ mask(dmsResp.getAccountNumber()) + " vs " +mask(cardList)+"]");
				logger.warn(log.toString());
		    }
		}
		//cannot always rely on DMS for the order of statements - hence we always sort
		Collections.sort(stmtInfoList, new SearchResultItemComparable());
		
		//always sort the card history list. CODS may not sort for us
		Collections.sort(cardList, new CardHistoryComparable());
			
		String stmtDt="";
		String previousAcctNum="";	
		HistoryStatementListType previouslyAdded = null;
		
		for (int i=0; i<stmtInfoList.size(); i++) {
			logger.debug("processing: statementdate="+stmtInfoList.get(i).getStatementDate()+" loaddate=" + stmtInfoList.get(i).getLoadDate() +" cardNbr="+ mask(stmtInfoList.get(i).getAccountNumber()));
		
			if ( ! stmtDt.equals(stmtInfoList.get(i).getStatementDate()) ) {																								
					previouslyAdded = stmtInfoList.get(i);
					stmtInfoListUI.add(stmtInfoList.get(i));
					stmtDt = stmtInfoList.get(i).getStatementDate();
					previousAcctNum=previouslyAdded.getAccountNumber();								
					logger.debug("Added "+ stmtInfoList.get(i));
			}else {
				HistoryStatementListType currentStmt = stmtInfoList.get(i);								
				if (previousAcctNum!=null && previousAcctNum.equals(currentStmt.getAccountNumber())) {
					//the card # is the same as the previous card,
					//then i need to skip this as the previous statement added is the latest. (stmtInfoListCopy is sorted)
					logger.debug("Not added - it's older than the first statement added with same cycle date: " + stmtInfoList.get(i).getStatementDate()+" " + stmtInfoList.get(i).getLoadDate());
				}else {
					/**
					 * For L/S converted statements, it's possible to have multiple entries for the same cycle with the same load date. 
					 * If this is the case, we have to display the statement of the current account.
					 * This is incident 769
					 */
					//current stmt card # not the same as previously added card num

						String currentStmtDate = currentStmt.getStatementDate();
						String currentStmtAccountNum = currentStmt.getAccountNumber();
						if (!isActiveInStatementPeriod(currentStmtAccountNum, currentStmtDate, cardList)) {
							logger.debug("not added - the card of the statment isn't in use during this period");
							continue;
						}else {																																

							CardNumHistoryType previousCard = getCardByNbr(previousAcctNum,cardList);
							CardNumHistoryType currentCard = getCardByNbr(currentStmtAccountNum,cardList);

							Date previousCardStartDate = previousCard.getStartDate().toGregorianCalendar().getTime();
							Date currentCardStartDate = currentCard.getStartDate().toGregorianCalendar().getTime();
							if (previousCardStartDate.compareTo(currentCardStartDate)>=0) {
								//if the startdate of the previous card is later than the start date of the current card, don't add
								logger.debug("not added - the previously added statement is newer. ");
							}else {
								stmtInfoListUI.remove(previouslyAdded);											
																			
								//current card number in the stmt entry is the active one. add it
								if (currentStmt.getAccountNumber()!=null) {
									stmtInfoListUI.add(stmtInfoList.get(i));													
									logger.debug("replaced " + previouslyAdded.getDocumentId() + " with "+stmtInfoList.get(i).getDocumentId());
									previouslyAdded=stmtInfoList.get(i);	
									previousAcctNum=stmtInfoList.get(i).getAccountNumber();
								}else {
									logger.warn("not added - this statement entry doesn't have an account #. ");
								}
							}

						}

				}

			}

		}
		

		return stmtInfoListUI;
	}
	
	private static String mask(List<CardNumHistoryType> cardList) {
		StringBuilder maskedCards = new StringBuilder();
		for (int m=0; m<cardList.size(); m++) {
			maskedCards.append("," +mask(cardList.get(m).getCard()));
		}
		return maskedCards.toString();
	}

	private static String mask(String card) {
		if (card!=null) {
			return card.substring(card.length()-4, card.length());
		}
		return null;
	}

	private static CardNumHistoryType getCardByNbr(String cardNum, List<CardNumHistoryType> cardList) {
		for (CardNumHistoryType card: cardList) {
			if (cardNum.equals(card.getCard())) { 
				return card;
			}			
		}
		return null;
	}

	private static boolean isActiveInStatementPeriod(String cardNum, String stmtDate,List<CardNumHistoryType> cardList){
		try {
			CardNumHistoryType card = getCardByNbr(cardNum,cardList);
			if (cardNum.equals(card.getCard())) {
				Date start = null;
				Date end = null;
				
				if (card.getStartDate()!=null) {
					start = card.getStartDate().toGregorianCalendar().getTime();
				}
				
				if (card.getEndDate()!=null) {
					end = card.getEndDate().toGregorianCalendar().getTime();
				}
								
				Date stmtDt = stringToDate(stmtDate);
				
				if (end==null) { //no end date
					if (start.compareTo(stmtDt)<0 || start.compareTo(stmtDt)==0) {
						return true;
					}					
				} else {
					if ((start.compareTo(stmtDt)<0 || start.compareTo(stmtDt)==0) && (end.compareTo(stmtDt)>0 || end.compareTo(stmtDt)==0)) {
						return true;
					}						
				}
			}
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		
		return false;
	}
	
	
	private static Date stringToDate(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			synchronized(sdf){
			return sdf.parse(date);
			}
		}catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return null;
	}
	

	
	public static String buildDMSCardList(List<CardNumHistoryType> historyCards) {
		if (historyCards == null) {
			logger.warn("card list size is null");
			return "";
		}
		
		if (historyCards.size()==0) {
			logger.warn("card list size is 0");
			return "";
			
		}
		
    	StringBuilder historyCardsParm = new StringBuilder();
    	if ((historyCards != null) && (historyCards.size()>0)) {
    		historyCardsParm.append(historyCards.get(0).getCard());
    		for (int m=1; m<historyCards.size(); m++) {
    			historyCardsParm.append("," +historyCards.get(m).getCard());
    		}
    	} 
    	
    	return historyCardsParm.toString();
	}
	

}
