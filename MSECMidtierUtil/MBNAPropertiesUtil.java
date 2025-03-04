package com.td.mbna.msec.midtier.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Utility class to assist with pulling properties out of the MBNA Properties file in MT
 * In MT if a code is needed to be translated into the english description.
 * 
 * This code is intentionally not locale specific
 * @author cmoynes
 *
 */
public class MBNAPropertiesUtil {

	private final static String mbnaPropertiesENFilename = "/mbna.properties";

	private static MbnaLogger logger = new MbnaLogger(MBNAPropertiesUtil.class);

	private static Map<String, String> mbnaPropertiesEnglishMap;
	
	static{
		
		mbnaPropertiesEnglishMap = new HashMap<String, String>();
		
		try{
		
			Properties props = new Properties();
			props.load(MBNAPropertiesUtil.class.getResourceAsStream(mbnaPropertiesENFilename));
			
			for(Object keyObj : props.keySet()) {
				String key = (String)keyObj;
				String value = props.getProperty(key);
				mbnaPropertiesEnglishMap.put(key, value);
			}
		}
		catch(Throwable ex) {
			logger.error("Could not initialize CustomerNotesUtil", ex);
		}
		
	}
	
	/**
	 * Return the map of all mbna properties
	 * @return
	 */
	public static Map<String, String> getMBNAProperties(){
		return mbnaPropertiesEnglishMap;
	}
	
	/**
	 * Return the value for the specified key
	 * @param key
	 * @return
	 */
	public static String getMBNAPropertyValue(String key){
		return mbnaPropertiesEnglishMap.get(key);
	}
	
	/**
	 * Gets the List of all keys that match the specified value
	 * @param value
	 * @return List<key>
	 */
	public static List<String> getAllKeysForValue(String value){
		List<String> listOfKeysWithMatchingValue = new ArrayList<String>();
		for(Object keyObj : mbnaPropertiesEnglishMap.keySet()) {
			String elemKey = (String)keyObj;
			String elemValue = mbnaPropertiesEnglishMap.get(elemKey);
			if (value.equals(elemValue)){
				listOfKeysWithMatchingValue.add(elemKey);
			}
		}
		return listOfKeysWithMatchingValue;
	}
	
	/**
	 * Gets a list of all mbna property keys that match the specified value,
	 * and returns the first one that starts with the specified string
	 * @param value
	 * @param keyStarting
	 * @return key, or null if no match found
	 */
	public static String getAllKeysFromValueWithKeysStartingWith(String value, String keyStarting){
		List<String> keysMatchingValueMap = getAllKeysForValue(value);
		for (String key : keysMatchingValueMap) {
			if (key.startsWith(keyStarting))
				return key;
		}
		return null;
	}

	/**
	 * Gets the value in the mbna properties file for the mdm value specified
	 * 
	 * MDM values are stored in the mbna properties with a mbna key name.
	 * That mbna key name is used to get the mbna description key which in turn is used
	 * to retrieve the mbna description which is the mdm description
	 * ie.
	 * occupation.Professional52.key=52
	 * occupation.Professional52=Accountants (CPA, CGA, CMA)
	 * 
	 * mdmValue would be 52
	 * mbnaKeyStartsWith would be "occupation."
	 * mbnaKeyEndsWith would be ".key" 
	 * 
	 * @param mdmValue
	 * @param mbnaKeyStartsWith
	 * @param mbnaKeyEndsWith
	 * @return
	 */
	public static String getMBNADescriptionForMDMKey(String mdmValue, String mbnaKeyStartsWith, String mbnaKeyEndsWith) {
		//get the first mbna english key for the mdm value that starts with the specified string
		String mbnaKeyForMDMValue = getAllKeysFromValueWithKeysStartingWith(mdmValue, mbnaKeyStartsWith);
		
		if (mbnaKeyForMDMValue == null){
			return "";
		}
		
		//convert the mbnaKey to the key for the mbna description
		String occupationKey = mbnaKeyForMDMValue.substring(0, mbnaKeyForMDMValue.indexOf(".key"));
		
		//get the mbna description
		String mbnaDescription = getMBNAPropertyValue(occupationKey);
		
		return mbnaDescription;
	}

}