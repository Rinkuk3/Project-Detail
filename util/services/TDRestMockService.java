package com.td.mbna.msec.midtier.util.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;
import org.springframework.mock.http.client.*;

public class TDRestMockService {

	private static MbnaLogger logger = new MbnaLogger(TDRestMockService.class);
	
    @ProfileLog
    public MockClientHttpResponse getMockResponse(String apiUrl) {
    	String mockHead = "https://localhost/MOCK_";
    	MockClientHttpResponse response = null;
    	
    	if (apiUrl.startsWith(mockHead)) {
    		String strEndPoint = apiUrl.substring(mockHead.length());
    		
    		if (strEndPoint.startsWith(MSECConstants.TD_AP_BRANCHES_ENDPT)) {
    			int indexBankNum = strEndPoint.indexOf("bankNum=");
    			int indexBranchNum = strEndPoint.indexOf("branchNum=");
    			
    			
    			String bankNum = strEndPoint.substring(indexBankNum + 8, indexBankNum + 11);
    			String branchNum = strEndPoint.substring(indexBranchNum + 10);
    			
    			String bankNameEn = getBankNameEn(bankNum);
    			String bankNameFr = getBankNameFr(bankNum);
    			String strResponse = "{\"branch\": [{\"financialInstitutionBankNum\": \"" + bankNum + 
    					"\",\"financialInstitutionName\": [{\"text\": \"" + bankNameEn + 
    					"\",\"languageCd\": \"EN\"},{\"text\": \"" + bankNameFr + 
    					"\",\"languageCd\": \"FR\"}],\"internalOrganizationBranchNum\": \"" + branchNum +
    					"\",\"financialInstitutionTypeName\": \"05\", \"locator\": {\"streetAddress\": {\"addressLine1\": \"2064 ROUTE 112\",\"city\": \"ST-CESAIRE\",\"territory\": \"QC\",\"postalCode\": \"J0L 1T0\"}}}]}";
    			logger.debug(apiUrl, strResponse);
    			
    			response = new MockClientHttpResponse(strResponse.getBytes(), HttpStatus.OK);
    			response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    		}
    	}
    	
    	return response;
    	
    }
//, languageCd=EN), FinancialInstitutionName(text=
    String getBankNameEn(String bankNum) {
       	
    	if ("001".equalsIgnoreCase(bankNum)) {
    		return "BANK OF MONTREAL";
    	} else if ("002".equalsIgnoreCase(bankNum)) {
    		return "BANK OF NOVA SCOTIA";
    	} else if ("003".equalsIgnoreCase(bankNum)) {
    		return "ROYAL BANK OF CANADA";
    	} else if ("004".equalsIgnoreCase(bankNum)) {
    		return "THE TORONTO-DOMINION BANK";
    	} else if ("006".equalsIgnoreCase(bankNum)) {
    		return "NATIONAL BANK OF CANADA";
    	} else if ("010".equalsIgnoreCase(bankNum)) {
    		return "CIBC";
    	} else if ("614".equalsIgnoreCase(bankNum)) {
    		return "TANGERINE BANK";
    	} else {
    		return "BANK NAME";
    	}
    	
    }

    String getBankNameFr(String bankNum) {
       	
    	if ("001".equalsIgnoreCase(bankNum)) {
    		return "BANQUE DE MONTRÉAL";
    	} else if ("002".equalsIgnoreCase(bankNum)) {
    		return "BANQUE DE NOUVELLE-ÉCOSSE";
    	} else if ("003".equalsIgnoreCase(bankNum)) {
    		return "BANQUE ROYALE DU CANADA";
    	} else if ("004".equalsIgnoreCase(bankNum)) {
    		return "LA BANQUE TORONTO-DOMINION";
    	} else if ("006".equalsIgnoreCase(bankNum)) {
    		return "BANQUE NATIONALE DU CANADA";
    	} else if ("010".equalsIgnoreCase(bankNum)) {
    		return "BANQUE CIBC";
    	} else if ("614".equalsIgnoreCase(bankNum)) {
    		return "BANQUE TANGERINE";
    	} else {
    		return "NOM DE BANQUE";
    	}
    	
    }
}
