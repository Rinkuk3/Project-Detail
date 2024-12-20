package com.td.mbna.msec.midtier.ofm.util;

import com.td.mbna.msec.midtier.types.common.EligIdType;

import java.util.*;

public final class EligibilityUtils {
    private final static Map<String, EligIdType> ALL_VALID_ELIGS = new HashMap<>();
    private final static List<String> PRIMARYUSER_VALID_ELIGS = new ArrayList<>(Arrays.asList(
            EligIdType.ORDER_ACCESS_CHEQUE.name(),EligIdType.ORDER_ACCESS_CHEQUE.value(),
            EligIdType.CREDIT_LINE_INCREASE.name(),EligIdType.CREDIT_LINE_INCREASE.value(),
            EligIdType.CREDIT_LINE_DECREASE.name(),EligIdType.CREDIT_LINE_DECREASE.value(),
            EligIdType.E_STATEMENT_DISPLAY.name(),EligIdType.E_STATEMENT_DISPLAY.value(),
            EligIdType.PAPER_SUPPRESSION.name(),EligIdType.PAPER_SUPPRESSION.value(),
            EligIdType.STANDARD_E_FORMS.name(),EligIdType.STANDARD_E_FORMS.value(),
            EligIdType.KYC_REFRESH.name(),EligIdType.KYC_REFRESH.value(),
            EligIdType.PAPER_STATEMENTS.name(),EligIdType.PAPER_STATEMENTS.value(),
            EligIdType.HARDCOPY_STATEMENTS.name(),EligIdType.HARDCOPY_STATEMENTS.value()
    ));

    static {
        for (EligIdType c : EligIdType.values()) {
            ALL_VALID_ELIGS.put(c.value(), c);
            ALL_VALID_ELIGS.put(c.name(), c); // include both name and value just in case
        }

    }

    public static boolean isValidEligId(String s) {
        return s != null && ALL_VALID_ELIGS.containsKey(s);
    }

    public static boolean isEligForPrimary(String s) {
        return s != null && PRIMARYUSER_VALID_ELIGS.contains(s);
    }
}
