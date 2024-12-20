package com.td.mbna.msec.midtier.enrollment.adaptor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.td.api.enrollment.retrieve.ProductCustomer;
import com.td.api.enrollment.retrieve.Relationship;
import com.td.api.enrollment.retrieve.RetrieveProductCustomer;
import com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.ResponsePayload;
import com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentResponse;
import com.td.mbna.msec.midtier.types.common.CustAcctType;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

@Component
public class TdEnrollmentAdaptor {

    MbnaLogger logger = new MbnaLogger(TdEnrollmentAdaptor.class);

    private static final String MDMKEY = "MDMKEY";
    private static final String MBNA_PRODUCT_CD = "WEBMBNA";

    public RetrieveEnrollmentResponse convertToEnrollmentResponse(RetrieveProductCustomer retrieveProductCustomer,String connectId) {

    	String methodName = "TdEnrollmentAdaptor::convertToEnrollmentResponse";
        //check if customer is enrolled in any account
        //throwing runtime exception since there is no business exception for this
        if ( retrieveProductCustomer == null || retrieveProductCustomer.getProductCustomer() == null || retrieveProductCustomer.getProductCustomer().size() == 0) {
        	String message = "no customer found in enrollments API with connectId="+connectId;
        	logger.error(methodName, message);
            throw ExceptionUtil.genBusinessException(message);
        }

        //check if enrolled in webmbna

        List<ProductCustomer> mbnaEnrollment = retrieveProductCustomer.getProductCustomer().stream().filter( anEnrollment -> anEnrollment.getProductCd().equalsIgnoreCase(MBNA_PRODUCT_CD)).collect(Collectors.toList());

        //this should not happen, if it does
        //throwing runtime exception since there is no business exception for this
        if (mbnaEnrollment == null || mbnaEnrollment.size() == 0 ) {
        	String message = "no "+MBNA_PRODUCT_CD+" found in enrollments API with connectId="+connectId;
        	logger.error(methodName, message);
        	throw ExceptionUtil.genBusinessException(message);
        }

        Optional<Relationship> relationship = mbnaEnrollment.get(0).getRelationship().stream().filter(aRelationship -> aRelationship.getRelationshipCd().equalsIgnoreCase(MDMKEY)).findFirst();

        //this should not happen, if it does
        //throwing runtime exception since there is no business exception for this
        if (!relationship.isPresent()) {
        	String message = "no "+MDMKEY+" found in enrollments API with connectId="+connectId;
        	logger.error(methodName, message);
        	throw ExceptionUtil.genBusinessException(message);
        }

        RetrieveEnrollmentResponse retrieveEnrollmentResponse = new RetrieveEnrollmentResponse();
        ResponsePayload responsePayload = new ResponsePayload();
        retrieveEnrollmentResponse.setResponsePayload(responsePayload);

        responsePayload.setCustId(relationship.get().getRelationshipVal());

        responsePayload.setEnrolledAccts(mbnaEnrollment.stream().map( anEnrollment -> {
            CustAcctType custAcctType = new CustAcctType();
            custAcctType.setAcctNum(anEnrollment.getProductVal());
            return custAcctType;
        }).collect(Collectors.toList()));


        return retrieveEnrollmentResponse;
    }

}
