package com.td.mbna.msec.midtier.util;

import java.util.HashMap;
import java.util.Map;

public class SpecialCharsUtil {

	private static MbnaLogger logger = new MbnaLogger(SpecialCharsUtil.class);

	private static Map<String, String> frenchSpecialCharsCodeMap;
	
	static{
		
		frenchSpecialCharsCodeMap = new HashMap<String, String>();
		
		try{
			initFrenchSpecialCharsCodeMap();		
		}
		catch(Throwable ex) {
			logger.error("Could not initialize SpecialCharsUtil", ex);
		}
		
	}
	public static void initFrenchSpecialCharsCodeMap(){
		if (frenchSpecialCharsCodeMap == null) { 
			frenchSpecialCharsCodeMap = new HashMap<String, String>(); 
		}
		
		frenchSpecialCharsCodeMap.put("\u00E0", "E0");	
		frenchSpecialCharsCodeMap.put("\u00E1", "E1");	
		frenchSpecialCharsCodeMap.put("\u00E2", "E2");	
		frenchSpecialCharsCodeMap.put("\u00E3", "E3");	
		frenchSpecialCharsCodeMap.put("\u00E4", "E4");	
		frenchSpecialCharsCodeMap.put("\u00E5", "E5");	
		frenchSpecialCharsCodeMap.put("\u00E6", "E6");	
		frenchSpecialCharsCodeMap.put("\u00E7", "E7");	
		frenchSpecialCharsCodeMap.put("\u00E8", "E8");	
		frenchSpecialCharsCodeMap.put("\u00E9", "E9");
		
		frenchSpecialCharsCodeMap.put("\u00EA", "H0");	
		frenchSpecialCharsCodeMap.put("\u00EB", "H1");	
		frenchSpecialCharsCodeMap.put("\u00EC", "H2");	
		frenchSpecialCharsCodeMap.put("\u00ED", "H3");	
		frenchSpecialCharsCodeMap.put("\u00EE", "H4");	
		frenchSpecialCharsCodeMap.put("\u00EF", "H5");
		
		frenchSpecialCharsCodeMap.put("\u00F0", "F0");	
		frenchSpecialCharsCodeMap.put("\u00F1", "F1");	
		frenchSpecialCharsCodeMap.put("\u00F2", "F2");	
		frenchSpecialCharsCodeMap.put("\u00F3", "F3");	
		frenchSpecialCharsCodeMap.put("\u00F4", "F4");	
		frenchSpecialCharsCodeMap.put("\u00F5", "F5");	
		frenchSpecialCharsCodeMap.put("\u00F6", "F6");	
		frenchSpecialCharsCodeMap.put("\u00F9", "F9");
		
		frenchSpecialCharsCodeMap.put("\u00FA", "K0");	
		frenchSpecialCharsCodeMap.put("\u00FB", "K1");	
		frenchSpecialCharsCodeMap.put("\u00FC", "K2");	
		frenchSpecialCharsCodeMap.put("\u00FD", "K3");	
		frenchSpecialCharsCodeMap.put("\u00FE", "K4");	
		frenchSpecialCharsCodeMap.put("\u00FF", "K5");
		
		frenchSpecialCharsCodeMap.put("\u00C0", "C0");	
		frenchSpecialCharsCodeMap.put("\u00C1", "C1");	
		frenchSpecialCharsCodeMap.put("\u00C2", "C2");	
		frenchSpecialCharsCodeMap.put("\u00C3", "C3");	
		frenchSpecialCharsCodeMap.put("\u00C4", "C4");	
		frenchSpecialCharsCodeMap.put("\u00C5", "C5");	
		frenchSpecialCharsCodeMap.put("\u00C6", "C6");	
		frenchSpecialCharsCodeMap.put("\u00C7", "C7");	
		frenchSpecialCharsCodeMap.put("\u00C8", "C8");	
		frenchSpecialCharsCodeMap.put("\u00C9", "C9");
		
		frenchSpecialCharsCodeMap.put("\u00CA", "S0");	
		frenchSpecialCharsCodeMap.put("\u00CB", "S1");	
		frenchSpecialCharsCodeMap.put("\u00CC", "S2");	
		frenchSpecialCharsCodeMap.put("\u00CD", "S3");	
		frenchSpecialCharsCodeMap.put("\u00CE", "S4");	
		frenchSpecialCharsCodeMap.put("\u00CF", "S5");
		
		frenchSpecialCharsCodeMap.put("\u00D0", "D0");	
		frenchSpecialCharsCodeMap.put("\u00D1", "D1");	
		frenchSpecialCharsCodeMap.put("\u00D2", "D2");	
		frenchSpecialCharsCodeMap.put("\u00D3", "D3");	
		frenchSpecialCharsCodeMap.put("\u00D4", "D4");	
		frenchSpecialCharsCodeMap.put("\u00D5", "D5");	
		frenchSpecialCharsCodeMap.put("\u00D6", "D6");	
		frenchSpecialCharsCodeMap.put("\u00D9", "D9");
		
		frenchSpecialCharsCodeMap.put("\u00DA", "Z0");	
		frenchSpecialCharsCodeMap.put("\u00DB", "Z1");	
		frenchSpecialCharsCodeMap.put("\u00DC", "Z2");	
		frenchSpecialCharsCodeMap.put("\u00DD", "Z3");
		
		frenchSpecialCharsCodeMap.put("\u2019", "\'");	
	}

	public static Map<String, String> getFrenchSpecialCharsCodeMap(){
		return frenchSpecialCharsCodeMap;
	}
	
	
	
}
