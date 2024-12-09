package com.td.mbna.msec.midtier.cardservice;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class ActivationUtil {

    private static final String STANDARD_ACTIVATION_MSG = "C001";
    private static final String NATURAL_EXPIRY_PCH_MSG = "C002";
    private static final String NATURAL_EXPIRY_AU_MSG = "C003";

    public enum LastRequestReason {

        ACE("ACE"), NEW("NEW"), REISSUE("REISSUE"),TRANSFER("TRANSFER"), SPECIAL("SPECIAL"), MASS_COMPROMISE("MASS COMPROMISE");

        private String value;

        private final static Map<String, LastRequestReason> CONSTANTS = new HashMap<>();

        static {
            Arrays.stream(LastRequestReason.values()).forEach( aValue -> CONSTANTS.put(aValue.getValue(), aValue));
        }

        private LastRequestReason(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public static LastRequestReason getEnum(String value) {
        	LastRequestReason lastRequestReason = null;
			if(value != null){
				lastRequestReason = CONSTANTS.get(value.toUpperCase());
			}

            //this shouldn't happen unless API returns a new value
            if (lastRequestReason == null) {
                throw new IllegalArgumentException(value + " is not a recognized LastRequestReason");
            }

            return lastRequestReason;
        }

    }

    public boolean canAUActivate(LastRequestReason lastRequestReason) {

        switch (lastRequestReason) {

            case ACE:
                return false;
            case NEW:
                return true;
            case REISSUE:
                return false;
            case TRANSFER:
                return true;
            case MASS_COMPROMISE:
                 return true;
            case SPECIAL:
                return true;
        }

        return false;
    }


	public boolean canPCHActivateAll(LastRequestReason lastRequestReason) {

		switch (lastRequestReason) {

			case ACE:
				return true;
			case NEW:
				return false;
			case REISSUE:
				return true;
			case TRANSFER:
				return true;
			case SPECIAL:
				return false;
			default:
				break;
		}

		return false;

	}



    public String findMessageCode(LastRequestReason lastRequestReason,boolean isPrimaryCardHolder) {

        switch(lastRequestReason) {

            case ACE:
                return STANDARD_ACTIVATION_MSG;
            case NEW:
                return STANDARD_ACTIVATION_MSG;
            case REISSUE:
                if (isPrimaryCardHolder) {
                    return NATURAL_EXPIRY_PCH_MSG;
                } else {
                    return NATURAL_EXPIRY_AU_MSG;
                }
            case TRANSFER:
                return STANDARD_ACTIVATION_MSG;
            case MASS_COMPROMISE:
                return STANDARD_ACTIVATION_MSG;
            case SPECIAL:
                return STANDARD_ACTIVATION_MSG;
        }
        return null;
    }
}
