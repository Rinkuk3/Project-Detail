package com.td.mbna.msec.midtier.pinmanagement.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.api.kms.request.AddDecryptionJobRq;
import com.td.api.kms.request.AddEncryptionJobRq;
import com.td.api.kms.request.CipherData;
import com.td.api.kms.request.CryptographyKey;
import com.td.api.kms.request.Data;
import com.td.api.kms.request.DecryptionEvent;
import com.td.api.kms.request.EncryptionEvent;

public class RestServiceUtil {
	
	public static AddEncryptionJobRq createEncryptRequest(Map<String, Object> paramValues) {
	
		
		AddEncryptionJobRq cryptionRequest = new AddEncryptionJobRq();
		
		List<CryptographyKey> cryptographyKeyList = new ArrayList<CryptographyKey>();
		
		
		CryptographyKey cryptographyKeyOne = new CryptographyKey();
		cryptographyKeyOne.setTypeName(MSECConstants.PIN_Encryption_Key);
		cryptographyKeyOne.setKeyVal((String) paramValues.get(MSECConstants.SINGLE_USER_KEY));
		cryptographyKeyOne.setCheckDigitVal((String) paramValues.get(MSECConstants.CDV));
		
		cryptographyKeyList.add(cryptographyKeyOne);
		
		CryptographyKey cryptographyKeyTwo = new CryptographyKey();
		cryptographyKeyTwo.setTypeName(MSECConstants.Zone_PIN_Key);
		cryptographyKeyTwo.setKeyId((String) paramValues.get(MSECConstants.ZPK_ALIAS));
		
		cryptographyKeyList.add(cryptographyKeyTwo);
		
		CryptographyKey cryptographyKeyThree = new CryptographyKey();
		cryptographyKeyThree.setTypeName(MSECConstants.Web_Transport_Key);
		cryptographyKeyThree.setKeyId((String) paramValues.get(MSECConstants.WTK_ALIAS));

		cryptographyKeyList.add(cryptographyKeyThree);
		
		EncryptionEvent encryptionEvent = new EncryptionEvent();
		
		
		Data data = new Data();
		data.setEncodingSchemeTypeCd(MSECConstants.ENCODINGS_SCHEMA_TYPE);
		data.setPlainTxt((String) paramValues.get(MSECConstants.PIN_BLOCK));
		
		encryptionEvent.setCryptographyKey(cryptographyKeyList);
		encryptionEvent.setData(data);
		
		cryptionRequest.setEncryptionEvent(encryptionEvent);
		
		return cryptionRequest;
		
	}
	
	public static AddDecryptionJobRq createDecryptRequest(Map<String, Object> paramValues) {
		
		
		AddDecryptionJobRq addDecryptionJobRq = new AddDecryptionJobRq();
		
		List<CryptographyKey> cryptographyList = new ArrayList<CryptographyKey>();
		
		CryptographyKey zonePinKey = new CryptographyKey();
		zonePinKey.setTypeName(MSECConstants.Zone_PIN_Key);
		zonePinKey.setKeyId((String) paramValues.get(MSECConstants.ZPK_ALIAS));
		
		CryptographyKey webTransportKey = new CryptographyKey();
		webTransportKey.setTypeName(MSECConstants.Web_Transport_Key);
		webTransportKey.setKeyId((String) paramValues.get(MSECConstants.WTK_ALIAS));
		
		cryptographyList.add(zonePinKey);
		cryptographyList.add(webTransportKey);
		
		CipherData cipherData = new CipherData();
		cipherData.setEncodingSchemeTypeCd(MSECConstants.Hex_Binary);
		cipherData.setCipherTxt((String) paramValues.get(MSECConstants.TSYSPinBlock));
		
		DecryptionEvent decryptionEvent = new DecryptionEvent();
		decryptionEvent.setCryptographyKey(cryptographyList);
		decryptionEvent.setCipherData(cipherData);

		addDecryptionJobRq.setDecryptionEvent(decryptionEvent);
		
		return addDecryptionJobRq;
		
	}

}
