package com.td.mbna.msec.midtier.offers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.offers.payload.updatebalanceprotectioninsurance.UpdateBalanceProtectionInsuranceRequest;
import com.td.mbna.msec.midtier.offers.payload.updatebalanceprotectioninsurance.UpdateBalanceProtectionInsuranceResponse;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysRequest;

@Component
public class UpdateBalanceProtectionInsuranceOperation implements MsecMidtierCommonOperations<com.td.mbna.msec.midtier.offers.payload.updatebalanceprotectioninsurance.UpdateBalanceProtectionInsuranceRequest, com.td.mbna.msec.midtier.offers.payload.updatebalanceprotectioninsurance.UpdateBalanceProtectionInsuranceResponse>
{

	@Autowired
	private ValangValidator updateBalanceProtectionInsuranceRequestValidator;

	private MsecValidator msecValidator;

	@PostConstruct
	private void init() {
		msecValidator = new MsecVlangValidator(updateBalanceProtectionInsuranceRequestValidator);
	}

	private static MbnaLogger logger = new MbnaLogger(UpdateBalanceProtectionInsuranceOperation.class);

	private final static String TdOp_updateBalanceProtectionInsurance = "updateBalanceProtectionInsurance";
	private final static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static final String BPI_REQUEST_INS_CODE = "bpi.request.ins_code";
	public static final String BPI_REQUEST_RATE_COVERAGE_TYPE = "bpi.request.rate.coverage_type";
	public static final String BPI_REQUEST_RATE_COVERAGE_CUSTOMERS = "bpi.request.rate.coverage_customers";
	public static final String BPI_REQUEST_SEQUENCE = "bpi.request.sequence";
	public static final String BPI_REQUEST_ENROLLMENT_CHANNEL = "bpi.request.enrollment_channel";

	public UpdateBalanceProtectionInsuranceResponse invokeService(UpdateBalanceProtectionInsuranceRequest request, String... token) {


		logger.debug("harryhan: this method is accessed invokeService(com.td.mbna.msec.midtier.offers.payload.updatebalanceprotectioninsurance.UpdateBalanceProtectionInsuranceRequest jsonRequest, String... token) in com.td.mbna.msec.midtier.offers.UpdateBalanceProtectionInsuranceOperation");
		UpdateBalanceProtectionInsuranceResponse response = null;

		try {
			String loginId = request.getSessionInfo().getLoginId();
			String acctNum = request.getAcctNum();

			final Map<String, Object> paramValues = TsysHelper.genStandardParams(TsysRequest.retrieveCreditCardAccount, request);
			paramValues.put("enrolledDate", dateFormatter.format(LocalDate.now()));
			paramValues.put("insCode", ConfigUtil.getProperty(BPI_REQUEST_INS_CODE));
			paramValues.put("coverageType", ConfigUtil.getProperty(BPI_REQUEST_RATE_COVERAGE_TYPE));
			paramValues.put("coverageCust", ConfigUtil.getProperty(BPI_REQUEST_RATE_COVERAGE_CUSTOMERS));
			paramValues.put("sequence", ConfigUtil.getProperty(BPI_REQUEST_SEQUENCE));
			paramValues.put("enrollmentChannel", ConfigUtil.getProperty(BPI_REQUEST_ENROLLMENT_CHANNEL));

			if (request.isMultiCard()) {
				paramValues.put("allCards",false);
				paramValues.put("cardNum",request.getCardNum());
			}

			JAXBContext mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.offers");

			response = (UpdateBalanceProtectionInsuranceResponse) BackEndSrvcUtil.invokeService(TdOp_updateBalanceProtectionInsurance, TdOp_updateBalanceProtectionInsurance,
						loginId, acctNum, acctNum,
						paramValues, paramValues,
						BackEndSrvcUtil.TDOperation.TdCreditCardAcctService_updateCreditCardAccount,
						mtJaxBContext);
			return response;

		} catch (Exception e) {
			logger.error("invokeService ", e.getMessage(), e);
			throw MidtierUtilHelper.prepareBusinessException("MS542", "MS542", e);
		}
	}

	@Override
	public boolean requiresDisclosureConsent() {
		return true;
	}

	@Override
	public String getConsentDisclosureFailedMsgCode() {
		return "MS542";
	}

	@Override
	public boolean generateAutoComment() {
		return false;
	}

	@Override
	public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
		return null;
	}

	@Override
	public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
		return null;
	}

	@Override
	public MsecValidator getValidator() {
		return msecValidator;
	}
}
