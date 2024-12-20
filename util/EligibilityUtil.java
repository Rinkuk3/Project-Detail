package com.td.mbna.msec.midtier.util;

import com.mbnaweb.xsd.types.common.EligIdType;
import com.mbnaweb.xsd.types.eligibility.EligType;
import java.util.*;

public class EligibilityUtil {

	private static List<String> eligIdValues;

	static {
		eligIdValues = Collections.synchronizedList(new ArrayList<>());
		EligIdType[] eligibilityArr = EligIdType.values();
		for (EligIdType eligId : eligibilityArr) {
			eligIdValues.add(eligId.value());
		}
	}

	public static boolean isAllowed(List<EligType> eligList, EligIdType elig) {
		if (eligList == null){
			return false;
		}
		for (EligType currElig : eligList) {
			if ((currElig.getEligId() != null) && (currElig.getEligId().equals(elig))){
				return currElig.isEligValue();
			}
		}
		return false;
	}

	/**
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/getEntitlementFlagsRs.xsl
	 * @param eligId
	 * @return
	 */
	public static boolean isValidEligId(String eligId) {
		if (eligId == null){
			return false;
		}
		return eligIdValues.contains(eligId);
	}

}